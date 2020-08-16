package org.js.denisvieira.featureplayground.commons.cache

import android.content.Context

interface CacheManager {

    var approvedLimit: Int

    fun setApplicationId(applicationId: Long)

    fun getApplicationId(): Long

    fun clear()

    fun <T> putCustomValue(key: String, value: T)

    fun <T> getValueOrDefault(key: String, defaultValue: T? = null): T

    fun isBuilt(): Boolean

    fun init(context: Context)

    fun containsValue(key: String): Boolean

    fun deleteValue(key: String)
}
