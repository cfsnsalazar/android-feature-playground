package com.odete.commons.nativetype

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class NativeType<INSTANCE> private constructor(
    val resource: Int?,
    val instance: @RawValue INSTANCE?
) : Parcelable {

    companion object {
        operator fun <INSTANCE> invoke(resource: Int): NativeType<INSTANCE> {
            return NativeType(resource = resource, instance = null)
        }

        operator fun <INSTANCE> invoke(instance: INSTANCE): NativeType<INSTANCE> {
            return NativeType(resource = null, instance = instance)
        }
    }
}
