package org.js.denisvieira.featureplayground.commons.utils

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EmailValidatorTest {
    private val emailValidator = EmailValidator()

    @Test
    fun givenEmptyEmail_whenCheckIfIsValid_shouldReturnFalse() {
        val isValid = emailValidator.isValid("")

        assertFalse(isValid)
    }

    @Test
    fun givenBlankEmail_whenCheckIfIsValid_shouldReturnFalse() {
        val isValid = emailValidator.isValid("     ")

        assertFalse(isValid)
    }

    @Test
    fun givenInvalidEmail_whenCheckIfIsValid_shouldReturnFalse() {
        val isValid = emailValidator.isValid("a@a")

        assertFalse(isValid)
    }

    @Test
    fun givenOnlyAtEmail_whenCheckIfIsValid_shouldReturnFalse() {
        val isValid = emailValidator.isValid("@")

        assertFalse(isValid)
    }

    @Test
    fun givenEmailWithoutHost_whenCheckIfIsValid_shouldReturnFalse() {
        val isValid = emailValidator.isValid("email@")

        assertFalse(isValid)
    }

    @Test
    fun givenEmailWithoutAt_whenCheckIfIsValid_shouldReturnFalse() {
        val isValid = emailValidator.isValid("email")

        assertFalse(isValid)
    }

    @Test
    fun givenValidEmail_whenCheckIfIsValid_shouldReturnTrue() {
        val isValid = emailValidator.isValid("email@cartaobranco.com.br")

        assertTrue(isValid)
    }
}
