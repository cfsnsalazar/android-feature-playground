package org.js.denisvieira.featureplayground.platform

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

internal class TimberTree(
    private val crashlytics: FirebaseCrashlytics
) : Timber.Tree() {

    @SuppressWarnings("TooGenericExceptionCaught")
    override fun log(priority: Int, tag: String?, message: String, error: Throwable?) {
        if (priority != Log.ERROR) return
        val err = try {
            throw error ?: RuntimeException("$tag: $message")
        } catch (e: Throwable) {
            e
        }
        crashlytics.recordException(err)
    }
}
