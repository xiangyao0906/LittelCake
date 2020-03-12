package com.xinly.core.binding.viewadpater.image

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.xinly.core.ext.no

/**
 * Created by zm on 2019-06-30.
 */
object ViewAdapter {

    @BindingAdapter(value = ["url", "placeholderRes"], requireAll = false)
    @JvmStatic
    fun setImageUri(imageView: ImageView, url: String?, placeholderRes: Int) {
        url.isNullOrEmpty().no {
            //使用Glide框架加载图片
            Glide.with(imageView.context)
                .load(url)
                .apply(RequestOptions().placeholder(placeholderRes))
                .into(imageView)
        }
    }

    @BindingAdapter(value = ["src"], requireAll = true)
    @JvmStatic
    fun setImageRes(imageView: ImageView, src: Int) {
        imageView.setImageResource(src)
    }

    @BindingAdapter(value = ["bmp"], requireAll = true)
    @JvmStatic
    fun setImageBmp(imageView: ImageView, bitmap: Bitmap?) {
        bitmap?.let {
            imageView.setImageBitmap(bitmap)
        }
    }

    @BindingAdapter(value = ["circleImage", "placeholderRes"], requireAll = false)
    @JvmStatic
    fun setCircleImageUri(imageView: ImageView, url: String?, placeholderRes: Int) {
        url.isNullOrEmpty().no {
            //使用Glide框架加载图片
            Glide.with(imageView.context)
                .load(url)
                .apply(RequestOptions.bitmapTransform(CircleCrop()))
                .apply(RequestOptions().placeholder(placeholderRes))
                .into(imageView)
        }
    }
}