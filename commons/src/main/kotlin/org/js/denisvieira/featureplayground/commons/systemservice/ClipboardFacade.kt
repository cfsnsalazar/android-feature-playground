package org.js.denisvieira.featureplayground.commons.systemservice

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import org.js.denisvieira.featureplayground.commons.utils.getNumbersOnly

class ClipboardFacade {

    companion object {
        fun getInstance(): ClipboardFacade {
            return ClipboardFacade()
        }
    }

    private fun getClipboard(context: Context): ClipboardManager {
        return context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    }

    fun addNumberToClipboard(context: Context, text: String) {
        addTextToClipboard(context, text.getNumbersOnly())
    }

    fun addTextToClipboard(context: Context, text: String) {
        val clipboard = getClipboard(context)

        val clip = ClipData.newPlainText("Copied Text", text)

        clipboard.setPrimaryClip(clip)
    }
}
