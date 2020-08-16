package org.js.denisvieira.featureplayground.commons.utils

import android.graphics.Bitmap
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.odete.commons.BuildConfig
import org.js.denisvieira.featureplayground.commons.fileprovider.FileProviderUtilsImpl
import org.junit.Assert.assertFalse
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

@Ignore
@RunWith(AndroidJUnit4::class)
class ImageUtilsTest {
    @Test
    fun whenCreateImageAndGetFileUri_verifyUriIsNotEmpty() {
        val uri = ImageUtils.createImageAndGetFileUri(
            getApplicationContext(),
            FileProviderUtilsImpl.getAuthority(BuildConfig.FLAVOR),
            Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888)
        )

        assertFalse(uri.toString().isEmpty())
    }
}
