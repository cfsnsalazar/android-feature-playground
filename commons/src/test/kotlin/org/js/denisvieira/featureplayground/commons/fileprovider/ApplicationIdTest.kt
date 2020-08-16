package org.js.denisvieira.featureplayground.commons.fileprovider

import org.junit.Assert.assertEquals
import org.junit.Test

class ApplicationIdTest {

    @Test
    fun whenApplicationIdCalled_ShouldReturnAppApplicationId() {
        val flavorTypeSuffix = "flavorName"
        val result = getApplicationId(flavorTypeSuffix)

        assertEquals("com.odete.flavorName.dev", result)
    }
}
