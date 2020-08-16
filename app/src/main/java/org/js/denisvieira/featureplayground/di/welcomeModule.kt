package org.js.denisvieira.featureplayground.di

import com.google.firebase.crashlytics.FirebaseCrashlytics
import org.js.denisvieira.featureplayground.platform.TimberTree
import org.js.denisvieira.featureplayground.welcome.WelcomeViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import timber.log.Timber

internal val welcomeModule = Kodein.Module("welcomeModule") {
//    importOnce(eventsModule)

    bind() from provider {
        WelcomeViewModel(instance(), instance(), instance())
    }

//    bind() from provider {
//        RootEnvironmentDetector()
//    }

    bind<Timber.Tree>(tag = true) with provider {
        Timber.DebugTree()
    }

    bind<Timber.Tree>(tag = false) with provider {
        TimberTree(instance())
    }

//
//    bind(tag = "program_key") from provider {
//        BuildConfig.WHITE_LABEL_PROGRAM_KEY
//    }

    bind() from provider {
        FirebaseCrashlytics.getInstance()
    }
}
