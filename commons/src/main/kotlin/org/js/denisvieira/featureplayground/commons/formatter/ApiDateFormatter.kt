package org.js.denisvieira.featureplayground.commons.formatter

import java.util.Date

fun formatDateToApi(date: Date) = formatDateToPattern(date, API_PATTERN)
