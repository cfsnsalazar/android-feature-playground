//package com.izio.application.modules.signin
//
//import android.content.Context
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.izio.application.helper.events.Event
//import com.izio.application.helper.events.SingleLiveEvent
//import com.izio.application.helper.viewmodelobserver.BaseObserversWithSingleEventOnSuccess
//import org.js.denisvieira.features.signin.dto.SignUpUserDto
//import org.js.denisvieira.features.signin.dto.SimpleAuthDto
//import org.js.denisvieira.features.signin.dto.SocialAuthDto
//import com.izio.application.usecases.UseCase
//import com.izio.application.utils.ImageUtil
//import com.izio.domain.entities.user.UserSession
//import com.izio.injections.InjectionUseCase
//import com.izio.services.remote.auth.dto.SimpleAuthRequest
//import com.izio.services.remote.auth.dto.SocialAuthRequest
//import com.izio.services.remote.user.dto.CreateSocialUserRequest
//import com.izio.services.remote.user.dto.CreateUserRequest
//import java.text.SimpleDateFormat
//import java.util.*
//
//class SignInViewModel(context: Context) : ViewModel() {
//
//    private val mAuthUseCase             = InjectionUseCase.provideAuthorizationUseCase(context)
//    private val mCreateSocialUserUseCase = InjectionUseCase.provideCreateSocialUserUseCase(context)
//
//    val mAuthObservers = BaseObserversWithSingleEventOnSuccess<UserSession>()
//
//    fun auth(simpleAuthDto: SimpleAuthDto) {
//        val authRequest = SimpleAuthRequest(
//            simpleAuthDto.email,
//            simpleAuthDto.password
//        )
//
//        mAuthUseCase.authorize(authRequest, object : UseCase.UseCaseCallback<UserSession> {
//            override fun onSuccess(response: UserSession) {
//                mAuthObservers.onSuccessMainDataObserver.value = Event(response)
//            }
//
//            override fun isLoading(isLoading: Boolean) {
//                mAuthObservers.isLoadingMainDataObserver.value = isLoading
//            }
//
//            override fun onError(errorDescription: String) {
//                mAuthObservers.onErrorMainDataObserver.value = errorDescription
//            }
//
//        })
//    }
//
//    fun authSocial(socialAuthDto: SocialAuthDto) {
//        val authSocialRequest = SocialAuthRequest(
//            socialAuthDto.email,
//            socialAuthDto.tokenType,
//            socialAuthDto.token
//        )
//
//        mAuthUseCase.authorizeSocial(authSocialRequest, object : UseCase.UseCaseCallback<UserSession> {
//            override fun onSuccess(response: UserSession) {
//                mAuthObservers.onSuccessMainDataObserver.value = Event(response)
//            }
//
//            override fun isLoading(isLoading: Boolean) {
//                mAuthObservers.isLoadingMainDataObserver.value = isLoading
//            }
//
//            override fun onError(errorDescription: String) {
//                socialSignUp(socialAuthDto)
//            }
//
//        })
//    }
//
//    private fun socialSignUp(socialAuthDto: SocialAuthDto) {
//        val authSocialRequest = CreateSocialUserRequest(
//            socialAuthDto.name,
//            socialAuthDto.email,
//            socialAuthDto.tokenType,
//            socialAuthDto.token,
//            convertToStringDateFormat(socialAuthDto.birthdayDate),
//            ImageUtil.convert(socialAuthDto.profileImage)
//        )
//
//        mCreateSocialUserUseCase.create(authSocialRequest, object : UseCase.UseCaseCallback<UserSession> {
//            override fun onSuccess(response: UserSession) {
//                mAuthObservers.onSuccessMainDataObserver.value = Event(response)
//            }
//
//            override fun isLoading(isLoading: Boolean) {
//                mAuthObservers.isLoadingMainDataObserver.value = isLoading
//            }
//
//            override fun onError(errorDescription: String) {
//                mAuthObservers.onErrorMainDataObserver.value = errorDescription
//            }
//
//        })
//    }
//
//    private fun convertToStringDateFormat(date: Date?): String? {
//        if(date == null) return null
//
//        val myFormat = "yyyy-MM-dd"
//        val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
//
//        return sdf.format(date)
//    }
//
//
//    class SignInViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
//        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//            return SignInViewModel(context) as T
//        }
//
//    }
//
//
//}
