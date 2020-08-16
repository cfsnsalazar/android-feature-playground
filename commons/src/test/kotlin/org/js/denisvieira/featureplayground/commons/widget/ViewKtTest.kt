package org.js.denisvieira.featureplayground.commons.widget

import android.content.Context
import android.view.View
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ViewKtTest {

    private val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun whenCallVisibleWithTrue_shouldVisible() {
        val expected = View.VISIBLE

        val actual = true.visible()

        assertEquals(expected, actual)
    }

    @Test
    fun whenCallVisibleWithFalse_shouldGone() {
        val expected = View.GONE

        val actual = false.visible()

        assertEquals(expected, actual)
    }

    @Test
    fun whenCallVisibleWithTrue_shouldVisibilityVisible() {
        val text = View(context)

        text.visible(true)

        assertEquals(View.VISIBLE, text.visibility)
    }

    @Test
    fun whenCallVisibleWithTrue_shouldVisibilityGone() {
        val text = View(context)

        text.visible(false)

        assertEquals(View.GONE, text.visibility)
    }
}
