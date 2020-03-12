package com.xinly.wallet.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import com.xinly.core.ext.showAtCenter
import java.io.*


/**
 * Created xiangyao zm on 2019/8/7.
 */
object FileUtils {
    /**
     * 保存bitmap到本地
     *
     * @param bitmap
     * @return
     */
    fun saveBitmap(bitmap: Bitmap, path: String): Boolean {
        val savePath: String
        val filePic: File
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            savePath = path
        } else {
            "无法保存图片".showAtCenter()
            return false
        }
        try {
            filePic = File("$savePath.jpg")
            if (!filePic.exists()) {
                filePic.parentFile.mkdirs()
                filePic.createNewFile()
            }
            val fos = FileOutputStream(filePic)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
            fos.flush()
            fos.close()
        } catch (e: IOException) {
            e.printStackTrace()
            "保存图片发生错误".showAtCenter()
            return false
        }
        return true
    }

    private var bitmap1: Bitmap? = null

    /**
     * 创建一个位图的方法,切记通过工厂得到的位图不能通过矩阵进行一系列转换，必须重新创建一个
     * @param context
     */
    fun createBitmap(context: Context, pic: Int): Bitmap {

        val options = BitmapFactory.Options()
        options.inPreferredConfig = Bitmap.Config.ARGB_8888
        options.inBitmap = bitmap1
        bitmap1 =
            BitmapFactory.decodeResource(context.resources, pic).copy(Bitmap.Config.ARGB_8888, true)
        //直接创建一个位图
        return Bitmap.createBitmap(bitmap1!!)
    }

    /**
     * 复制文件/文件夹 若要进行文件夹复制，请勿将目标文件夹置于源文件夹中
     *
     * @param source   源文件（夹）
     * @param target   目标文件（夹）
     * @param isFolder 若进行文件夹复制，则为True；反之为False
     * @throws Exception
     */
    @Throws(Exception::class)
    fun copy(source: String, target: String, isFolder: Boolean) {
        if (isFolder) {
            File(target).mkdirs()
            val a = File(source)
            val file = a.list()
            var temp: File? = null
            for (i in file.indices) {
                temp = if (source.endsWith(File.separator)) {
                    File(source + file[i])
                } else {
                    File(source + File.separator + file[i])
                }
                if (temp.isFile) {
                    val input = FileInputStream(temp)
                    val output =
                        FileOutputStream(target + "/" + temp.name.toString())
                    val b = ByteArray(1024)
                    var len: Int
                    while (input.read(b).also { len = it } != -1) {
                        output.write(b, 0, len)
                    }
                    output.flush()
                    output.close()
                    input.close()
                }
                if (temp.isDirectory) {
                    copy(source + "/" + file[i], target + "/" + file[i], true)
                }
            }
        } else {
            var byteread = 0
            val oldfile = File(source)
            if (oldfile.exists()) {
                val inStream: InputStream = FileInputStream(source)
                val file = File(target)
                file.parentFile.mkdirs()
                file.createNewFile()
                val fs = FileOutputStream(file)
                val buffer = ByteArray(1024)
                while (inStream.read(buffer).also { byteread = it } != -1) {
                    fs.write(buffer, 0, byteread)
                }
                inStream.close()
                fs.close()
            }
        }
    }
}