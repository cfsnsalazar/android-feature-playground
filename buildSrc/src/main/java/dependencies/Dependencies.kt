package dependencies

object Dependencies {

    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${PluginsVersions.KOTLIN}"

    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"

    const val OKHTTP_LOGGER = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"

    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"

    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"

    const val MATERIAL_DESIGN = "com.google.android.material:material:${Versions.SUPPORT_LIBRARY}"

    const val PAGING = "android.arch.paging:runtime:${Versions.PAGING}"

    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"

//    const val PIN_VIEW = "com.chaos.view:pinview:${Versions.PIN_VIEW}"

    const val LOTTLE = "com.airbnb.android:lottie:${Versions.LOTTIE}"

    const val HAWK = "com.orhanobut:hawk:${Versions.HAWK}"

//    const val CANARINHO = "br.com.concrete:canarinho:${Versions.CANARINHO}"

    const val LOADING_BUTTON = "br.com.simplepass:loading-button-android:${Versions.LOADING_BUTTON}"
    const val VIEWPAGER = "androidx.viewpager:viewpager:${Versions.VIEWPAGER}"

    object Android {
        const val EXIF_INTERFACE = "androidx.exifinterface:exifinterface:${Versions.SUPPORT_LIBRARY_X}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        const val FRAGMENT = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT}"
        const val CARD_VIEW = "androidx.cardview:cardview:${Versions.SUPPORT_LIBRARY_X}"
        const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.SUPPORT_LIBRARY_X}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT_X}"
        const val DESIGN = "com.google.android.material:material:${Versions.DESIGN}"
        const val CORE_COMMON = "androidx.arch.core:core-common:${Versions.CORE_ARCH}"
        const val CORE_RUNTIME = "androidx.arch.core:core-runtime:${Versions.CORE_ARCH}"
        const val ANNOTATION = "androidx.annotation:annotation:${Versions.ANNOTATION}"
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
        const val TRANSITION = "androidx.transition:transition:${Versions.TRANSITION}"
        const val BIOMETRICS = "androidx.biometric:biometric:${Versions.BIOMETRICS}"
        const val VIEW_PAGER_2 = "androidx.viewpager2:viewpager2:${Versions.VIEW_PAGER_2}"
        const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    }

    object Lifecycle {
        const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_X}"
        const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_X}"
        const val RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_X}"
        const val EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE_X}"
        const val COMPILER = "androidx.lifecycle:lifecycle-compiler:${Versions.LIFECYCLE_X}"
    }

    object Kodein {
        const val GENERIC = "org.kodein.di:kodein-di-generic-jvm:${Versions.KODEIN}"
        const val CONF = "org.kodein.di:kodein-di-conf-jvm:${Versions.KODEIN}"
        const val ANDROID = "org.kodein.di:kodein-di-framework-android-x:${Versions.KODEIN}"
    }

    object Navigation {
        const val UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
        const val FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    }

    object Firebase {
        const val CORE = "com.google.firebase:firebase-core:${Versions.GOOGLE_SERVICE}"
        const val MESSAGE = "com.google.firebase:firebase-messaging:${Versions.FCM_FIREBASE}"
        const val ANALYTICS = "com.google.firebase:firebase-analytics:${Versions.ANALYTICS}"
        const val CONFIG = "com.google.firebase:firebase-config:${Versions.REMOTE_CONFIG}"
        const val CRASHLYTICS = "com.google.firebase:firebase-crashlytics:${Versions.CRASHLYTICS}"
    }

    object Adjust {
        const val LIBRARY = "com.adjust.sdk:adjust-android:${Versions.ADJUST}"
        const val INSTALL_REFERRER = "com.android.installreferrer:installreferrer:${Versions.INSTALL_REFERRER}"
        const val GOOGLE_PLAY_ADS_IDENTIFIER = "com.google.android.gms:play-services-ads-identifier:${Versions.GOOGLE_PLAY_ADS_IDENTIFIER}"
    }

    object Room {
        const val COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
        const val RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
    }

    object Coroutines {
        const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
        const val ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    }

    object GoogleService {
        const val LOCATION = "com.google.android.gms:play-services-location:${Versions.GOOGLE_SERVICE_LOCATION}"
    }
}
