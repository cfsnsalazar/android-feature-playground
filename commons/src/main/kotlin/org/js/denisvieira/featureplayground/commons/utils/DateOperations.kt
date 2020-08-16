package org.js.denisvieira.featureplayground.commons.utils

import java.util.Calendar
import java.util.Date

fun Date.addDays(date: Date, days: Int): Date {
    return Calendar.getInstance().also {
        it.time = date
        it.add(Calendar.DATE, days)
    }.time
}
