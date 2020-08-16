package br.com.odete.commonstest.test.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

class KodeinMockFragmentFactory(private val fragment: Fragment) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return fragment
    }
}
