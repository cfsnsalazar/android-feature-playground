package org.js.denisvieira.featureplayground.commons.permission

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class PermissionManagerTest {

    @Mock
    private lateinit var activity: Activity

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun whenGetPermissionActivityResultsPermissionDenied_ShouldReturn_PermissionDenied() {
        whenever(activity.shouldShowRequestPermissionRationale(eq(Manifest.permission.READ_EXTERNAL_STORAGE)))
            .thenReturn(false)

        val grantResult = intArrayOf(PackageManager.PERMISSION_DENIED)

        val permissionStatus = PermissionManager.getPermissionStatus(
            activity,
            Manifest.permission.READ_EXTERNAL_STORAGE, grantResult
        )

        assertEquals(PermissionStatus.PermissionDenied, permissionStatus)
    }

    @Test
    fun whenGetPermissionActivityResultPermissionGranted_ShouldReturn_PermissionDenied() {
        val grantResult = intArrayOf(PackageManager.PERMISSION_GRANTED)

        val permissionStatus = PermissionManager.getPermissionStatus(
            activity,
            Manifest.permission.READ_EXTERNAL_STORAGE, grantResult
        )

        assertEquals(PermissionStatus.PermissionGranted, permissionStatus)
    }

    @Test
    fun whenGetPermissionActivityResultPermissionDenied_ShouldReturn_CanAskPermission() {
        whenever(activity.shouldShowRequestPermissionRationale(eq(Manifest.permission.READ_EXTERNAL_STORAGE)))
            .thenReturn(true)

        val grantResult = intArrayOf(PackageManager.PERMISSION_DENIED)

        val permissionStatus = PermissionManager.getPermissionStatus(
            activity,
            Manifest.permission.READ_EXTERNAL_STORAGE, grantResult
        )

        assertEquals(PermissionStatus.CanAskPermission, permissionStatus)
    }

    @Test
    fun whenPermissionNotGranted_ShouldReturn_CanAskPermission() {
        mockCheckPermission(PackageManager.PERMISSION_DENIED)

        whenever(activity.shouldShowRequestPermissionRationale(eq(Manifest.permission.READ_EXTERNAL_STORAGE)))
            .thenReturn(true)

        val permissionStatus = PermissionManager.getPermissionStatus(
            activity,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )

        assertEquals(PermissionStatus.CanAskPermission, permissionStatus)
    }

    @Test
    fun whenPermissionGranted_ShouldReturn_PermissionGranted() {
        whenever(
            activity.checkPermission(
                eq(Manifest.permission.READ_EXTERNAL_STORAGE),
                anyInt(), anyInt()
            )
        ).thenReturn(PackageManager.PERMISSION_GRANTED)

        val permissionStatus = PermissionManager.getPermissionStatus(
            activity,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )

        assertEquals(PermissionStatus.PermissionGranted, permissionStatus)
    }

    private fun mockCheckPermission(permission: Int) {
        whenever(
            activity.checkPermission(
                eq(Manifest.permission.READ_EXTERNAL_STORAGE),
                anyInt(), anyInt()
            )
        ).thenReturn(permission)
    }
}
