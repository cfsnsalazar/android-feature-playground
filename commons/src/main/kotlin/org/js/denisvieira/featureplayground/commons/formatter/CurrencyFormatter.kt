package org.js.denisvieira.featureplayground.commons.formatter

import androidx.annotation.StringDef
import org.js.denisvieira.featureplayground.commons.formatter.CurrencyISOTypeConst.BRAZIL
import org.js.denisvieira.featureplayground.commons.formatter.CurrencyISOTypeConst.EURO
import org.js.denisvieira.featureplayground.commons.formatter.CurrencyISOTypeConst.USA
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.Locale

object CurrencyFormatter {

    fun getFormattedCurrencyForLocale(value: Float, locale: Locale = brazilLocation()): String {
        return if (locale == Locale.US) {
            val decimalFormat = DecimalFormatSymbols()
            decimalFormat.currencySymbol = "US$ "
            decimalFormat.monetaryDecimalSeparator = ','
            val currencyInstance = NumberFormat.getCurrencyInstance()
            (currencyInstance as DecimalFormat).decimalFormatSymbols = decimalFormat
            currencyInstance.format(value)
        } else
            NumberFormat.getCurrencyInstance(locale).format(value)
    }

    fun getFormattedCurrencyForLocale(value: Float, @CurrencyISOType localeSymbol: String?) =
        getFormattedCurrencyForLocale(
            value,
            getLocaleForSymbol(
                localeSymbol ?: BRAZIL
            )
        )

    fun getLocaleForSymbol(@CurrencyISOType symbol: String): Locale =
        if (CurrencyISOTypeConst.USA == symbol)
            Locale.US
        else brazilLocation()

    fun brazilLocation(): Locale {
        return Locale("pt", "br")
    }
}

@StringDef(BRAZIL, USA, EURO)
@Retention(AnnotationRetention.SOURCE)
annotation class CurrencyISOType

object CurrencyISOTypeConst {

    const val USA = "USD"
    const val BRAZIL = "BRL"
    const val EURO = "EU"
}
