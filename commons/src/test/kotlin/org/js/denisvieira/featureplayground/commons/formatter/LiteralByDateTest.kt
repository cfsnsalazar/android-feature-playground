package org.js.denisvieira.featureplayground.commons.formatter

import java.text.SimpleDateFormat
import org.junit.Assert.assertEquals
import org.junit.Test

class LiteralByDateTest {

    @Test
    fun whenReceiveMonthInEnglish_ShouldTranslateToPortugueseAllUpperCase() {
        val result = getLocalizedMonth("FEB", action = String::toUpperCase)

        assertEquals("FEV", result)
    }

    @Test
    fun whenReceiveMonthInEnglishFirstCapitalLetter_ShouldTranslateToPortugueseAllToUppercase() {
        val result = getLocalizedMonth("Feb", action = String::toUpperCase)

        assertEquals("FEV", result)
    }

    @Test
    fun whenReceiveMonthInEnglishLowerCase_ShouldTranslateToPortugueseAllToUppercase() {
        val result = getLocalizedMonth("Feb", action = String::toUpperCase)

        assertEquals("FEV", result)
    }

    @Test
    fun whenReceiveMonthInEnglish_ShouldTranslateToPortugueseCapitalized() {
        val result = getLocalizedMonth("FEB", action = String::capitalize)

        assertEquals("Fev", result)
    }

    @Test
    fun whenReceiveMonthInEnglishFirstCapitalLetter_ShouldTranslateToPortugueseCapitalized() {
        val result = getLocalizedMonth("Feb", action = String::capitalize)

        assertEquals("Fev", result)
    }

    @Test
    fun whenReceiveMonthInEnglishLowerCase_ShouldTranslateToPortugueseCapitalized() {
        val result = getLocalizedMonth("Feb", action = String::capitalize)
        assertEquals("Fev", result)
    }

    @Test
    fun whenReceiveMonthInEnglish_ShouldTranslateToPortugueseAllUpperCaseFullMonthPattern() {
        val result = getLocalizedMonth("FEB", action = String::toUpperCase)

        assertEquals("FEV", result)
    }

    @Test
    fun whenReceiveMonthInEnglishFirstCapitalLetter_ShouldTranslateToPortugueseAllToUppercaseFullMonthPattern() {
        val result = getLocalizedMonth("Feb", action = String::toUpperCase)

        assertEquals("FEV", result)
    }

    @Test
    fun whenReceiveMonthInEnglishLowerCase_ShouldTranslateToPortugueseAllToUppercaseFullMonthPattern() {
        val result = getLocalizedMonth("Feb", action = String::toUpperCase, returnPattern = "MMMM")

        assertEquals("FEVEREIRO", result)
    }

    @Test
    fun whenReceiveMonthInEnglish_ShouldTranslateToPortugueseCapitalizedFullMonthPattern() {
        val result = getLocalizedMonth("FEB", action = String::capitalize, returnPattern = "MMMM")

        assertEquals("Fevereiro", result)
    }

    @Test
    fun whenReceiveMonthInEnglishFirstCapitalLetter_ShouldTranslateToPortugueseCapitalizedFullMonthPattern() {
        val result = getLocalizedMonth("Feb", action = String::capitalize, returnPattern = "MMMM")

        assertEquals("Fevereiro", result)
    }

    @Test
    fun whenReceiveMonthInEnglishLowerCase_ShouldTranslateToPortugueseCapitalizedFullMonthPattern() {
        val result = getLocalizedMonth("Feb", action = String::capitalize, returnPattern = "MMMM")

        assertEquals("Fevereiro", result)
    }

    @Test
    fun whenReceiveNullAsParameter_ShouldReturnNull() {
        val result = getLocalizedMonth(null)

        assertEquals(null, result)
    }

    @Test
    fun whenReceiveEmptyStringAsParameter_ShouldReturnNull() {
        val result = getLocalizedMonth("")

        assertEquals("", result)
    }

    @Test
    fun whenReceiveMonthInPortuguese_ShouldKeepInPortuguese() {
        val result = getLocalizedMonth("FEV")

        assertEquals("FEV", result)
    }

    @Test
    fun whenRecieveDateFromApi_AndNoPatternPassed_ShouldReturnLiteralMonthByApiPattern() {
        val result = getLiteralMonthByDate("2018-05-22")

        assertEquals("Maio", result)
    }

    @Test
    fun whenRecieveDate_ShouldReturnLiteralDayOfWeek_withBrazilianPattern() {
        val formatDate = SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss",
            CurrencyFormatter.brazilLocation()
        )
        val dateToGetDay = formatDate.parse("2018-09-12T12:32:18.166Z")

        val result = getLiteralDayOfWeekByDate(dateToGetDay)

        assertEquals("Quarta-feira", result)
    }

    @Test
    fun whenRecieveDate_ShouldReturnLiteralMonth_withBrazilianPattern() {
        val formatDate = SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss",
            CurrencyFormatter.brazilLocation()
        )
        val dateToGetMonth = formatDate.parse("2018-09-12T12:32:18.166Z")

        val result = getLiteralMonthByDate(dateToGetMonth)

        assertEquals("Setembro", result)
    }

    @Test
    fun whenReceiveDate_AndGiveAnotherDatePattern_ShouldReturnLiteralMonthAsDesired() {
        val result = getLiteralMonthByDate(
            "2018-09-12T12:32:18.166Z",
            API_PATTERN_DATE_AND_TIME
        )

        assertEquals("Setembro", result)
    }

    @Test
    fun shouldReturnJanuaryMonth() {
        val month = "JAN"
        val formattedMonth = getFormattedMonth(month)
        val expected = "Janeiro"

        assertEquals(formattedMonth, expected)
    }
}
