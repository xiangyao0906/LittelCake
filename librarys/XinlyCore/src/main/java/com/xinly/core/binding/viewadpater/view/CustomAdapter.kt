package com.xinly.core.binding.viewadpater.view

import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.xinly.core.widgets.CustomEdiText

object CustomAdapter {
    @BindingAdapter("xiangyao:text", requireAll = false)
    @JvmStatic
    fun setText(customEdiText: CustomEdiText, value: Double) {

        if (customEdiText.text.toString().isNotEmpty()) {
            if (customEdiText.text.toString().toDouble() != value) {
                customEdiText.setText(value.toString())
            }
        } else {
            customEdiText.setText(value.toString())
        }


    }

    @InverseBindingAdapter(attribute = "text", event = "addTextChangedListener")
    @JvmStatic
    fun getText(customEdiText: CustomEdiText): Double {

        val originalString = customEdiText.text.toString()

        val number: Boolean = originalString.matches(Regex("^(-?\\d+)(\\.\\d+)?\$"))

        if (originalString.isNotEmpty() && number) {
            return originalString.toDouble()
        }

        return 0.0
    }

    @BindingAdapter(value = ["addTextChangedListener"])
    @JvmStatic
    fun addTextChangedListener(view: CustomEdiText, listener: InverseBindingListener) {

        view.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                listener.onChange()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })


    }
}