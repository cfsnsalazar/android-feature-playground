package org.js.denisvieira.featureplayground.commons.flow

import androidx.lifecycle.liveData
import org.js.denisvieira.featureplayground.commons.utils.ErrorResponse
//import com.odete.network.core.response.ui.ErrorData
//import com.odete.network.core.response.ui.UiError
//import com.odete.network.core.response.ui.UiLoading
//import com.odete.network.core.response.ui.UiSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import java.lang.IllegalStateException
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

private const val DEFAULT_TIMEOUT = 60000L

//fun <T> Flow<T>.toLiveData(
//    context: CoroutineContext = EmptyCoroutineContext
//) = liveData(context = context, timeoutInMs = DEFAULT_TIMEOUT) {
//    emit(UiLoading)
//    try {
//        collect { emit(UiSuccess(it)) }
//    } catch (e: ErrorResponse) {
//        emit(UiError(ErrorData(e.cause, e.code, e.errorBody)))
//    } catch (e: IllegalStateException) {
//        emit(UiError(ErrorData(e)))
//    }
//}
