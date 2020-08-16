package org.js.denisvieira.featureplayground.commons.widget

import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import org.js.denisvieira.featureplayground.commons.systemservice.hideKeyboard

fun EditText.setEnterActionListener(action: () -> Unit) {
    this.setOnEditorActionListener { textView, actionId, event ->
        var handled = false
        if (isKeyEventEnter(event) || isActionDone(actionId)) {
            this.clearFocus()
            this.hideKeyboard()
            action()
            handled = true
        }
        handled
    }
}

fun EditText.removeEnterActionListener() {
    this.setOnEditorActionListener { textView, actionId, event ->
        false
    }
}

private fun isKeyEventEnter(event: KeyEvent?) = event != null && event.keyCode == KeyEvent.KEYCODE_ENTER

private fun isActionDone(actionId: Int) = actionId == EditorInfo.IME_ACTION_DONE
