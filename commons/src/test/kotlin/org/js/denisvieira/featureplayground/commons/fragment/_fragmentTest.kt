package org.js.denisvieira.featureplayground.commons.fragment

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class _fragmentKtTest {

    @Test(expected = IllegalStateException::class)
    fun whenKeyNotExists_shouldThrowIllegalStateException() {
        val fragment = mock<Fragment>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn(null)
        whenever(fragment.requireArguments()).thenReturn(bundle)

        fragment.requireArgValue<String>("KEY")
    }

    @Test(expected = ClassCastException::class)
    fun whenValueTypeIsDifferentToRequired_shouldThrowClassCastException() {
        val fragment = mock<Fragment>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn("value")
        whenever(fragment.requireArguments()).thenReturn(bundle)

        val result = fragment.requireArgValue<Int>("KEY")
    }

    @Test
    fun whenValueIsString_shouldReturnStringValue() {
        val value = "value"
        val fragment = mock<Fragment>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn(value)
        whenever(fragment.requireArguments()).thenReturn(bundle)

        val result = fragment.requireArgValue<String>("KEY")
        assertEquals(value, result)
    }

    @Test
    fun whenValueIsInt_shouldReturnIntValue() {
        val value = 1
        val fragment = mock<Fragment>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn(value)
        whenever(fragment.requireArguments()).thenReturn(bundle)

        val result = fragment.requireArgValue<Int>("KEY")
        assertEquals(value, result)
    }

    @Test
    fun whenValueIsFloat_shouldReturnFloatValue() {
        val value = 1f
        val fragment = mock<Fragment>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn(value)
        whenever(fragment.requireArguments()).thenReturn(bundle)

        val result = fragment.requireArgValue<Float>("KEY")
        assertEquals(value, result)
    }

    @Test
    fun whenValueIsBoolean_shouldReturnBooleanValue() {
        val value = true
        val fragment = mock<Fragment>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn(value)
        whenever(fragment.requireArguments()).thenReturn(bundle)

        val result = fragment.requireArgValue<Boolean>("KEY")
        assertEquals(value, result)
    }

    @Test
    fun whenValueIsParcelable_shouldReturnParcelableValue() {
        val value = mock<Parcelable>()
        val fragment = mock<Fragment>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn(value)
        whenever(fragment.requireArguments()).thenReturn(bundle)

        val result = fragment.requireArgValue<Parcelable>("KEY")
        assertEquals(value, result)
    }

    @Test
    fun whenValueIsLongArray_shouldReturnLongArrayValue() {
        val value = arrayOf(1L, 2L)
        val fragment = mock<Fragment>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn(value)
        whenever(fragment.requireArguments()).thenReturn(bundle)

        val result = fragment.requireArgValue<Array<Long>>("KEY")
        assertArrayEquals(value, result)
    }

    @Test
    fun whenValueIsDoubleArrayList_shouldReturnDoubleArrayListValue() {
        val value = arrayListOf(1.0, 2.0)
        val fragment = mock<Fragment>()
        val bundle = mock<Bundle>()

        whenever(bundle.get(any())).thenReturn(value)
        whenever(fragment.requireArguments()).thenReturn(bundle)

        val result = fragment.requireArgValue<ArrayList<Double>>("KEY")
        assertEquals(value, result)
    }
}
