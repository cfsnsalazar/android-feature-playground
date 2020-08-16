package org.js.denisvieira.featureplayground.platform

import android.app.Application
import com.odete.library.di.appModule
import org.js.denisvieira.featureplayground.di.welcomeModule
import org.js.denisvieira.libraries.events.app.OnCreateApp
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.direct
import org.kodein.di.generic.instance

class CustomApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(appModule(this@CustomApplication))
        import(welcomeModule)
    }

    override fun onCreate() {
        super.onCreate()
        setup()
    }

    /**
     * Run all application dependent setup
     *
     * @see [org.js.denisvieira.library.events.app.OnCreateAppListener]
     */
    private fun setup() {
        kodein.direct.instance<OnCreateApp>().execute()
    }
}
