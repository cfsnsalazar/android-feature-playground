package org.js.denisvieira.featureplayground.commons.utils

class ErrorResponse(
    override val cause: Throwable,
    val code: Int? = null,
    val errorBody: String? = null
) : Throwable()
