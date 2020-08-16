package br.com.odete.commonstest.test.mock

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

@Deprecated("Mock using DI instead of this")
class SessionManagerRule : TestRule {

    companion object {
        const val ENTITY_NAME = "Tiger Costa"
        const val LIMIT_AVAILABLE = 502.13f
        const val AUTORIZATION = "asdfghjkl;1234567890"
        const val ACCOUNT_ID = 1234L
        const val CUSTOMER_ID = 12345L
        const val DOCUMENT = "123.456.789-73"
        const val KEY =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAljjU2GuCeGIvl80CuK0+GXxy85xJk0ABvrIU/xOEocURPprhrvZAYXKZIMBqcZqmfMm0XaLYvOBQZ+xXAPbMAIoMt5pJesW2xmDjsvAeEAK5uG/s+c8aeO3YvaOBEbZJlBM169+cV63tjImicYKEH30Zc64j9Jv22WNvlfqCg9qA2tmnqeedNjUHvFh+QeNle7hlGUEqjYLMs2n/44MpUq2e/DHlBZt/YBZgytuxDR8WXJjgdJJ0zPMh8zDRl96zwsLknhaSO2k5N3S2m9lJvl/YPY5fgxX0Fr+FIg8m8YW9AKJ7Y51x/cq/0xS5jb/mAwsPiTouW1qYmWZSDVVP2wIDAQAB"
    }

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                initSessionManager()
                base.evaluate()
            }
        }
    }

    private fun initSessionManager() {
    }
}
