package com.xinly.cake

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.multidex.MultiDex
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.xinly.cake.util.AppFilePath
import com.xinly.cake.util.MultiLanguageUtils
import com.xinly.core.XinlyCore
import com.xinly.core.utils.SystemUtil
import com.xinly.cake.util.Utils


/**
 * Created by zm on 2019/5/10.
 */
open class XinlyApplication: Application() {
    //应用是否进入后台
    private var isRunInBackground = false
    private var appCount = 0

    //记录从前台切换到后台时的当前时间
    private var switchingTime: Long = 0L

    companion object {
        @SuppressLint("StaticFieldLeak")
        @JvmStatic
        lateinit var context: Context private set
    }

    override fun onCreate() {
        super.onCreate()

        //初始化日志框架
        SystemUtil.updateDeveloperLogControl(BuildConfig.DEBUG)

        //初始化核心库
        XinlyCore.init(applicationContext)

        AppFilePath.init(this)

        //监听应用前后台切换
        initBackgroundCallBack()

        //语言切换
        registerActivityLifecycleCallbacks(MultiLanguageUtils.callbacks)
    }

    override fun attachBaseContext(base: Context?) {
        //初始化全局context
        base?.let {
            context = it
        }
        super.attachBaseContext(MultiLanguageUtils.attachBaseContext(base))
        MultiDex.install(this)
    }

    //static 代码段可以防止内存泄露
    init {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout -> ClassicsHeader(context) }
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout -> ClassicsFooter(context).setDrawableSize(20f) }
    }

    /************************应用前后台切换******************************/
    private fun initBackgroundCallBack() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {

            }

            override fun onActivityResumed(activity: Activity?) {

            }

            override fun onActivityStarted(activity: Activity?) {
                appCount++
                if (isRunInBackground) {
                    //应用从后台回到前台 需要做的操作
                    activity?.let {
//                        back2App(it)
                    }

                }
            }

            override fun onActivityDestroyed(activity: Activity?) {

            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

            }

            override fun onActivityStopped(activity: Activity?) {
                appCount--
                if (appCount == 0) {
                    //应用进入后台 需要做的操作
                    activity?.let {
                        leaveApp(it)
                    }
                }
            }

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {

            }

        })
    }
    /**
     * 从后台回到前台需要执行的逻辑
     * @return activity
     */
    private fun back2App(activity: Activity) {
        isRunInBackground = false
        //从后台进入前台是否超过10分钟 10*16*1000
        if (System.currentTimeMillis()-switchingTime >= 10*60*1000L) {
            //跳转至安全认证
        }
    }
    /**
     * 离开应用 压入后台或者退出应用
     * @param activity
     */
    private fun leaveApp(activity: Activity) {
        isRunInBackground = true
        //记录从前台切换到后台的当前时间
        switchingTime = System.currentTimeMillis()
    }
}