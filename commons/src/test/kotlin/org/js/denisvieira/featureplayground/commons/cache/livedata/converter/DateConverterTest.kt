package org.js.denisvieira.featureplayground.commons.cache.livedata.converter

import org.js.denisvieira.featureplayground.commons.cache.converter.DateConverter
import org.junit.Assert.assertEquals

import org.junit.Test
import java.util.Date

class DateConverterTest {

    @Test
    fun whenCallingFrom_WithStringDate_ShouldReturnDateInstance() {
        val date = Date()
        val expected = date
        val actual = DateConverter().from(date.time)

        assertEquals(expected, actual)
    }

    @Test
    fun whenCallingFrom_WithNull_ShouldReturnNull() {
        val expected = null
        val actual = DateConverter().from(null)

        assertEquals(expected, actual)
    }

    @Test
    fun whenCallingTo_WithDateInstance_ShouldReturnStringDate() {
        val date = Date()
        val expected = date.time
        val actual = DateConverter().to(date)

        assertEquals(expected, actual)
    }

    @Test
    fun whenCallingTo_WithNull_ShouldReturnNull() {
        val expected = null
        val actual = DateConverter().to(null)

        assertEquals(expected, actual)
    }
}
