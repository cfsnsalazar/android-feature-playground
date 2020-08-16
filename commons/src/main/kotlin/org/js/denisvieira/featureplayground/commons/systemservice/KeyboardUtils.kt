package org.js.denisvieira.featureplayground.commons.systemservice

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.showKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_FORCED)
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}

private const val SIZE_KEYBOARD = 250
fun View.setOnKeyboardOpenListener(function: (Boolean) -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener {
        val heightDiff: Int = rootView.height - height
        if (heightDiff > SIZE_KEYBOARD)
            function(true)
        else
            function(false)
    }
}
