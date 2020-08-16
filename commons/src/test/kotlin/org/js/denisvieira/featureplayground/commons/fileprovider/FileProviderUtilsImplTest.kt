package org.js.denisvieira.featureplayground.commons.fileprovider

import com.odete.commons.BuildConfig
import org.junit.Assert.assertEquals
import org.junit.Test

class FileProviderUtilsImplTest {

    @Test
    fun whenGetAuthority_verifyAuthorityIsCorrect() {
        val flavor = "cartaobranco"

        val authority =
            "com.odete.$flavor.${BuildConfig.BUILD_TYPE_SULFIX}.fileprovider"

        assertEquals(authority, FileProviderUtilsImpl.getAuthority(flavor))
    }

    @Test
    fun whenEmptyFlavorSuffix_ShouldNotConcatSeparator() {
        val flavor = ""

        val authority =
            "com.odete.${BuildConfig.BUILD_TYPE_SULFIX}.fileprovider"

        assertEquals(authority, FileProviderUtilsImpl.getAuthority(flavor))
    }
}
