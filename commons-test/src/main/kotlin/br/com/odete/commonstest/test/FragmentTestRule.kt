package br.com.odete.commonstest.test

import androidx.fragment.app.Fragment
import androidx.test.rule.ActivityTestRule

class FragmentTestRule<FRAGMENT : Fragment> :
    ActivityTestRule<FragmentTestActivity>(FragmentTestActivity::class.java, true, true) {

    var fragment: FRAGMENT? = null
        private set

    /**
     * Launch a Fragment in a BaseFragmentTestActivity
     * @param fragment Fragment to be inflated
     */
    fun launchFragment(fragment: FRAGMENT) {
        this@FragmentTestRule.fragment = fragment
        activity.runOnUiThread {
            val manager = activity.supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(android.R.id.content, fragment, fragment.toString())
            transaction.commit()
        }
    }

    fun setTheme(themeId: Int) {
        activity.setTheme(themeId)
    }

    fun isBackPressed() = fragment?.activity == null
}
