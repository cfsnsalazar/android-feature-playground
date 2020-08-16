package org.js.denisvieira.featureplayground.commons.systemservice

import android.content.ClipboardManager
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ClipboardFaceTest {

    private val clipboardFacade = ClipboardFacade.getInstance()

    val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    internal fun whenCalled_ShouldAddValueToClipboard() {
        clipboardFacade.addTextToClipboard(context, "333")

        val resultAfterCopy = getResult()

        assertEquals(resultAfterCopy, "333")
    }

    @Test
    internal fun shouldRemoveNonNumericValues() {
        clipboardFacade.addNumberToClipboard(context, "0000.0000.0000.0000 22")

        val resultAfterCopy = getResult()

        assertEquals(resultAfterCopy, "000000000000000022")
    }

    private fun getResult(): String? {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        return clipboard.primaryClip?.getItemAt(0)?.text?.toString()
    }
}
