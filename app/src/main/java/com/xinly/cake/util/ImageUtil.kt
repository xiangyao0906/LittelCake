package com.xinly.cake.util

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

/**
 * 图片工具类
 * <p>
 * Created by zm on 2019-08-07.
 */
object ImageUtil {

    /**
     * 保存图片到指定路径
     *
     * @param context
     * @param bitmap   要保存的图片
     * @param fileName 自定义图片名称
     * @return
     */
    fun saveImageToGallery(context: Context, bitmap: Bitmap, fileName: String): Boolean {
        // 保存图片至指定路径
        val storePath = FilePathUtil.getImage()
        val appDir = File(storePath)
        val file = File(appDir, fileName)
        try {
            val fos = FileOutputStream(file)
            //通过io流的方式来压缩保存图片(80代表压缩20%)
            val isSuccess = bitmap.compress(Bitmap.CompressFormat.PNG, 80, fos)
            fos.flush()
            fos.close()

            //发送广播通知系统图库刷新数据
            val uri = Uri.fromFile(file)
            context.sendBroadcast(Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri))
            return isSuccess
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return false
    }

    /**
     * 获取图片地址Uri
     * @param fileName 文件名称
     * @return
     */
    fun getImageUri(fileName: String): Uri {
        //获取文件路径
        val filePath = FilePathUtil.getImage() + fileName
        val file = File(filePath)
        return UriHelper.fromFile(file)
    }

    /**
     * 查看文件是否存在
     * @return
     */
    fun checkFileExists(fileName: String): Boolean {
        //获取文件路径
        val filePath = FilePathUtil.getImage() + fileName
        return File(filePath).exists()
    }
}