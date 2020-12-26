package com.essmigel.backbasewidget.widget

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.IntDef
import com.essmigel.backbasewidget.R
import com.essmigel.backbasewidget.databinding.WidgetAmountTextBinding
import com.essmigel.backbasewidget.utils.formatWithSeparator
import com.essmigel.backbasewidget.utils.gone
import com.essmigel.backbasewidget.utils.visible
import kotlin.math.abs

/**
 * Created by Masoud Darzi, Email : masouddarzi@gmail.com
 *
 */
class AmountText : LinearLayout {
    private lateinit var binding: WidgetAmountTextBinding

    private var amountFloat: Float = 0f

    var amount: Float
        get() {
            return amountFloat
        }
        set(value) {
            amountFloat = value
            if (amount >= 0) {
                binding.widgetAmountTextMinus.gone()
                binding.widgetAmountTextAmount.setTextColor(Color.BLACK)
            } else {
                binding.widgetAmountTextMinus.visible()
                binding.widgetAmountTextAmount.setTextColor(Color.RED)
            }
            binding.widgetAmountTextAmount.text = abs(value).formatWithSeparator()
        }

    @DesignType
    var designType: Int = SYMBOL
        set(value) {
            when (value) {
                SYMBOL -> {
                    binding.widgetAmountTextSymbol.visibility = View.VISIBLE
                    binding.widgetAmountTextCode.visibility = View.GONE
                }
                CODE -> {
                    binding.widgetAmountTextCode.visibility = View.VISIBLE
                    binding.widgetAmountTextSymbol.visibility = View.GONE
                }
                else -> {
                    binding.widgetAmountTextSymbol.visibility = View.VISIBLE
                    binding.widgetAmountTextCode.visibility = View.GONE
                }
            }
            field = value
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
        orientation = HORIZONTAL
        binding = WidgetAmountTextBinding.inflate(LayoutInflater.from(context), this)


        attrs?.let {
            val typedArray: TypedArray =
                context.obtainStyledAttributes(it, R.styleable.AmountText)

            if (typedArray.hasValue(R.styleable.AmountText_amount)) {
                amount = typedArray.getFloat(R.styleable.AmountText_amount, 0f)
            }

            if (typedArray.hasValue(R.styleable.AmountText_design)) {
                designType = typedArray.getInt(R.styleable.AmountText_design, SYMBOL)
            }

            typedArray.recycle()
        }
    }

    companion object {

        @IntDef(SYMBOL, CODE)
        @Retention(AnnotationRetention.SOURCE)
        annotation class DesignType

        const val SYMBOL = 0
        const val CODE = 1
    }
}