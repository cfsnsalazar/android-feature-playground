package org.js.denisvieira.featureplayground.commons.utils

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Base64ImplTest {

    @Test
    fun givenSomeString_ShouldEncode() {
        val base64 = Base64Impl()

        val result = base64.encode("Tigrao".toByteArray())

        assertEquals("VGlncmFv", result)
    }

    @Test
    fun givenSomeByteArray_ShouldDecode() {
        val base64 = Base64Impl()

        val result = base64.decode("VGlncmFv")

        assertEquals("Tigrao", String(result))
    }

    @Test
    fun givenSomeString_withAccentuation_ShouldEncode() {
        val base64 = Base64Impl()

        val result = base64.encode("Tigrão".toByteArray())

        assertEquals("VGlncsOjbw==", result)
    }

    @Test
    fun givenSomeByteArray_withAccentuation_ShouldDecode() {
        val base64 = Base64Impl()

        val result = base64.decode("VGlncsOjbw==")

        assertEquals("Tigrão", String(result))
    }
}
