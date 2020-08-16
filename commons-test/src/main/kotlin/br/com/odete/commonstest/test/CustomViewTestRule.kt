package br.com.odete.commonstest.test

import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.test.rule.ActivityTestRule

class CustomViewTestRule : ActivityTestRule<FragmentTestActivity> {

    private var resourceId: Int? = null
    lateinit var view: View

    constructor(resourceId: Int) : super(
        FragmentTestActivity::class.java,
        true, true
    ) {
        this.resourceId = resourceId
    }

    constructor(view: View) : super(
        FragmentTestActivity::class.java,
        true, false
    ) {
        this.view = view
    }

    override fun afterActivityLaunched() {
        super.afterActivityLaunched()

        addViewOnContentLayout()
    }

    private fun addViewOnContentLayout() {
        runOnUiThread {
            val frameLayout = activity.findViewById<FrameLayout>(android.R.id.content)

            resourceId?.let {
                view = LayoutInflater.from(activity).inflate(it, frameLayout, false)
            }

            frameLayout.addView(view)
        }
    }
}
