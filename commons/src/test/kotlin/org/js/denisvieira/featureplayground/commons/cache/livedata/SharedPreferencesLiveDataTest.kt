package org.js.denisvieira.featureplayground.commons.cache.livedata

import android.content.Context
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.orhanobut.hawk.Hawk
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class SharedPreferencesLiveDataTest {

    private lateinit var sharedPref: SharedPreferencesLiveData
    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val observer = mock<Observer<String>>()

    @Before
    fun setUp() {
        Hawk.init(context).build()
        sharedPref = SharedPreferencesLiveData(context)
    }

    @Test
    fun givenPutValue_whenCallGet_verifyChangeObserver() {
        Hawk.put("key", "value")

        val actual = sharedPref.get<String>("key")

        actual.observeForever(observer)

        verify(observer).onChanged(any())
    }
}
