package org.js.denisvieira.featureplayground.commons.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.util.Log.getStackTraceString
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import timber.log.Timber

interface ImageUtilsInterface {
    fun createImageFile(context: Context): File
    fun getResizedImage(filePath: String): File
    fun rotateImage(source: Bitmap, angle: Float): Bitmap
    fun getOrientedBitmap(filePath: String): Bitmap
    fun createImageAndGetFileUri(context: Context, authority: String, bitmap: Bitmap): Uri
}

object ImageUtils : ImageUtilsInterface {

    private const val MAX_IMAGE_SIZE = 1280
    private const val IMAGE_QUALITY = 90
    private const val ROTATION_ANGLE_90 = 90f
    private const val ROTATION_ANGLE_180 = 180f
    private const val ROTATION_ANGLE_270 = 270f
    private const val TEMP_IMAGE_FILE_NAME = "JPEG_TEMP_FILE_"

    @Throws(IOException::class)
    override fun createImageFile(context: Context): File {
        // Create an image file name
        val storageDir = context.cacheDir
        return File.createTempFile(
            TEMP_IMAGE_FILE_NAME,
            ".jpg",
            storageDir
        )
    }

    override fun getResizedImage(filePath: String): File {
        val bitmap = getOrientedBitmap(filePath)

        val origFile = File(filePath)
        val file = File(origFile.parentFile, "resize.jpg")

        try {
            val fOut = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, IMAGE_QUALITY, fOut)
            fOut.flush()
            fOut.close()
            bitmap.recycle()
            bitmap.recycle()
        } catch (runtimeException: FileNotFoundException) {
            Timber.e("File not found: %s", getStackTraceString(runtimeException))
        } catch (runtimeException: IOException) {
            Timber.e("Failed to compress image: %s", getStackTraceString(runtimeException))
        } finally {
            Timber.d("Image final size -> ${file.length()}")
            return file
        }
    }

    override fun rotateImage(source: Bitmap, angle: Float): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(angle)
        return Bitmap.createBitmap(
            source, 0, 0, source.width, source.height,
            matrix, true
        )
    }

    override fun getOrientedBitmap(filePath: String): Bitmap {
        val bitmap = decodeSampledBitmap(filePath, MAX_IMAGE_SIZE, MAX_IMAGE_SIZE)
        val ei: ExifInterface
        try {
            ei = ExifInterface(filePath)
        } catch (e: IOException) {
            Timber.e(e.message, getStackTraceString(e))
            return bitmap
        }

        val orientation = ei.getAttributeInt(
            ExifInterface.TAG_ORIENTATION,
            ExifInterface.ORIENTATION_UNDEFINED
        )

        return when (orientation) {

            ExifInterface.ORIENTATION_ROTATE_90 -> rotateImage(bitmap, ROTATION_ANGLE_90)

            ExifInterface.ORIENTATION_ROTATE_180 -> rotateImage(bitmap, ROTATION_ANGLE_180)

            ExifInterface.ORIENTATION_ROTATE_270 -> rotateImage(bitmap, ROTATION_ANGLE_270)

            ExifInterface.ORIENTATION_NORMAL -> bitmap
            else -> bitmap
        }
    }

    override fun createImageAndGetFileUri(
        context: Context,
        authority: String,
        bitmap: Bitmap
    ): Uri {
        val file = createImageFile(context)
        val fileOutputStream = FileOutputStream(file)

        bitmap.compress(Bitmap.CompressFormat.JPEG, IMAGE_QUALITY, fileOutputStream)

        return FileProvider.getUriForFile(
            context,
            authority, file
        )
    }

    private fun decodeSampledBitmap(filePath: String, reqWidth: Int, reqHeight: Int): Bitmap {

        // First decode with inJustDecodeBounds=true to check dimensions
        val options = decodeBounds(filePath)

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight)

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false
        return BitmapFactory.decodeFile(filePath, options)
    }

    private fun calculateInSampleSize(
        options: BitmapFactory.Options,
        reqWidth: Int,
        reqHeight: Int
    ): Int {
        // Raw height and width of image
        val height = options.outHeight
        val width = options.outWidth
        var inSampleSize = 1

        if (height > reqHeight || width > reqWidth) {

            val halfHeight = height / 2
            val halfWidth = width / 2

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2
            }
        }

        return inSampleSize
    }

    private fun decodeBounds(filePath: String): BitmapFactory.Options {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeFile(filePath, options)
        return options
    }
}
