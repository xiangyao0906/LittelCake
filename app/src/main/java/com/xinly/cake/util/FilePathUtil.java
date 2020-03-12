package com.xinly.cake.util;

import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import com.xinly.cake.XinlyApplication;

import java.io.File;

/**
 * 文件路径
 * <p>
 * Created by zm on 2019/8/15.
 */

public class FilePathUtil {

    private static String getBaseDir(String childDir) {
        return Environment.getExternalStorageDirectory().getPath() + "/xinly/" + childDir;
    }

    public static String getAppUpdatePath() {
        return checkAndMkdirs(getBaseDir("/AppUpdate"));
    }

    public static String getCacheCrop() {
        return checkAndMkdirs(getBaseDir("cache/crop/"));
    }

    public static String getCacheImage() {
        return checkAndMkdirs(getBaseDir("cache/image/"));
    }

    public static String getCacheImagePick() {
        return checkAndMkdirs(getBaseDir("cache/image/")) + System.currentTimeMillis() + ".jpg";
    }

    public static String getCacheImageCrop() {
        return checkAndMkdirs(getBaseDir("cache/crop/")) + System.currentTimeMillis() + ".jpg";
    }

    public static String getCacheWeb() {
        return checkAndMkdirs(getBaseDir("cache/web/"));
    }

    public static String getCache() {
        return checkAndMkdirs(getBaseDir("cache/"));
    }

    public static String getImage() {
        return checkAndMkdirs(getBaseDir("image/"));
    }

    public static String getAdImage() {
        return checkAndMkdirs(getBaseDir("image/ad/"));
    }

    public static String getDbPath() {
        return checkAndMkdirs(getBaseDir(getBaseDir("cache/dbpath/")));
    }

    /**
     * 检查文件夹是否存在
     *
     * @param dir
     * @return
     */
    public static String checkAndMkdirs(String dir) {
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
        return dir;
    }

    public static String getPath(Uri uri) {
        String[] projection = {MediaStore.Video.Media.DATA};
        Cursor cursor = XinlyApplication.getContext().getContentResolver().query(uri, projection, null, null, null);
        assert cursor != null;
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
}
