object AndroidConfig {

    const val APPLICATION_ID = "com.odete"

    const val COMPILE_SDK = 29
    const val MIN_SDK = 21
    const val TARGET_SDK = COMPILE_SDK
    const val INSTRUMENTATION_TEST_RUNNER = "br.com.odete.commonstest.test.di.CustomTestRunner"
    const val JAVA_VERSION = 1.8
}

object Source {
    const val MAIN = "src/main/kotlin"
    const val TEST = "src/test/kotlin"
    const val ANDROID_TEST = "src/androidTest/kotlin"
    const val SHARED_TEST = "src/sharedTest/kotlin"
    const val SHARED_TEST_RESOURCES = "src/sharedTest/resources"
}

object RepositoriesUri {
    const val SONATYPE = "https://oss.sonatype.org/content/repositories/snapshots/"
    const val JITPACK = "https://jitpack.io"
    const val ZENDESK = "https://zendesk.jfrog.io/zendesk/repo"
    const val SAFE_ROOM = "https://s3.amazonaws.com/repo.commonsware.com"
    const val ARTIFACTORY = "http://artifactory.plataformacb.com:4434/artifactory/public-group"
}