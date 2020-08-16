package org.js.denisvieira.featureplayground.commons.utils

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StrikethroughSpan
import android.text.style.StyleSpan
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

object StringsUtil {

    /**
     * Highlight string changing color or textStile (to bold)
     *
     * @param text full string
     * @param highlightedText only the string to be highlight
     * @return returns spannable to be used
     */
    fun highlightString(
        text: String,
        vararg highlightedText: String,
        colorText: Int? = null
    ): Spannable {

        val spannable = SpannableString(text)

        for (item in highlightedText) {
            val start = text.indexOf(item)
            val end = start + item.length
            spannable.setSpan(
                StyleSpan(Typeface.BOLD), start, end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            colorText?.let {
                spannable.setSpan(
                    ForegroundColorSpan(colorText), start, end,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
        return spannable
    }

    fun streamToString(inputStream: InputStream): String {
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        return bufferedReader.use {
            it.readText()
        }
    }

    fun strikeThroughString(
        text: String,
        vararg strikeThroughText: String
    ): Spannable {

        val spannable = SpannableString(text)

        for (item in strikeThroughText) {
            val start = text.indexOf(item)
            val end = start + item.length
            spannable.setSpan(
                StrikethroughSpan(), start, end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        return spannable
    }
}

fun String.getNumbersOnly(): String {
    val regexNumbers = "[^0-9]+"
    return this.replace(regexNumbers.toRegex(), "")
}
