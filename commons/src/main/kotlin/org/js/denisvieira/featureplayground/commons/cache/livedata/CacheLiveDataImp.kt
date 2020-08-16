package org.js.denisvieira.featureplayground.commons.cache.livedata

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import org.js.denisvieira.featureplayground.commons.cache.CacheManagerImpl

internal class CacheLiveDataImp<T>(
    private val preferences: SharedPreferences?,
    private val key: String
) : LiveData<T>() {

    companion object {
        private const val STORAGE_TAG_DO_NOT_CHANGE = "Hawk2"

        fun getPreferences(weakContext: Context?) = weakContext
            ?.getSharedPreferences(STORAGE_TAG_DO_NOT_CHANGE, Context.MODE_PRIVATE)
    }

    override fun onActive() {
        super.onActive()

        preferences?.registerOnSharedPreferenceChangeListener(listened)

        if (CacheManagerImpl.containsValue(key))
            postValue(CacheManagerImpl.getValueOrDefault(key))
    }

    override fun onInactive() {
        preferences?.unregisterOnSharedPreferenceChangeListener(listened)
        super.onInactive()
    }

    private val listened = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->

        if (key == this.key && CacheManagerImpl.containsValue(key))
            postValue(CacheManagerImpl.getValueOrDefault(key))
    }
}
