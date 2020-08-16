package org.js.denisvieira.featureplayground.commons.widget

import android.widget.TextView
import androidx.annotation.DrawableRes

fun TextView.setCompoundDrawablesWithIntrinsicBounds(
    @DrawableRes left: Int = 0,
    @DrawableRes top: Int = 0,
    @DrawableRes right: Int = 0,
    @DrawableRes bottom: Int = 0
) {
    setCompoundDrawablesWithIntrinsicBounds(
        left,
        top,
        right,
        bottom
    )
}
