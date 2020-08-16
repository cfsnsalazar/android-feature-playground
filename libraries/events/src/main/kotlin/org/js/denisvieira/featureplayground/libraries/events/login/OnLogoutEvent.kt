package org.js.denisvieira.libraries.events.login

interface OnLogoutEvent {

    /**
     * This method is executed for clear only sensitive data but keeping some data to simplify
     * the next login, asking only for password or biometry
     */
    fun onSoftLogout() {}

    /**
     * This method is executed when need to clear all user data
     */
    fun onHardLogout() {}

    /**
     * Executed on both soft and hard logout cases
     */
    fun onLogout() {}
}
