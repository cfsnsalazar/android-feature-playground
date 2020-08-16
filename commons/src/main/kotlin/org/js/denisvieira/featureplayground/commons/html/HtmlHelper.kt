package org.js.denisvieira.featureplayground.commons.html

import android.os.Build
import android.text.Html
import android.text.Spanned

object HtmlHelper {

    fun fromHtml(body: String): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(body, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            Html.fromHtml(body)
        }
    }
}
