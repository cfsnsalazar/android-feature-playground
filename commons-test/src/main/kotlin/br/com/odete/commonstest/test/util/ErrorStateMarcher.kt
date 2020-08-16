package br.com.odete.commonstest.test.util

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withResourceName
import org.hamcrest.Matcher

fun withErrorStateRetryButton(): Matcher<View> = withResourceName("btn_positive_feedback_view")
