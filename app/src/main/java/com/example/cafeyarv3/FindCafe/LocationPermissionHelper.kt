package com.example.cafeyarv3.FindCafe

import android.app.Activity
import android.content.Context
import android.widget.Toast
import com.mapbox.android.core.permissions.PermissionsListener
import com.mapbox.android.core.permissions.PermissionsManager
import java.lang.ref.WeakReference

/**
 * Created by abolfazl_dv on 04,May,2022
 */
class LocationPermissionHelper(val activity: WeakReference<Activity>) {
    private lateinit var permissionsManager: PermissionsManager

    fun checkPermission(onMapReady: () -> Unit) {
        if (PermissionsManager.areLocationPermissionsGranted(activity.get())) {
            onMapReady()
        } else {
            permissionsManager = PermissionsManager(object : PermissionsListener {
                override fun onExplanationNeeded(p0: MutableList<String>?) {
                    Toast.makeText(
                        activity.get(),
                        "you need to accept location permission",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onPermissionResult(granted: Boolean) {
                    if (granted) {
                        onMapReady()
                    } else {
                        activity.get()?.finish()
                    }
                }

            })
            permissionsManager.requestLocationPermissions(activity.get())
        }
    }

    fun onRequestPermissionResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }
}