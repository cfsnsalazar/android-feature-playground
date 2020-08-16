package br.com.odete.commonstest.test.util

import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.allOf

fun toolbarWithText(title: String) = allOf(
    isAssignableFrom(TextView::class.java),
    withParent(
        isAssignableFrom(Toolbar::class.java)
    ),
    withText(title)
)

fun toolbarWithText() = allOf(
    isAssignableFrom(TextView::class.java),
    withParent(
        isAssignableFrom(Toolbar::class.java)
    )
)
