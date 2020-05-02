package com.xinly.cake.module.video

import android.content.res.Configuration
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gyf.immersionbar.ImmersionBar
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import com.xinly.cake.BR
import com.xinly.cake.R
import com.xinly.cake.base.BaseMVVMActivity
import com.xinly.cake.databinding.VideoBinding
import com.xinly.core.ui.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_video_details.*

class VideoDetailsActivity : BaseActivity<VideoBinding, VideoViewModel>() {

    private var orientationUtils: OrientationUtils? = null
    private var isPlay = false
    private val isPause = false
    private val url =
        "http://www.hljlzy.com/__local/3/02/47/2B18A9AAF148DCCA5E80E681361_85FE12AB_8178702.mp4?e=.mp4"

    override fun initContentViewId(savedInstanceState: Bundle?): Int =
        R.layout.activity_video_details

    override fun initVariableId(): Int = BR.viewModel


    override fun initData() {
        super.initData()

        //内置封面可参考SampleCoverVideo
        val imageView = ImageView(this)
        loadCover(imageView, url)

        val seekRatio = GSYVideoOptionBuilder()
            .setThumbImageView(imageView)
            .setUrl(url)
            .setCacheWithPlay(true)
            .setVideoTitle("")
            .setIsTouchWiget(true)
            .setRotateViewAuto(true)
            .setLockLand(false)
            .setFullHideStatusBar(true)
            .setAutoFullWithSize(false)
            .setShowFullAnimation(false) //打开动画
            .setNeedLockFull(true)
            .setSeekRatio(1f)
            .setVideoAllCallBack(object : GSYSampleCallBack() {

                override fun onPrepared(url: String?, vararg objects: Any?) {
                    super.onPrepared(url, *objects)

                    //开始播放了才能旋转和全屏
                    orientationUtils!!.isEnable = true
                    isPlay = true
                }

                override fun onQuitFullscreen(url: String?, vararg objects: Any?) {
                    if (orientationUtils != null) {
                        orientationUtils!!.backToProtVideo()
                    }
                }

            }).setLockClickListener { _, lock ->
                if (orientationUtils != null) {
                    //配合下方的onConfigurationChanged
                    orientationUtils!!.isEnable = !lock
                }
            }


        seekRatio.build(detail_player)


        detail_player.fullscreenButton
            .setOnClickListener { //直接横屏
                orientationUtils!!.resolveByClick()
                //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                detail_player.startWindowFullscreen(this, true, true)


            }


        //外部辅助的旋转，帮助全屏
        orientationUtils = OrientationUtils(this, detail_player)
        //初始化不打开外部的旋转
        orientationUtils?.isEnable = false


    }

    private fun loadCover(
        imageView: ImageView,
        url: String
    ) {
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        imageView.setImageResource(R.mipmap.xxx1)
        Glide.with(this.applicationContext)
            .setDefaultRequestOptions(
                RequestOptions()
                    .frame(3000000)
                    .centerCrop()
                    .error(R.mipmap.xxx2)
                    .placeholder(R.mipmap.xxx1)
            )
            .load(url)
            .into(imageView)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        //如果旋转了就全屏
        if (isPlay && !isPause) {
            detail_player.onConfigurationChanged(this, newConfig, orientationUtils, true, true)
        }
    }
}
