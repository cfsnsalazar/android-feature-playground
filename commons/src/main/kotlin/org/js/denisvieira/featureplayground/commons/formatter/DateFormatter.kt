package org.js.denisvieira.featureplayground.commons.formatter

import java.text.SimpleDateFormat
import java.util.Date

/**
 * Date formatter - Returns Date object from Api response (String)
 * @param dateFromApi String be parsed
 * @return returns Date
 */

fun formatDateFromApi(dateFromApi: String): Date = getDateFormatAPI().parse(dateFromApi)

/**
 * Date formatter - Returns Date object a given pattern
 * @param dateFromApi String to be parsed as a Date
 * @param datePattern String pattern to format date
 * @return returns Date
 */

fun formatDate(dateFromApi: String, datePattern: String): Date =
    SimpleDateFormat(datePattern, CurrencyFormatter.brazilLocation()).parse(dateFromApi)

/**
 * Date formatter - Returns date with pattern: dd/MM
 * @param dateToFormat date to be formatted
 * @return returns formatted date
 */

fun formatDateDayAndMonthPattern(dateToFormat: String): String {
    val date = getDateFormatAPI().parse(dateToFormat)
    return getDateFormatBRL().format(date)
}

/**
 * Date formatter - Returns date with pattern: dd/MM
 * @param dateToFormat date to be formatted
 * @return returns formatted date
 */

fun formatDateMonthAndYearPattern(dateToFormat: String): String {
    val date = getDateFormatAPI().parse(dateToFormat)
    return SimpleDateFormat(
        BRAZIL_PATTERN_MONTH_AND_YEAR,
        CurrencyFormatter.brazilLocation()
    ).format(date)
}

/**
 * Date formatter - Returns date with pattern: MM/YY
 * @param dateToFormat date to be formatted
 * @return returns formatted date
 */

fun formatDateMonthAndYearWalletPattern(dateToFormat: String): String {
    val date = getDateFormatWallet().parse(dateToFormat)
    return SimpleDateFormat(
        BRAZIL_PATTERN_MM_YY,
        CurrencyFormatter.brazilLocation()
    ).format(date)
}

/**
 * Date formatter - Returns date with desired pattern
 * @param dateToFormat date to be formatted
 * @param datePattern desired date pattern
 * @return returns formatted date
 */

fun formatDateToPattern(dateToFormat: Date, datePattern: String): String {
    val dateFormat = SimpleDateFormat(datePattern, CurrencyFormatter.brazilLocation())
    return dateFormat.format(dateToFormat)
}

/**
 * Date formatter - Returns date with desired pattern
 * @param date string-date to be formatted (pattern yyyy-MM-dd)
 * @param datePattern desired date pattern
 * @return returns formatted date
 */

fun formatDateToPattern(date: String, datePattern: String): String {
    val dateFormat = SimpleDateFormat(datePattern, CurrencyFormatter.brazilLocation())
    val dateToFormat = formatDateFromApi(date)
    return dateFormat.format(dateToFormat)
}

fun formatDateToLiteralPattern(dateToFormat: String, literalPattern: String): String {
    val date = getLiteralDateFormatter().parse(dateToFormat)
    val dateFormat = SimpleDateFormat(
        literalPattern,
        CurrencyFormatter.brazilLocation()
    )
    return dateFormat.format(date)
}

fun formatDate(eventDate: Date?, format: String): String {
    eventDate?.takeIf {
        return formatDateToPattern(eventDate, format)
    }.takeUnless {
        return String()
    }
}
