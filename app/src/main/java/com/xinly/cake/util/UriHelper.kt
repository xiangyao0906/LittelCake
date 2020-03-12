package com.xinly.cake.util

import android.net.Uri
import android.os.Build
import androidx.core.content.FileProvider
import com.xinly.cake.BuildConfig
import com.xinly.cake.XinlyApplication
import java.io.File

/**
 * Created by zm on 2019-11-21.
 */
object UriHelper {

    fun fromFile(file: File): Uri {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            FileProvider.getUriForFile(XinlyApplication.context, "${BuildConfig.APPLICATION_ID}.fileprovider", file)
        }else{
            Uri.fromFile(file)
        }
    }
}