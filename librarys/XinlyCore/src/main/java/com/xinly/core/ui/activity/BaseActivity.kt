package com.xinly.core.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.xinly.core.viewmodel.BaseViewModel
import com.xinly.core.viewmodel.BaseViewModel.ParameterField
import com.xinly.core.viewmodel.IBaseViewModel
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * 一个拥有DataBinding框架的基Activity
 * <p>
 * 这里根据项目业务可以换成你自己熟悉的BaseActivity, 但是需要继承RxAppCompatActivity,方便LifecycleProvider管理生命周期
 * <p>
 * Created by zm on 2019/3/27.
 */
abstract class BaseActivity<V : ViewDataBinding, VM : BaseViewModel> : BaseRxAppCompatActivity(), IBaseActivity {
    protected var viewModel: VM? = null
    protected lateinit var binding: V
    private var viewModelId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //页面参数方法
        initParam()
        //私有的初始化dataBinding和ViewModel方法
        initViewDataBinding(savedInstanceState)
        //私有的ViewModel与View的契约事件回调逻辑
        registerUIChangeLiveDataCallBack()
        //初始化数据
        initData()
        //页面事件监听的方法，一般用于ViewModel层转到View层的事件注册
        initViewObservable()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel?.let {
            //解除ViewModel生命周期感应
            lifecycle.removeObserver(it)
            //移除RxBus监听
            it.removeRxBus()
        }
        //取消DataBinding绑定
        binding.unbind()
    }

    private fun initViewDataBinding(savedInstanceState: Bundle?) {
        //DataBindingUtil类需要在project的build中配置 dataBinding {enabled true }, 同步后会自动关联android.databinding包
        binding = DataBindingUtil.setContentView(this, initContentViewId(savedInstanceState))
        viewModelId = initVariableId()
        viewModel = initViewModel() ?: createViewModel()
        //关联ViewModel
        binding.setVariable(viewModelId, viewModel)
        viewModel?.let {
            //让ViewModel拥有View的生命周期感应
            lifecycle.addObserver(it)
            //注入RxLifecycle生命周期
            it.injectLifecycleProvider(this)
            //注入context
            it.injectContext(this)
            //注册RxBus
            it.registerRxBus()
        }
    }

    /**
     * 创建ViewModel实例
     * @return VM
     */
    private fun createViewModel(): VM {
        sequence<Type> {
            val thisClass: Class<*> = this@BaseActivity.javaClass
            @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
            yield(thisClass.genericSuperclass!!)
        }.filter {
            it is ParameterizedType
        }.flatMap {
            (it as ParameterizedType).actualTypeArguments.asSequence()
        }.last {
            it is Class<*> && IBaseViewModel::class.java.isAssignableFrom(it)
        }.let {
            @Suppress("UNCHECKED_CAST")
            return createViewModel(this, it as Class<VM>)
        }
    }

    /**
     * =====================================================================
     **/
    //注册ViewModel与View的契约UI回调事件
    private fun registerUIChangeLiveDataCallBack() {
        viewModel?.uc?.apply {
            //跳转页面
            startActivityEvent.observe(this@BaseActivity, Observer { params->
                val clz: Class<*> = params[ParameterField.CLASS] as Class<*>
                val bundle: Bundle? = params[ParameterField.BUNDLE] as? Bundle
                startActivity(clz, bundle)
            })
            //关闭界面
            finishEvent.observe(this@BaseActivity, Observer {
                finish()
            })
            //关闭上一层
            onBackPressedEvent.observe(this@BaseActivity, Observer {
                onBackPressed()
            })
        }
    }

    /**
     * 跳转页面
     * @param clz 所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    fun startActivity(clz: Class<*>, bundle: Bundle?=null) {
        val intent = Intent(this, clz)
        bundle?.let {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    /**
     * =====================================================================
     **/
    override fun initParam() {
    }

    /**
     * 初始化根布局
     *
     * @return 布局layout的id
     */
    abstract fun initContentViewId(savedInstanceState: Bundle?): Int

    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
    abstract fun initVariableId(): Int

    /**
     * 初始化ViewModel
     *
     * @return 继承BaseViewModel的ViewModel
     */
    open fun initViewModel(): VM? {
        return null
    }

    override fun initData() {
    }

    override fun initViewObservable() {
    }

    /**
     * 创建ViewModel
     *
     * @param cls
     * @param <T>
     * @return T
     */
    open fun <T : ViewModel> createViewModel(activity: FragmentActivity, cls: Class<T>): T {
        return ViewModelProviders.of(activity)[cls]
    }
}
