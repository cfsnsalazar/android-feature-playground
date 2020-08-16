package org.js.denisvieira.featureplayground.commons.simple

import android.text.Editable
import android.text.TextWatcher

/**
 * Prevents us from implementing methods that will not be used when using TextWatcher
 */
open class SimpleTextWatcher : TextWatcher {
    override fun afterTextChanged(s: Editable) {
        // Not Implemented
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        // Not Implemented
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        // Not Implemented
    }
}
