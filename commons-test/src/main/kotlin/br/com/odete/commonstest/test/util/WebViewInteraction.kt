package br.com.odete.commonstest.test.util

import android.view.View
import android.webkit.WebView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

fun withUrl(url: String): Matcher<View> {
    return WebViewUrlMatcher(url)
}

private class WebViewUrlMatcher(
    private val url: String
) : BoundedMatcher<View, WebView>(WebView::class.java) {

    override fun describeTo(description: Description) {
        description.appendText("url loaded was not $url")
    }

    override fun matchesSafely(item: WebView): Boolean {
        val currentBrowserUrl = removeLastBackSlashFromUrl(item.url)
        return currentBrowserUrl == url
    }

    private fun removeLastBackSlashFromUrl(url: String): String {
        return if (url.endsWith("/")) {
            url.substring(0, url.length - 1)
        } else
            url
    }
}
