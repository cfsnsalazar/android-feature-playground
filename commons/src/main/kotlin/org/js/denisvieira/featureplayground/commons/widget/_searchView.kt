package org.js.denisvieira.featureplayground.commons.widget

import android.graphics.PorterDuff
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import com.odete.commons.R

fun SearchView.changeSearchIconColor(color: Int): ImageView? {
    return this.changeSearchViewIconColor(R.id.search_button, color)
}

fun SearchView.changeCloseIconColor(color: Int): ImageView? {
    return this.changeSearchViewIconColor(R.id.search_close_btn, color)
}

fun SearchView.changeSearchViewIconColor(iconId: Int, color: Int): ImageView? {
    val searchViewIcon: ImageView? = this.findViewById(iconId)
    val searchViewIconColor = ContextCompat.getColor(this.context, color)
    searchViewIcon?.setColorFilter(searchViewIconColor, PorterDuff.Mode.SRC_ATOP)
    return searchViewIcon
}
