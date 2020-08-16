package org.js.denisvieira.featureplayground.commons.di

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import org.js.denisvieira.featureplayground.commons.cache.CacheConfigurator
import org.js.denisvieira.featureplayground.commons.cache.CacheManager
import org.js.denisvieira.featureplayground.commons.cache.CacheManagerImpl
import org.js.denisvieira.featureplayground.commons.cache.livedata.SharedPreferencesLiveData
import org.js.denisvieira.featureplayground.commons.setup.ActivityLifecycleCallbacksRegistry
import org.js.denisvieira.featureplayground.commons.systemservice.CellphoneVibrator
import org.js.denisvieira.featureplayground.commons.systemservice.CellphoneVibratorImpl
import org.js.denisvieira.featureplayground.commons.utils.Base64
import org.js.denisvieira.featureplayground.commons.utils.Base64Impl
import org.js.denisvieira.featureplayground.commons.utils.EmailValidator
import org.js.denisvieira.libraries.events.app.OnCreateAppListener
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.contexted
import org.kodein.di.generic.factory
import org.kodein.di.generic.inSet
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.setBinding
import org.kodein.di.generic.singleton

val commonsModule = Kodein.Module("commonsModule") {
    bind<ViewModelProvider.Factory>() with singleton { ViewModelFactory(kodein) }

    bind<CacheManager>() with singleton { CacheManagerImpl }

    bind() from singleton { SharedPreferencesLiveData(instance()) }

    bind<Base64>() with singleton {
        Base64Impl()
    }

    bind<CellphoneVibrator>() with singleton {
        CellphoneVibratorImpl()
    }

    bind<NavController>() with contexted<AppCompatActivity>().factory { viewId: Int ->
        context.findNavController(viewId)
    }

    bind<NavController>() with contexted<Fragment>().provider {
        context.findNavController()
    }

    bind() from provider {
        EmailValidator()
    }

    bind() from setBinding<Application.ActivityLifecycleCallbacks>()

    bind<OnCreateAppListener>().inSet() with provider {
        CacheConfigurator(instance(), instance())
    }

    bind<OnCreateAppListener>().inSet() with provider {
        ActivityLifecycleCallbacksRegistry(instance(), instance())
    }
}
