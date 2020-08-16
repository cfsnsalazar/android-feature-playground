package br.com.odete.commonstest.test.di

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.test.core.app.ApplicationProvider
import org.kodein.di.Kodein
import org.kodein.di.conf.KodeinGlobalAware
import org.kodein.di.conf.global
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

class TestCustomApplication : Application(), KodeinGlobalAware {

    override fun onCreate() {
        super.onCreate()
        configKodein()
    }
}

@Suppress("SpellCheckingInspection")
private fun configKodein() {
    Kodein.global.mutable = true
    Kodein.global.addConfig {
        bind<Context>() with singleton {
            ApplicationProvider.getApplicationContext<Context>()
        }
    }
    Kodein.global.addConfig {
        bind<Application>() with singleton {
            ApplicationProvider.getApplicationContext<Application>()
        }
    }

    Kodein.global.addConfig {
        bind<ViewModelProvider.Factory>() with singleton { ViewModelFactoryTest(kodein) }
    }
}

fun resetInjection() {
    Kodein.global.clear()
    configKodein()
}

@Suppress("SpellCheckingInspection")
fun addKodeinModuleMock(
    vararg modules: Kodein.Module,
    config: Kodein.MainBuilder.() -> Unit = {}
) {
    resetInjection()
    modules.forEach { module ->
        Kodein.global.addImport(module, true)
    }
    Kodein.global.addConfig(config)
}
