package org.js.denisvieira.featureplayground.commons.formatter

import java.text.SimpleDateFormat
import java.util.Locale
import org.junit.Assert.assertEquals
import org.junit.Test

class DateFormatTest {

    @Test
    fun whenGetDateFormatBRL_shouldValidateCorrectResponse() {
        val expected = SimpleDateFormat("dd/MM", Locale("pt", "br"))

        assertEquals(getDateFormatBRL(), expected)
    }

    @Test
    fun whenGetDateFormatAPI_shouldValidateCorrectResponse() {
        val expected = SimpleDateFormat("yyyy-MM-dd", Locale("pt", "br"))

        assertEquals(getDateFormatAPI(), expected)
    }

    @Test
    fun whenGetDateFormatLiteralDate_shouldValidateCorrectResponse() {
        val expected = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale("pt", "br"))

        assertEquals(getLiteralDateFormatter(), expected)
    }

    @Test
    fun whenGetDateFormatWallet_shouldValidateCorrectResponse() {
        val expected = SimpleDateFormat("yyMM", Locale("pt", "br"))

        assertEquals(getDateFormatWallet(), expected)
    }

    @Test
    fun whenGetDateFormatMonth_shouldValidateCorrectResponse() {
        val expected = SimpleDateFormat("MMMM", Locale("pt", "br"))

        assertEquals(getMonthFormatter(), expected)
    }

    @Test
    fun whenGetDateFormatDayOfWeek_shouldValidateCorrectResponse() {
        val expected = SimpleDateFormat("EEEE", Locale("pt", "br"))

        assertEquals(getDayOfWeekFormatter(), expected)
    }
}
