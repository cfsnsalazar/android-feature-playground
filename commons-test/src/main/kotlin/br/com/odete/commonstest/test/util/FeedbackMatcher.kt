package br.com.odete.commonstest.test.util

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withResourceName
import androidx.test.espresso.matcher.ViewMatchers.withTagValue
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher

fun withFeedbackViewTitle(): Matcher<View> = withResourceName("title_feedback_view")

fun withFeedbackViewImage(): Matcher<View> = allOf(
    withResourceName("img_feedback_view"), not(isDescendantOfA(withTagValue(`is`("errorViewTag"))))
)

fun withFeedbackViewButtonPositive(): Matcher<View> = withResourceName("btn_positive_feedback_view")

fun withFeedbackViewButtonNegative(): Matcher<View> = withResourceName("btn_negative_feedback_view")

fun withFeedbackViewDescription(): Matcher<View> = withResourceName("description_feedback_view")

fun withFeedbackViewMessage(): Matcher<View> = withResourceName("message_feedback_view")

fun withErrorViewRetryButton(): Matcher<View> =
    allOf(withFeedbackViewButtonPositive(), isDescendantOfA(withTagValue(`is`("errorViewTag"))))

fun withErrorViewImage(): Matcher<View> = allOf(
    withResourceName("img_feedback_view"), isDescendantOfA(withTagValue(`is`("errorViewTag")))
)
