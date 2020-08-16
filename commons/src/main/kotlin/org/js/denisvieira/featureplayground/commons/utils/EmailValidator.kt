package org.js.denisvieira.featureplayground.commons.utils

import android.util.Patterns

class EmailValidator {

    fun isValid(email: String): Boolean =
        email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
