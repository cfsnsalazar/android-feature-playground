package org.js.denisvieira.featureplayground.commons.utils.imagetuils

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.js.denisvieira.featureplayground.commons.utils.ImageUtils
import java.io.File
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.Matchers.lessThan
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FileCreationTest {

    private lateinit var createdImage: File

    @Test
    fun shouldCreateFile() {
        createdImage =
            ImageUtils.createImageFile(ApplicationProvider.getApplicationContext())
        assertThat(createdImage.exists(), `is`(true))
    }

    @Test
    fun createdFileShouldBeJPG() {
        createdImage =
            ImageUtils.createImageFile(ApplicationProvider.getApplicationContext())
        assertThat(createdImage.absolutePath.endsWith(".jpg"), `is`(true))
    }

    @Test
    fun whenImageResized_ShouldBeSmaller() {
        val createdImage = File(javaClass.classLoader!!.getResource("android_mock.jpg").file)
        val resizedImage =
            ImageUtils.getResizedImage(createdImage.absolutePath)
        assertThat(resizedImage.length(), lessThan(createdImage.length()))
    }

    @Test
    fun whenImageRotated_shouldConstainsDifferentDimensions() {
        val path = File(javaClass.classLoader!!.getResource("android_mock.jpg").file)
        val createdImage =
            ImageUtils.getOrientedBitmap(path.absolutePath)
        val rotatedImage = ImageUtils.rotateImage(createdImage, 90f)
        assertEquals(rotatedImage.width, createdImage.height)
    }
}
