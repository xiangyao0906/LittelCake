package com.xinly.cake.module.record

import VideoHandle.EpVideo
import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import android.view.View
import com.joe.camera2recorddemo.View.CameraRecordView
import com.xinly.cake.R
import com.xinly.cake.util.RecorderUtils
import com.xinly.cake.util.VoiceManager
import com.xinly.cake.widget.RecordButton
import com.xinly.cake.widget.Xrecprogressbar
import com.xinly.core.ext.showAtCenter
import kotlinx.android.synthetic.main.activity_recx.*
import java.io.IOException

class RecordActivity : Activity() {
    private val STATE_INIT = 0
    private val STATE_RECORDING = 1
    private val STATE_PAUSE = 2
    private var mRecorderState = 0
    private val mCurrBgmPath: String? = null
    private var videos: ArrayList<EpVideo>? = null
    private var isStop = false
    private lateinit var mCurrPath: String
    private lateinit var mXbar: Xrecprogressbar

    private lateinit var mRecordView: CameraRecordView
    private lateinit var mRecordBtn: RecordButton

    private var handler = Handler(Handler.Callback { msg ->
        progress_ing.visibility = View.GONE
        when (msg.what) {
            RecorderUtils.ACTIVATE_BTN -> mRecordBtn.isEnabled = true
            RecorderUtils.MUSIC_SUCCESS -> intentPreview(mCurrPath)
            RecorderUtils.MERGE_FAILURE -> getString(R.string.flatten_failure).showAtCenter()
        }
        false
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_recx)

        initData()
    }


     fun initData() {

        mRecordView=findViewById(R.id.surfaceView)
        mRecordBtn=findViewById(R.id.btn_rec)
        mXbar=findViewById(R.id.xpbar)

        mCurrPath=""
        videos= ArrayList()

        mRecordBtn.setOnClickListener {

            if (mRecorderState == STATE_INIT) {
                if (!mXbar.isNotOver) {
                    getString(R.string.delete_some).showAtCenter()
                    return@setOnClickListener
                }
                if (!TextUtils.isEmpty(mCurrBgmPath)) {
                    VoiceManager.instance().play(mCurrBgmPath)
                    var msec: Int = mXbar.currentPro - 1800
                    if (msec < 0) {
                        msec = 0
                    }
                    VoiceManager.instance().seek(msec)
                }

                //开始录制视频
                if (startRecord(RecorderUtils.getVideoFileByTime())) {
                    mRecorderState = STATE_RECORDING
                    mXbar.record()
                    refreshControlUI()
                }
            } else if (mRecorderState == STATE_RECORDING) {
                //停止视频录制
                VoiceManager.instance().pause()
                stopRecord()
                mRecorderState = STATE_INIT
                refreshControlUI()
            }

        }



    }

    /**
     * 开始录制
     *
     * @return
     */
    private fun startRecord(path: String): Boolean {
        try {
            Log.e("xuan", "开始录制：$path")
            mRecordView.startRecord(path)
            videos?.add(EpVideo(path))
        } catch (e: IOException) {
            e.printStackTrace()
            return false
        }
        return true
    }

    private fun refreshControlUI() {
        if (mRecorderState == STATE_RECORDING) {
            //1s后才能按停止录制按钮
            mRecordBtn.isEnabled = false
            handler.sendEmptyMessageDelayed(RecorderUtils.ACTIVATE_BTN, 1000)
            mRecordBtn.record()
            rl_more.visibility = View.GONE
            ll_select_music.visibility = View.INVISIBLE
            mXbar.record()
        } else if (mRecorderState == STATE_INIT) {
            mRecordBtn.pause()
            mXbar.pause()
            rl_more.visibility = View.VISIBLE
        }
    }

    /**
     * 跳转到视频预览界面
     */
    private fun intentPreview(filePath: String) {
        isStop = true
        videos!!.clear()
        mXbar.reset()
        ll_select_music.visibility = View.VISIBLE


        "跳转到预览页面".showAtCenter()

    }

    /**
     * 结束录制
     *
     * @return
     */
    private fun stopRecord(): Boolean {
        try {
            mRecordView.stopRecord()
        } catch (e: InterruptedException) {
            e.printStackTrace()
            return false
        }
        return true
    }
}