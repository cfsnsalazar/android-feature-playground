package br.com.odete.commonstest.test.network

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

@Deprecated("Create a correct mock instead of this")
class NetworkRule : TestRule {

    companion object {
        const val PROGRAM_KEY = "T1gErSup3rK3Y"
    }

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                base.evaluate()
                throw error("Do not use this and created a correct mock")
            }
        }
    }
}
