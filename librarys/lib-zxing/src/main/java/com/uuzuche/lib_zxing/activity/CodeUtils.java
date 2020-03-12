package com.uuzuche.lib_zxing.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.os.Bundle;
import android.text.TextUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.uuzuche.lib_zxing.camera.BitmapLuminanceSource;
import com.uuzuche.lib_zxing.camera.CameraManager;
import com.uuzuche.lib_zxing.decoding.DecodeFormatManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;

/**
 * Created by aaron on 16/7/27.
 * 二维码扫描工具类
 */
public class CodeUtils {

    public static final String RESULT_TYPE = "result_type";
    public static final String RESULT_STRING = "result_string";
    public static final int RESULT_SUCCESS = 1;
    public static final int RESULT_FAILED = 2;

    public static final String LAYOUT_ID = "layout_id";



    /**
     * 解析二维码图片工具类
     * @param analyzeCallback
     */
    public static void analyzeBitmap(String path, AnalyzeCallback analyzeCallback) {

        /**
         * 首先判断图片的大小,若图片过大,则执行图片的裁剪操作,防止OOM
         */
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true; // 先获取原大小
        Bitmap mBitmap = BitmapFactory.decodeFile(path, options);
        options.inJustDecodeBounds = false; // 获取新的大小

        int sampleSize = (int) (options.outHeight / (float) 400);

        if (sampleSize <= 0)
            sampleSize = 1;
        options.inSampleSize = sampleSize;
        mBitmap = BitmapFactory.decodeFile(path, options);

        MultiFormatReader multiFormatReader = new MultiFormatReader();

        // 解码的参数
        Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>(2);
        // 可以解析的编码类型
        Vector<BarcodeFormat> decodeFormats = new Vector<BarcodeFormat>();
        if (decodeFormats == null || decodeFormats.isEmpty()) {
            decodeFormats = new Vector<BarcodeFormat>();

            // 这里设置可扫描的类型，我这里选择了都支持
            decodeFormats.addAll(DecodeFormatManager.ONE_D_FORMATS);
            decodeFormats.addAll(DecodeFormatManager.QR_CODE_FORMATS);
            decodeFormats.addAll(DecodeFormatManager.DATA_MATRIX_FORMATS);
        }
        hints.put(DecodeHintType.POSSIBLE_FORMATS, decodeFormats);
        // 设置继续的字符编码格式为UTF8
//         hints.put(DecodeHintType.CHARACTER_SET, "UTF8");
        // 设置解析配置参数
        multiFormatReader.setHints(hints);

        // 开始对图像资源解码
        Result rawResult = null;
        try {
            rawResult = multiFormatReader.decodeWithState(new BinaryBitmap(new HybridBinarizer(new BitmapLuminanceSource(mBitmap))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (rawResult != null) {
            if (analyzeCallback != null) {
                analyzeCallback.onAnalyzeSuccess(mBitmap, rawResult.getText());
            }
        } else {
            if (analyzeCallback != null) {
                analyzeCallback.onAnalyzeFailed();
            }
        }
    }
    /**
     * 解析二维码图片
     *
     * @param
     * @return
     */
    public static void decodeQR(String path,  AnalyzeCallback analyzeCallback ) {
        Bitmap srcBitmap= null;
        try {
            srcBitmap = loadBitmap(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<BarcodeFormat> formats = new ArrayList<BarcodeFormat>();
        formats.add(BarcodeFormat.QR_CODE);
         Map<DecodeHintType, Object> HINTS = new EnumMap<>(DecodeHintType.class);
        HINTS.put(DecodeHintType.POSSIBLE_FORMATS, formats);
        HINTS.put(DecodeHintType.CHARACTER_SET, "utf-8");
        Result result = null;
        if (srcBitmap != null) {
            int width = srcBitmap.getWidth();
            int height = srcBitmap.getHeight();
            int[] pixels = new int[width * height];
            srcBitmap.getPixels(pixels, 0, width, 0, 0, width, height);
            //新建一个RGBLuminanceSource对象
            RGBLuminanceSource source = new RGBLuminanceSource(width, height, pixels);
            //将图片转换成二进制图片
            BinaryBitmap binaryBitmap = new BinaryBitmap(new GlobalHistogramBinarizer(source));
            QRCodeReader reader = new QRCodeReader();//初始化解析对象
            try {
                result = reader.decode(binaryBitmap, HINTS);//开始解析
            } catch (NotFoundException e) {
                e.printStackTrace();
            } catch (ChecksumException e) {
                e.printStackTrace();
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }
        if (result != null) {
            if (analyzeCallback != null) {
                analyzeCallback.onAnalyzeSuccess(srcBitmap, result.getText());
            }
        } else {
            if (analyzeCallback != null) {
                analyzeCallback.onAnalyzeFailed();
            }
        }
    }
    /**
     * 生成二维码图片
     * @param text
     * @param w
     * @param h
     * @param logo
     * @return
     */
    public static Bitmap createImage(String text,int w,int h,Bitmap logo) {
        if (TextUtils.isEmpty(text)) {
            return null;
        }
        try {
            Bitmap scaleLogo = getScaleLogo(logo,w,h);

            int offsetX = w / 2;
            int offsetY = h / 2;

            int scaleWidth = 0;
            int scaleHeight = 0;
            if (scaleLogo != null) {
                scaleWidth = scaleLogo.getWidth();
                scaleHeight = scaleLogo.getHeight();
                offsetX = (w - scaleWidth) / 2;
                offsetY = (h - scaleHeight) / 2;
            }
            Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            //容错级别
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            //设置空白边距的宽度
            hints.put(EncodeHintType.MARGIN, 0);
            BitMatrix bitMatrix = new QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, w, h, hints);
            int[] pixels = new int[w * h];
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if(x >= offsetX && x < offsetX + scaleWidth && y>= offsetY && y < offsetY + scaleHeight){
                        int pixel = scaleLogo.getPixel(x-offsetX,y-offsetY);
                        if(pixel == 0){
                            if(bitMatrix.get(x, y)){
                                pixel = 0xff000000;
                            }else{
                                pixel = 0xffffffff;
                            }
                        }
                        pixels[y * w + x] = pixel;
                    }else{
                        if (bitMatrix.get(x, y)) {
                            pixels[y * w + x] = 0xff000000;
                        } else {
                            pixels[y * w + x] = 0xffffffff;
                        }
                    }
                }
            }
            Bitmap bitmap = Bitmap.createBitmap(w, h,
                    Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, w, 0, 0, w, h);
            return bitmap;
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Bitmap getScaleLogo(Bitmap logo,int w,int h){
        if(logo == null)return null;
        Matrix matrix = new Matrix();
        float scaleFactor = Math.min(w * 1.0f / 5 / logo.getWidth(), h * 1.0f / 5 /logo.getHeight());
        matrix.postScale(scaleFactor,scaleFactor);
        Bitmap result = Bitmap.createBitmap(logo, 0, 0, logo.getWidth(),   logo.getHeight(), matrix, true);
        return result;
    }

    /**
     * 解析二维码结果
     */
    public interface AnalyzeCallback{

        public void onAnalyzeSuccess(Bitmap mBitmap, String result);

        public void onAnalyzeFailed();
    }


    /**
     * 为CaptureFragment设置layout参数
     * @param captureFragment
     * @param layoutId
     */
    public static void setFragmentArgs(CaptureFragment captureFragment, int layoutId) {
        if (captureFragment == null || layoutId == -1) {
            return;
        }

        Bundle bundle = new Bundle();
        bundle.putInt(LAYOUT_ID, layoutId);
        captureFragment.setArguments(bundle);
    }

    public static void isLightEnable(boolean isEnable) {
        if (isEnable) {
            Camera camera = CameraManager.get().getCamera();
            if (camera != null) {
                Camera.Parameters parameter = camera.getParameters();
                parameter.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(parameter);
            }
        } else {
            Camera camera = CameraManager.get().getCamera();
            if (camera != null) {
                Camera.Parameters parameter = camera.getParameters();
                parameter.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(parameter);
            }
        }
    }

    private static Bitmap loadBitmap(String picturePath) throws FileNotFoundException {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(picturePath, opt);
        // 获取到这个图片的原始宽度和高度
        int picWidth = opt.outWidth;
        int picHeight = opt.outHeight;
        // 获取画布中间方框的宽度和高度
        int screenWidth = CameraManager.MAX_FRAME_WIDTH;
        int screenHeight = CameraManager.MAX_FRAME_HEIGHT;
        // isSampleSize是表示对图片的缩放程度，比如值为2图片的宽度和高度都变为以前的1/2
        opt.inSampleSize = 1;
        // 根据屏的大小和图片大小计算出缩放比例
        if (picWidth > picHeight) {
            if (picWidth > screenWidth)
                opt.inSampleSize = picWidth / screenWidth;
        } else {
            if (picHeight > screenHeight)
                opt.inSampleSize = picHeight / screenHeight;
        }
        // 生成有像素经过缩放了的bitmap
        opt.inJustDecodeBounds = false;
        bitmap = BitmapFactory.decodeFile(picturePath, opt);
        if (bitmap == null) {
            throw new FileNotFoundException("Couldn't open " + picturePath);
        }
        return bitmap;
    }
}
