package org.js.denisvieira.featureplayground.commons.utils

import android.text.style.StrikethroughSpan
import android.text.style.StyleSpan
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.instanceOf
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StringsUtilTest {

    @Test
    fun shouldReturnATextHighlighted() {
        val result = StringsUtil.highlightString(text, highlightedText)
        assertEquals(result.length, 11)
    }

    @Test
    fun shouldReturnAString() {
        val inputStream = javaClass.classLoader?.getResourceAsStream("json/sample.json")!!
        assertNotNull(StringsUtil.streamToString(inputStream))
    }

    @Test
    fun shouldReturnAStrikeThroughText() {
        val result = StringsUtil.strikeThroughString(text, highlightedText)
        assertEquals(result.length, 11)
    }

    @Test
    fun whenCallStrikeThroughText_shouldReturnCorrectSpan() {
        val result = StringsUtil.strikeThroughString(text, highlightedText)
        val spans = result.getSpans(0, result.length, Object()::class.java)

        assertThat(spans[0], instanceOf(StrikethroughSpan::class.java))
    }

    @Test
    fun whenCallHighlightString_shouldReturnCorrectSpan() {
        val result = StringsUtil.highlightString(text, highlightedText)
        val spans = result.getSpans(0, result.length, Object()::class.java)

        assertThat(spans[0], instanceOf(StyleSpan::class.java))
    }

    private companion object {
        private const val text = "Lorem ipsum"
        private const val highlightedText = "Lorem"
    }
}
