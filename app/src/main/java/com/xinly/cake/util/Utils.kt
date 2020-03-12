@file:Suppress("LABEL_NAME_CLASH")

package com.xinly.cake.util

import android.content.Context
import android.graphics.Bitmap
import java.io.ByteArrayOutputStream
import java.io.FileOutputStream

/**
 * Created by zm on 2019-07-21.
 */
object Utils {

    /**
     * Copies your database from your local assets-folder to the just created
     * empty database in the system folder, from where it can be accessed and
     * handled. This is done by transfering bytestream.
     */
    fun copyDataBase(context: Context, dbname: String) {
        // Open your local db as the input stream
        val inputStream = context.assets.open(dbname)
        // Path to the just created empty db
        val outFileName = context.getDatabasePath(dbname)

        if (!outFileName.exists()) {
            outFileName.parentFile.mkdirs()
            // transfer bytes from the inputfile to the outputfile
            val buffer = ByteArray(1024)
            // Open the empty db as the output stream
            FileOutputStream(outFileName).use { outputStream ->
                inputStream.use {
                    while (true) {
                        inputStream.read(buffer).let {
                            if (it > 0) {
                                outputStream.write(buffer, 0, it)
                            }else{
                                return@use
                            }
                        }

                    }
                }
            }
        }
    }

    fun bmpToByteArray(bmp: Bitmap, needRecycle: Boolean): ByteArray {
        return ByteArrayOutputStream().use {
            bmp.compress(Bitmap.CompressFormat.PNG, 100, it)
            if (needRecycle) {
                bmp.recycle()
            }
            it.toByteArray()
        }
    }

    /**
     * convert dip to px
     */
    @JvmStatic
    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * convert px to dp
     */
    @JvmStatic
    fun px2dip(context: Context, pxValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

}