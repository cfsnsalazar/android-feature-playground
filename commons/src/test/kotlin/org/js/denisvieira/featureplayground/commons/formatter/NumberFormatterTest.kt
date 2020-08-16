package org.js.denisvieira.featureplayground.commons.formatter

import org.junit.Assert.assertEquals
import org.junit.Test

class NumberFormatterTest {

    @Test
    fun whenCallFormatAsRealCurrency_shouldFormattedReal() {
        assertEquals("R$ 10,00", 10f.formatAsRealCurrency())
    }

    @Test
    fun whenCallFormatAsDollarCurrency_shouldFormattedDollar() {
        assertEquals("US$ 5,00", 5f.formatAsDollarCurrency())
    }
}
