package com.xinly.cake.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.xinly.wallet.util.FileUtils
import java.io.File

/**
 * 本地分享
 * <p>
 * Created by zm on 2019-11-21.
 */
object ShareLocalUtil {

    /**
     * 分享文字
     * @param text 内容
     * @param title 标题
     */
    fun shareText(context: Context, text: String, title: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.let {
            it.type = "text/plain"
            it.putExtra(Intent.EXTRA_TEXT, text)
        }
        context.startActivity(Intent.createChooser(intent, title))
    }

    /**
     * 分享应用
     * @param title 标题
     */
    fun shareApp(context: Context, title: String) {
        //获取apk
        val file = File(FilePathUtil.getCache()+"rec.apk")
        if (!file.exists()){
            val apkPath = context.packageResourcePath
            FileUtils.copy(apkPath, FilePathUtil.getCache() + "rec.apk", false)
        }

        val intent = Intent(Intent.ACTION_SEND)
        intent.let {
            it.type = "*/*"
            it.putExtra(Intent.EXTRA_STREAM,
                UriHelper.fromFile(File(FilePathUtil.getCache() + "rec.apk"))
            )
        }
        context.startActivity(Intent.createChooser(intent, title))
    }

    /**
     * 单张图片分享
     * @param context
     * @param uri
     * @param title
     */
    fun shareImage(context: Context, uri: Uri, title: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.let {
            it.type = "image/png"
            it.putExtra(Intent.EXTRA_STREAM, uri)
        }
        context.startActivity(Intent.createChooser(intent, title))
    }

    /**
     * 多张图片分享
     * @param context
     * @param imageUris
     * @param title
     */
    fun shareMoreImage(context: Context, imageUris: ArrayList<Uri>, title: String) {
        val intent = Intent(Intent.ACTION_SEND_MULTIPLE)
        intent.let {
            it.type = "image/png"
            it.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris)
        }
        context.startActivity(Intent.createChooser(intent, title))
    }
}