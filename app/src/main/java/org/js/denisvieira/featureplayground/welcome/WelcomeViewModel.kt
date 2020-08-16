package org.js.denisvieira.featureplayground.welcome

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.odete.router.IntentUtils

internal class WelcomeViewModel(
    private val intentUtils: IntentUtils
) : ViewModel() {

    private var _nextStep = MutableLiveData<Intent>()
    val nextStep: LiveData<Intent> = _nextStep

    companion object {
        private const val TRUE = 1
    }

//    fun validateNextStep(context: Context) {
//        when {
//            isUserPreLogged() -> _nextStep.value = intentUtils.createLogoutIntent()
//            isUserLoggedIn() -> _nextStep.value = intentUtils.createHomeIntent()
//        }
//    }

    private fun isUserPreLogged(): Boolean {
//        return sessionManager.isPreLogged
        return false
    }

//    private fun isUserRootEnable(context: Context) = detector.hasVulnerability(context) == TRUE

    private fun isUserLoggedIn(): Boolean {
//        return sessionManager.isLoggedIn
        return true
    }

//    fun getLoginIntent() =
//        intentUtils.createLoginIntent()

}
