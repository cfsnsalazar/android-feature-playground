package org.js.denisvieira.featureplayground.commons.formatter

import org.junit.Assert.assertEquals
import org.junit.Test

class PercentageFormatterTest {

    @Test
    fun whenReceivePercentageWithDecimalShouldReturnFormattedSimplePercentaege() {
        val result = PercentageFormatter.formatSimplePercentage(10.05F)
        assertEquals("10,05%", result)
    }

    @Test
    fun whenReceiveSimplePercentageShouldReturnFormattedWithPercentageSymbol() {
        val result = PercentageFormatter.formatSimplePercentage(7F)
        assertEquals("7,0%", result)
    }

    @Test
    fun whenReceivePercentageWithDoubleDecimalShouldReturnFormattedWithPercentageSymbol() {
        val result = PercentageFormatter.formatPercentageWithDecimalPlaces(10.9)
        assertEquals("10,90%", result)
    }
}
