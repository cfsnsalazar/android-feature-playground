package org.js.denisvieira.featureplayground.commons.flow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.odete.commonstest.test.CoroutineTestRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.odete.network.core.response.ui.UiState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import org.junit.Rule
import org.junit.Test

class ViewModelKtTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    private val observer = mock<Observer<UiState<String>>>()
    private val flow = mock<Flow<String>>()

    @Test
    fun whenCallToLiveData_verifyIfObserverOnChanged() {

        val result = flow.toLiveData()

        result.observeForever(observer)

        verify(observer).onChanged(any())
    }
}
