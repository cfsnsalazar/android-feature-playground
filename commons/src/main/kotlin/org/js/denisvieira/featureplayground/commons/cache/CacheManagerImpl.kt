package org.js.denisvieira.featureplayground.commons.cache

import android.content.Context
import com.orhanobut.hawk.Hawk

/**
 *
 * Saves info locally. In terms of security we use secured [Hawk] instead of
 * [android.content.SharedPreferences]
 *
 *
 * We could store custom long/ints/strings etc but for common entities there are separate methods
 * e.g [CacheManager.defaultAccount]
 */
object CacheManagerImpl : CacheManager {

    private const val APPLICATION_ID = "application_id"
    private const val APPROVED_LIMIT = "ApprovedLimit"

    override var approvedLimit: Int
        get() = getValueOrDefault(APPROVED_LIMIT, -1)
        set(limit) = putCustomValue(APPROVED_LIMIT, limit)

    override fun getApplicationId() = getValueOrDefault(APPLICATION_ID, -1L)

    override fun setApplicationId(applicationId: Long) {
        putCustomValue(APPLICATION_ID, applicationId)
    }

    /* Helper Methods */

    override fun isBuilt() =
        Hawk.isBuilt()

    override fun init(context: Context) {
        Hawk.init(context).build()
    }

    override fun clear() {
        Hawk.deleteAll()
    }

    override fun containsValue(key: String) = Hawk.contains(key)

    override fun <T> putCustomValue(key: String, value: T) {
        Hawk.put(key, value)
    }

    override fun <T> getValueOrDefault(key: String, defaultValue: T?): T {
        return defaultValue?.let { Hawk.get(key, defaultValue) } ?: Hawk.get(key)
    }

    override fun deleteValue(key: String) {
        Hawk.delete(key)
    }
}
