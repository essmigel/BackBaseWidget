package com.essmigel.backbasewidget.utils

import android.view.View
import java.text.DecimalFormat

/**
 * Created by Masoud Darzi, Email : masouddarzi@gmail.com
 *
 */
fun View.visible(){
    visibility = View.VISIBLE
}
fun View.gone(){
    visibility = View.GONE
}

fun Float.formatWithSeparator():String{
    val decimalFormat = DecimalFormat("#,##0.00")
    return decimalFormat.format(this)
}