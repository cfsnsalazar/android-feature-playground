package org.js.denisvieira.featureplayground.commons.html

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import java.lang.reflect.Field
import java.lang.reflect.Modifier
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HtmlHelperTest {

    private companion object {
        private const val SDK_INT = "SDK_INT"
        private const val HTML = "<h1>My First Heading</h1>"
    }

    @Test
    fun whenHtmlPassed_ShouldReturnSpanned() {
        val result = HtmlHelper.fromHtml(HTML)

        assertNotNull(result)
    }

    @Test
    fun whenAPINotN_ShouldReturnNotFlagedOptin() {
        setFinalStatic(Build.VERSION::class.java.getField(SDK_INT), Build.VERSION_CODES.LOLLIPOP)

        val result = HtmlHelper.fromHtml(HTML)

        assertNotNull(result)
    }

    @Test
    fun whenAPIN_ShouldReturnFlagedOptin() {
        setFinalStatic(Build.VERSION::class.java.getField(SDK_INT), Build.VERSION_CODES.N)

        val result = HtmlHelper.fromHtml(HTML)

        assertNotNull(result)
    }

    private fun setFinalStatic(field: Field, newValue: Any) {
        field.isAccessible = true

        val modifiersField = Field::class.java.getDeclaredField("modifiers")
        modifiersField.isAccessible = true
        modifiersField.setInt(field, field.modifiers and Modifier.FINAL.inv())

        field.set(null, newValue)
    }
}
