package org.js.denisvieira.featureplayground.commons.formatter

import java.text.DateFormatSymbols
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

/**
 * Date formatter - Returns literal day of week with brazilian pattern, ex: 'Segunda-feira'
 * @param apiDate Date to get day
 * @return returns string literal day
 */

fun getLiteralDayOfWeekByDate(apiDate: Date): String {
    return getDayOfWeekFormatter().format(apiDate)
}

/**
 * Date formatter - Returns literal month with brazilian pattern, ex: 'Janeiro'
 * @param apiDate Date to get month
 * @return returns string literal month
 */

fun getLiteralMonthByDate(apiDate: Date): String {
    return getMonthFormatter().format(apiDate)
}

/**
 * Date formatter - Returns literal month
 * @param apiDate string-date from api (default pattern yyyy-MM-dd)
 * @param datePattern optional parameter, if date pattern is different than 'yyyy-MM-dd'
 * @return returns literal month with brazil location patter (ex. Janeiro)
 */

fun getLiteralMonthByDate(
    apiDate: String,
    datePattern: String = API_PATTERN
): String {
    val date = SimpleDateFormat(datePattern, CurrencyFormatter.brazilLocation()).parse(apiDate)
    val calendar = Calendar.getInstance()
    calendar.time = date
    return DateFormatSymbols(CurrencyFormatter.brazilLocation()).months[calendar.get(Calendar.MONTH)]
}

@JvmOverloads
fun getLocalizedMonth(
    monthReference: String?,
    returnPattern: String = DEFAULT_MONTH_INPUT_PATTERN,
    action: (string: String) -> String = { it }
): String? {

    if (monthReference.isNullOrEmpty()) {
        return monthReference
    }
    return try {
        var simpleDateFormat = SimpleDateFormat(DEFAULT_MONTH_INPUT_PATTERN, Locale.ENGLISH)
        val date = simpleDateFormat.parse(monthReference)
        simpleDateFormat = SimpleDateFormat(returnPattern, CurrencyFormatter.brazilLocation())
        action(simpleDateFormat.format(date))
    } catch (e: ParseException) {
        monthReference
    }
}

fun getFormattedMonth(monthReference: String): String {
    return getLocalizedMonth(monthReference, LITERAL_MONTH_PATTERN) { obj: String -> obj.capitalize() }!!
}
