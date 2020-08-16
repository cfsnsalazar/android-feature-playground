package org.js.denisvieira.featureplayground.commons.intent

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class _intentKtTest {

    @Test(expected = IllegalStateException::class)
    fun whenNoExtras_shouldThrowIllegalStateException() {
        val intent = mock<Intent>()

        whenever(intent.extras).thenReturn(null)

        intent.requireExtraValue<String>("KEY")
    }

    @Test(expected = IllegalStateException::class)
    fun whenKeyNotExists_shouldThrowIllegalStateException() {
        val intent = mock<Intent>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn(null)
        whenever(intent.extras).thenReturn(bundle)

        intent.requireExtraValue<String>("KEY")
    }

    @Test(expected = ClassCastException::class)
    fun whenValueTypeIsDifferentToRequired_shouldThrowClassCastException() {
        val intent = mock<Intent>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn("value")
        whenever(intent.extras).thenReturn(bundle)

        val result = intent.requireExtraValue<Int>("KEY")
    }

    @Test
    fun whenValueIsString_shouldReturnStringValue() {
        val value = "value"
        val intent = mock<Intent>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn(value)
        whenever(intent.extras).thenReturn(bundle)

        val result = intent.requireExtraValue<String>("KEY")
        assertEquals(value, result)
    }

    @Test
    fun whenValueIsInt_shouldReturnIntValue() {
        val value = 1
        val intent = mock<Intent>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn(value)
        whenever(intent.extras).thenReturn(bundle)

        val result = intent.requireExtraValue<Int>("KEY")
        assertEquals(value, result)
    }

    @Test
    fun whenValueIsFloat_shouldReturnFloatValue() {
        val value = 1f
        val intent = mock<Intent>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn(value)
        whenever(intent.extras).thenReturn(bundle)

        val result = intent.requireExtraValue<Float>("KEY")
        assertEquals(value, result)
    }

    @Test
    fun whenValueIsBoolean_shouldReturnBooleanValue() {
        val value = true
        val intent = mock<Intent>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn(value)
        whenever(intent.extras).thenReturn(bundle)

        val result = intent.requireExtraValue<Boolean>("KEY")
        assertEquals(value, result)
    }

    @Test
    fun whenValueIsParcelable_shouldReturnParcelableValue() {
        val value = mock<Parcelable>()
        val intent = mock<Intent>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn(value)
        whenever(intent.extras).thenReturn(bundle)

        val result = intent.requireExtraValue<Parcelable>("KEY")
        assertEquals(value, result)
    }

    @Test
    fun whenValueIsLongArray_shouldReturnLongArrayValue() {
        val value = arrayOf(1L, 2L)
        val intent = mock<Intent>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn(value)
        whenever(intent.extras).thenReturn(bundle)

        val result = intent.requireExtraValue<Array<Long>>("KEY")
        assertArrayEquals(value, result)
    }

    @Test
    fun whenValueIsDoubleArrayList_shouldReturnDoubleArrayListValue() {
        val value = arrayListOf(1.0, 2.0)
        val intent = mock<Intent>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn(value)
        whenever(intent.extras).thenReturn(bundle)

        val result = intent.requireExtraValue<ArrayList<Double>>("KEY")
        assertEquals(value, result)
    }
}
