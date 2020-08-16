package org.js.denisvieira.featureplayground.commons.cache

import android.app.Application
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

class CacheConfiguratorTest {

    private val cacheManager = mock<CacheManager>()
    private val application = mock<Application>()

    private val cacheConfigurator = CacheConfigurator(cacheManager, application)

    @Test
    fun whenRun_shouldCallCacheManagerInitWithApplication() {
        cacheConfigurator.run()

        verify(cacheManager).init(application)
    }
}
