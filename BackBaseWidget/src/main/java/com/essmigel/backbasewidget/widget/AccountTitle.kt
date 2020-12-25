package com.essmigel.backbasewidget.widget

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.essmigel.backbasewidget.R
import com.essmigel.backbasewidget.databinding.WidgetAccountTitleBinding

/**
 * Created by Masoud Darzi, Email : masouddarzi@gmail.com
 *
 */
class AccountTitle : LinearLayout {

    private lateinit var binding: WidgetAccountTitleBinding
    var title: String
        get() {
            return binding.widgetAccountTitleTitle.toString()
        }
        set(value) {
            binding.widgetAccountTitleTitle.text = value
        }

    var description: String
        get() {
            return binding.widgetAccountTitleDescription.toString()
        }
        set(value) {
            binding.widgetAccountTitleDescription.text = value
        }

    constructor(context: Context) : super(context) {
        initializeView(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initializeView(context, attrs)
    }

    constructor(
        context: Context,
        attrs: AttributeSet,
        defStyle: Int
    ) : super(context, attrs, defStyle) {
        initializeView(context, attrs)
    }

    private fun initializeView(context: Context, attrs: AttributeSet?) {
        orientation = VERTICAL
        binding = WidgetAccountTitleBinding.inflate(LayoutInflater.from(context), this)


        attrs?.let {
            val typedArray: TypedArray =
                context.obtainStyledAttributes(it, R.styleable.AccountTitle)

            if (typedArray.hasValue(R.styleable.AccountTitle_title)) {
                title = typedArray.getString(R.styleable.AccountTitle_title).toString()
            }

            if (typedArray.hasValue(R.styleable.AccountTitle_description)) {
                description = typedArray.getString(R.styleable.AccountTitle_description).toString()
            }

            typedArray.recycle()
        }
    }
}