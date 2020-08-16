package org.js.denisvieira.featureplayground.commons.formatter

import java.text.SimpleDateFormat
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class DateFormatterTest {

    @Test
    fun whenReceiveStringDateFromApiShouldReturnJustDayAndMonth() {
        val result = formatDateDayAndMonthPattern("2018-05-22")

        assertEquals("22/05", result)
    }

    @Test
    fun whenReceiveStringDateAndADatePatternShouldReturnDateObject() {
        val formatDate = SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss.SSS",
            CurrencyFormatter.brazilLocation()
        )

        val expected = formatDate.parse("2018-09-12T12:32:18.166Z")
        val result = formatDate(
            "2018-09-12T12:32:18.166Z",
            API_PATTERN_DATE_AND_TIME
        )

        assertEquals(expected, result)
    }

    @Test
    fun whenReceiveStringDateFromApiShouldReturnDateObject() {
        val formatDate = SimpleDateFormat("yyyy-MM-dd", CurrencyFormatter.brazilLocation())

        val expected = formatDate.parse("2018-05-22")
        val result = formatDateFromApi("2018-05-22")

        assertEquals(expected, result)
    }

    @Test
    fun whenReceiveDateAndMaskShouldReturnFormattedDateAsDesired() {
        val formatDate = SimpleDateFormat("yyyy-MM-dd", CurrencyFormatter.brazilLocation())
        val result = formatDateToPattern(formatDate.parse("2018-05-22"), "dd/MM")

        assertEquals("22/05", result)
    }

    @Test
    fun whenReceiveDateFromApiAndMaskShouldReturnFormattedDateAsDesired() {
        val result = formatDateToPattern("2018-05-22", "MM/yyyy")

        assertEquals("05/2018", result)
    }

    @Test
    fun whenReceiveDateFromShouldReturnFormattedWithMonthAndYearPattern() {
        val result = formatDateMonthAndYearPattern("2018-05-22")

        assertEquals("05/2018", result)
    }

    @Test
    fun whenReceiveDateFromWalletApi_ShouldReturnFormattedDateWithMonthYearPAttern() {
        val result = formatDateMonthAndYearWalletPattern("1201")

        Assert.assertEquals("01/12", result)
    }
}
