package org.js.denisvieira.featureplayground.commons.fileprovider

import com.odete.commons.BuildConfig

private const val ANDROID_BASE_APPLICATION_ID = "com.odete"
private const val SEPARATOR = "."

fun getApplicationId(flavorTypeSuffix: String): String {

    val applicationId = StringBuilder(ANDROID_BASE_APPLICATION_ID)

    if (flavorTypeSuffix.isNotEmpty()) {
        applicationId
            .append(SEPARATOR)
            .append(flavorTypeSuffix)
    }

    if (BuildConfig.BUILD_TYPE_SULFIX.isNotEmpty()) {
        applicationId
            .append(SEPARATOR)
            .append(BuildConfig.BUILD_TYPE_SULFIX)
    }

    return applicationId.toString()
}
