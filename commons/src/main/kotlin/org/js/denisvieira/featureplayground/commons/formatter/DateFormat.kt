package org.js.denisvieira.featureplayground.commons.formatter

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.TimeZone
import timber.log.Timber

internal fun getDateFormatBRL() =
    SimpleDateFormat(BRAZIL_PATTERN_DAY_AND_MONTH, CurrencyFormatter.brazilLocation())

internal fun getDateFormatAPI() =
    SimpleDateFormat(API_PATTERN, CurrencyFormatter.brazilLocation())

internal fun getLiteralDateFormatter() =
    SimpleDateFormat(API_PATTERN_DATE_TIME_AND_SECONDS, CurrencyFormatter.brazilLocation())

fun createDateFormatWithTimeZone(pattern: String) =
    SimpleDateFormat(pattern, CurrencyFormatter.brazilLocation())
        .also {
            it.timeZone = TimeZone.getTimeZone(UTC)
        }

internal fun getDateFormatWallet() =
    SimpleDateFormat(API_PATTERN_YYMM, CurrencyFormatter.brazilLocation())

internal fun getMonthFormatter() =
    SimpleDateFormat(LITERAL_MONTH_PATTERN, CurrencyFormatter.brazilLocation())

internal fun getDayOfWeekFormatter() =
    SimpleDateFormat(DAY_OF_WEEK_PATTERN, CurrencyFormatter.brazilLocation())

fun parseDateFull(eventDate: String) =
    try {
        createDateFormatWithTimeZone(API_PATTERN_DATE_TIME_AND_SECONDS_AND_MILLISECONDS_ZONE)
            .parse(eventDate)
    } catch (exception: ParseException) {
        parseDateSecond(eventDate)
    }

private fun parseDateSecond(eventDate: String) =
    try {
        createDateFormatWithTimeZone(API_PATTERN_DATE_TIME_AND_SECONDS_ZONE)
            .parse(eventDate)
    } catch (exception: ParseException) {
        Timber.e(exception)
        null
    }
