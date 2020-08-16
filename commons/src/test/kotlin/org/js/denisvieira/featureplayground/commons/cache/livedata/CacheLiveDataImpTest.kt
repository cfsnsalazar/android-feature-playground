package org.js.denisvieira.featureplayground.commons.cache.livedata

import android.content.Context
import android.content.SharedPreferences
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.js.denisvieira.featureplayground.commons.cache.livedata.CacheLiveDataImp.Companion.getPreferences
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.orhanobut.hawk.Hawk
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class CacheLiveDataImpTest {

    private lateinit var cacheLiveDataImp: CacheLiveDataImp<String>
    private lateinit var preferences: SharedPreferences

    private val key = "key"
    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val listener = mock<SharedPreferences.OnSharedPreferenceChangeListener>()

    @Before
    fun setUp() {
        Hawk.init(context).build()
        preferences = getPreferences(context)!!
        cacheLiveDataImp = CacheLiveDataImp(preferences, key)
    }

    @Test
    fun whenPutNewValue_verifyChangeSharedPreference() {

        preferences.registerOnSharedPreferenceChangeListener(listener)

        Hawk.put(key, String())

        verify(listener).onSharedPreferenceChanged(any(), any())
    }

    @Test
    fun whenPutNewValue_verifyIfKeyEquals() {

        preferences.registerOnSharedPreferenceChangeListener(listener)

        Hawk.put(key, String())

        verify(listener).onSharedPreferenceChanged(any(), eq(key))
    }

    @Test
    fun whenPutNewValue_verifyNoMoreInteraction() {

        preferences.unregisterOnSharedPreferenceChangeListener(listener)

        Hawk.put(key, String())

        verifyNoMoreInteractions(listener)
    }
}
