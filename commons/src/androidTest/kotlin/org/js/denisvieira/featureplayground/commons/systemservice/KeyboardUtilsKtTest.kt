package org.js.denisvieira.featureplayground.commons.systemservice

import android.view.View
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.filters.FlakyTest
import androidx.test.rule.ActivityTestRule
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import com.odete.commons.test.R
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

class KeyboardUtilsKtTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(KeyboardActivityTest::class.java)

    private lateinit var input: View

    @Before
    fun setup() {
        input = rule.activity.findViewById(R.id.input_keyboard)
    }

    @After
    fun tearDown() {
        closeSoftKeyboard()
    }

    @Test
    @Ignore
    @FlakyTest
    fun whenCalled_ShouldOpenKeyboard() {
        val button = getButton()

        input.showKeyboard()

        assertFalse(button.exists())
    }

    @Test
    @Ignore
    @FlakyTest
    fun whenCalled_ShouldCloseKeyboard() {
        val button = getButton()

        input.showKeyboard()
        input.hideKeyboard()

        assertTrue(button.exists())
    }

    private fun getButton(): UiObject {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        return device.findObject(UiSelector().text("TIGER BUTTON"))
    }
}
