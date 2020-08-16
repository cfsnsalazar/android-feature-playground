package org.js.denisvieira.featureplayground.commons.widget

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.graphics.Bitmap
import android.graphics.Canvas

fun Boolean.visible() = if (this) VISIBLE else GONE

fun View.visible(boolean: Boolean) {
    visibility = if (boolean) VISIBLE else GONE
}

fun View.createBitmap(): Bitmap {
    val bitmap: Bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    draw(canvas)
    return bitmap
}
