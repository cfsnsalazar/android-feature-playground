package org.js.denisvieira.featureplayground.commons.formatter

import java.util.Locale
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test

class CurrencyFormatterTest {

    @Test
    fun whenReceiveUSASymbol_ShouldReturnUSLocation() {
        val localeForSymbol = CurrencyFormatter.getLocaleForSymbol(CurrencyISOTypeConst.USA)
        assertEquals(localeForSymbol, Locale.US)
    }

    @Test
    fun whenReceiveBrazilSymbol_ShouldReturnBrazilLocation() {
        val localeForSymbol = CurrencyFormatter.getLocaleForSymbol(CurrencyISOTypeConst.BRAZIL)
        assertEquals(localeForSymbol, CurrencyFormatter.brazilLocation())
    }

    @Test
    fun whenReceiveUnknownSymbol_ShouldReturnBrazilLocation() {
        val localeForSymbol = CurrencyFormatter.getLocaleForSymbol("")
        assertEquals(localeForSymbol, CurrencyFormatter.brazilLocation())
    }

    @Ignore
    @Test
    fun whenValueFormattedToBrazilianLocation_ShouldReturnStringWithBrazilianCurrency() {
        val formatted = CurrencyFormatter.getFormattedCurrencyForLocale(
            13.03f,
            CurrencyFormatter.brazilLocation()
        )
        assertEquals(formatted, "R$13,03")
    }

    @Test
    fun whenValueFormattedToUSALocation_ShouldReturnStringWithUSACurrency() {
        val formatted = CurrencyFormatter.getFormattedCurrencyForLocale(13.03f, Locale.US)
        assertEquals(formatted, "US$13,03")
    }

    @Test
    fun whenValueFormattedToUSASymbol_ShouldReturnStringWithUSACurrency() {
        val formatted =
            CurrencyFormatter.getFormattedCurrencyForLocale(13.03f, CurrencyISOTypeConst.USA)
        assertEquals(formatted, "US$13,03")
    }

    @Ignore
    @Test
    fun whenValueFormattedToBrazilianSymbol_ShouldReturnStringWithBrazilianCurrency() {
        val formatted =
            CurrencyFormatter.getFormattedCurrencyForLocale(13.03f, CurrencyISOTypeConst.BRAZIL)
        assertEquals(formatted, "R$13,03")
    }

    @Ignore
    @Test
    fun whenNegativeValueFormattedToBrazilianSymbol_ShouldReturnStringWithNegativeSymbolBeforeCurrencySymbol() {
        val formattedBRL =
            CurrencyFormatter.getFormattedCurrencyForLocale(-13.03f, CurrencyISOTypeConst.BRAZIL)

        assertEquals(formattedBRL, "-R$13,03")
    }

    @Test
    fun whenNegativeValueFormattedToUSASymbol_ShouldReturnStringWithNegativeSymbolBeforeCurrencySymbol() {
        val formattedUSA =
            CurrencyFormatter.getFormattedCurrencyForLocale(-13.03f, CurrencyISOTypeConst.USA)

        assertEquals(formattedUSA, "-US$13,03")
    }
}
