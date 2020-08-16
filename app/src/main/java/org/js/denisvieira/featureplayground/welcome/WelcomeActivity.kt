package org.js.denisvieira.featureplayground.welcome

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.js.denisvieira.featureplayground.commons.di.viewmodel.viewModel
import org.js.denisvieira.featureplayground.R
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein

class WelcomeActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by kodein()
    private val welcomeViewModel: WelcomeViewModel by viewModel(WelcomeViewModel::class.java)

    companion object {
        operator fun invoke(context: Context): Intent {
            return Intent(context, WelcomeActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        verifyUserLoggedIn()
        prepareLayout()
    }

    private fun verifyUserLoggedIn() {

//        welcomeViewModel.nextStep.observe(
//            this,
//            Observer { result ->
//                startActivity(result)
//                finish()
//            }
//        )
    }

    private fun prepareLayout() {
    }

    private fun startLogin() {
//        startActivity(welcomeViewModel.getLoginIntent())
    }

}
