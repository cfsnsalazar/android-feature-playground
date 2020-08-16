package org.js.denisvieira.featureplayground.commons.cache.livedata

import android.content.Context
import androidx.lifecycle.LiveData
import org.js.denisvieira.featureplayground.commons.cache.livedata.CacheLiveDataImp.Companion.getPreferences
import java.lang.ref.WeakReference

class SharedPreferencesLiveData(context: Context) {

    private val weakContext = WeakReference(context).get()?.let { it }

    fun <T> get(key: String): LiveData<T> = CacheLiveDataImp(getPreferences(weakContext), key)
}
