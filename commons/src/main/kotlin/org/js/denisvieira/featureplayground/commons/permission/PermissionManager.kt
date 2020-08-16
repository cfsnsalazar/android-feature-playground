package org.js.denisvieira.featureplayground.commons.permission

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission

object PermissionManager {

    fun getPermissionStatus(activity: Activity, permission: String): PermissionStatus {
        return when {
            PackageManager.PERMISSION_GRANTED == checkSelfPermission(
                activity,
                permission
            ) -> PermissionStatus.PermissionGranted

            else -> PermissionStatus.CanAskPermission
        }
    }

    fun getPermissionStatus(
        activity: Activity,
        permission: String,
        grantResults: IntArray
    ): PermissionStatus {
        return when {
            grantResults.isNotEmpty() && grantResults.first()
                == PackageManager.PERMISSION_GRANTED -> PermissionStatus.PermissionGranted

            else ->
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission))
                    PermissionStatus.CanAskPermission
                else
                    PermissionStatus.PermissionDenied
        }
    }
}
