package org.js.denisvieira.features.signin.dto

import android.graphics.Bitmap
import java.util.*


data class SignUpUserDto(
    var name: String = "",
    var email: String = "",
    var password: String= "",
    var birthdayDate: Date? = null,
    var perfilImage: Bitmap? = null
)
