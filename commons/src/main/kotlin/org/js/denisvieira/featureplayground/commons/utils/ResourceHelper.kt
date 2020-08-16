package org.js.denisvieira.featureplayground.commons.utils

import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import java.lang.ref.WeakReference

class ResourceHelper(resources: Resources) {

    private val resourceReference = WeakReference(resources)

    fun getDrawable(@DrawableRes image: Int, @ColorRes color: Int? = null): Drawable? {
        resourceReference.get()?.let {
            val drawable = ResourcesCompat.getDrawable(it, image, null)
            if (drawable != null && color != null)
                DrawableCompat.setTint(drawable, ResourcesCompat.getColor(it, color, null))

            return drawable
        }
        return null
    }

    fun requireResource() = resourceReference.get()!!
}
