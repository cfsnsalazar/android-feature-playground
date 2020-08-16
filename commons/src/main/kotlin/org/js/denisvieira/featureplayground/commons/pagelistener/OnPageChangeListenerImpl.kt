package org.js.denisvieira.featureplayground.commons.pagelistener

import androidx.viewpager.widget.ViewPager

abstract class OnPageChangeListenerImpl : ViewPager.OnPageChangeListener {
    override fun onPageSelected(position: Int) {
        // empty
    }

    override fun onPageScrollStateChanged(state: Int) {
        // empty
    }

    override fun onPageScrolled(position: Int, offset: Float, offsetPixels: Int) {
        // empty
    }
}
