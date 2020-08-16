package org.js.denisvieira.libraries.events.app

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

class OnCreateAppTest {

    private val listenerA = mock<OnCreateAppListener>()
    private val listenerB = mock<OnCreateAppListener>()

    private val target = OnCreateApp(setOf(listenerA, listenerB))

    @Test
    fun whenExecute_shouldCallAllListenersRun() {
        target.execute()

        verify(listenerA).run()
        verify(listenerB).run()
    }
}
