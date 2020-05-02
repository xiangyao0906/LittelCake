package com.xinly.cake.module.splash

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.tbruyelle.rxpermissions2.RxPermissions
import com.xinly.cake.R
import com.xinly.cake.model.constans.Constans
import com.xinly.cake.module.main.MainActivity
import com.xinly.cake.util.ActivityUtil

/**
 * 闪屏页
 * <p>
 * Create by zm on 2019/11/15.
 */
class SplashActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        RxPermissions(this).request(
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE)
            .subscribe{ grant ->
                if (grant) {
                    Handler().postDelayed({
                        if (!ActivityUtil.isActivityFinished(this)){
                            jumpControl()
                        }
                    }, 1000)
                }else {
                    finish()
                }

            }
    }

    /**
     * 跳转控制
     */
    private fun jumpControl() {
            jumpMain()
//            jumpGuide()
    }

    /**
     * 跳转至指南页
     */
    private fun jumpGuide() {
//        startActivity(Intent(this@SplashActivity, GuideActivity::class.java))
        finish()
    }
    /**
     * 跳转至主页
     */
    private fun jumpMain() {
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
