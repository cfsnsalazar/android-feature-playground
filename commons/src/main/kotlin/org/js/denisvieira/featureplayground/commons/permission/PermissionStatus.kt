package org.js.denisvieira.featureplayground.commons.permission

sealed class PermissionStatus {
    /**
     * Can Ask Permission is used when not you do not have the permission if the
     * user not check the Never ask again.
     */
    object CanAskPermission : PermissionStatus()

    /**
     * User enable permission
     */
    object PermissionGranted : PermissionStatus()

    /**
     * User denied permission and/or check the Never ask again.
     */
    object PermissionDenied : PermissionStatus()

    /**
     * When ask permission for fist time, the permission status is empty
     */
    object PermissionEmpty : PermissionStatus()
}
