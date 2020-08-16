package org.js.denisvieira.featureplayground.commons.formatter

import java.math.BigDecimal
import java.math.RoundingMode

object PercentageFormatter {

    /**
     * Percentage Formatter - Returns formatted string with mask "xx,x%"
     * @param percentage number to be formatted
     * @return returns String with formatted value
     */

    fun formatSimplePercentage(percentage: Float): String {
        var formattedValue = percentage.toString().replace(".", ",")
        formattedValue += "%"
        return formattedValue
    }

    fun formatPercentageWithDecimalPlaces(percentage: Double): String {
        val bigDecimal = BigDecimal(percentage)

        val value = bigDecimal.setScale(2, RoundingMode.HALF_EVEN)

        var formattedValue = value.toString().replace(".", ",")
        formattedValue += "%"

        return formattedValue
    }
}
