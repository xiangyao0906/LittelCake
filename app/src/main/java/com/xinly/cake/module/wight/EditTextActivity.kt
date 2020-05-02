package com.xinly.cake.module.wight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.Observable
import com.xinly.cake.BR
import com.xinly.cake.R
import com.xinly.cake.base.BaseMVVMActivity
import com.xinly.cake.databinding.EditTextBinding
import com.xinly.core.widgets.DefaultTextWatcher
import kotlinx.android.synthetic.main.activity_edit_text.*

class EditTextActivity : BaseMVVMActivity<EditTextBinding,EditTextViewModel>() {


    override fun initContentViewId(savedInstanceState: Bundle?): Int =R.layout.activity_edit_text

    override fun initVariableId(): Int =BR.viewModel

    override fun initData() {
        super.initData()
        tradeNumEdit.addTextChangedListener(object :DefaultTextWatcher(){
            override fun afterTextChanged(s: Editable?) {

               var tempS= s.toString()
                if(tempS.isNotEmpty()){

                    if(tempS.toDouble()>123){
                        input.error="输入错误"
                    }else{
                        input.isErrorEnabled=false
                    }

                }


            }

        })



    }

}
