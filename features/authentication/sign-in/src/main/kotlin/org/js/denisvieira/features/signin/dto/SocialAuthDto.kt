package org.js.denisvieira.features.signin.dto

import android.graphics.Bitmap
import java.util.*

data class SocialAuthDto(
    var name: String = "",
    var email: String = "",
    var birthdayDate: Date,
    var token: String,
    var tokenType: Int,
    var socialId: String,
    var profileImage: Bitmap?
)
