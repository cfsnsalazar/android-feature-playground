package br.com.odete.commonstest.test.util

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

fun withDrawable(resourceId: Int): Matcher<View> {
    return DrawableMatcher(resourceId)
}

fun noDrawable(): Matcher<View> {
    return DrawableMatcher(DrawableMatcher.EMPTY)
}

class DrawableMatcher internal constructor(private val expectedId: Int) :
    TypeSafeMatcher<View>(View::class.java) {

    private var resourceName: String? = null

    override fun matchesSafely(target: View): Boolean {

        if (target !is ImageView) {
            return false
        }
        if (expectedId == EMPTY) {
            return target.drawable == null
        }
        if (expectedId == ANY) {
            return target.drawable != null
        }
        val resources = target.getContext().resources
        val expectedDrawable = resources.getDrawable(expectedId)
        resourceName = resources.getResourceEntryName(expectedId)

        if (expectedDrawable == null) {
            return false
        }

        val bitmap = getBitmap(target.drawable)
        val otherBitmap = getBitmap(expectedDrawable)
        return bitmap.sameAs(otherBitmap)
    }

    override fun describeTo(description: Description) {
        description.appendText("with drawable from resource id: ")
        description.appendValue(expectedId)
        if (resourceName != null) {
            description.appendText("[")
            description.appendText(resourceName)
            description.appendText("]")
        }
    }

    companion object {
        const val EMPTY = -1
        const val ANY = -2
    }
}

private fun getBitmap(drawable: Drawable): Bitmap {
    val bitmap = Bitmap.createBitmap(
        drawable.intrinsicWidth, drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )
    val canvas = Canvas(bitmap)
    drawable.setBounds(0, 0, canvas.width, canvas.height)
    drawable.draw(canvas)
    return bitmap
}

enum class WithTextViewDrawable(val position: Int) {

    LEFT_DRAWABLE(0),
    TOP_DRAWABLE(1),
    RIGHT_DRAWABLE(2),
    BOTTOM_DRAWABLE(3)
}

fun withTextViewDrawable(
    @DrawableRes expectedId: Int,
    drawablePosition: WithTextViewDrawable
): Matcher<View> {
    return object : TypeSafeMatcher<View>() {

        override fun describeTo(description: Description) {
            description.appendText("with drawable from resource id: $expectedId")
        }

        override fun matchesSafely(item: View): Boolean {

            if (item !is TextView) {
                return false
            }

            val expectedDrawable = ContextCompat.getDrawable(item.context, expectedId)
                ?: return false

            val bitmap = getBitmap(item.compoundDrawables[drawablePosition.position])
            val otherBitmap = getBitmap(expectedDrawable)
            return bitmap.sameAs(otherBitmap)
        }
    }
}
