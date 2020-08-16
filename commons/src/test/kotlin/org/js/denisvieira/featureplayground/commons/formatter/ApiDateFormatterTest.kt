package org.js.denisvieira.featureplayground.commons.formatter

import org.junit.Assert.assertEquals
import org.junit.Test

class ApiDateFormatterTest {

    @Test
    fun whenReceiveADate_ShouldReturnAFormattedDateWithApiPattern() {
        val date = formatDateFromApi("2018-05-22")
        val formattedDate = formatDateToApi(date)
        val expected = "2018-05-22"
        assertEquals(expected, formattedDate)
    }
}
