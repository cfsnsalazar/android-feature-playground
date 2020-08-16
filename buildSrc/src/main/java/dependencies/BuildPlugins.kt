package dependencies

object BuildPlugins {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginsVersions.KOTLIN}"
    const val GRADLE = "com.android.tools.build:gradle:${PluginsVersions.GRADLE}"
    const val DETEKT = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${PluginsVersions.DETEKT}"
    const val GOOGLE_SERVICES = "com.google.gms:google-services:${PluginsVersions.GOOGLE_SERVICES}"
    const val SONAR = "org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:${PluginsVersions.SONAR}"
    const val JACOCO = "org.jacoco:org.jacoco.core:${PluginsVersions.JACOCO}"
    const val CRASHLYTICS = "com.google.firebase:firebase-crashlytics-gradle:${PluginsVersions.CRASHLYTICS}"
    const val KOTLIN_ALLOPEN = "org.jetbrains.kotlin:kotlin-allopen:${PluginsVersions.KOTLIN}"
    const val NAVIGATION = "android.arch.navigation:navigation-safe-args-gradle-plugin:${PluginsVersions.NAVIGATION}"
    const val FIREBASE_APP_DISTRIBUTION = "com.google.firebase:firebase-appdistribution-gradle:${PluginsVersions.APP_DISTRIBUTION}"
    const val DEXGUARD = "com.guardsquare.dexguard:dexguard-gradle-plugin:"
}
