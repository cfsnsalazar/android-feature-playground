package com.odete.commons.nativetype

import android.content.Context
import android.graphics.drawable.Drawable

fun NativeType<String>.getNativeTypeString(context: Context): String =
    this.instance ?: context.resources.getString(this.resource!!)

fun NativeType<Drawable>.getNativeTypeDrawable(context: Context): Drawable =
    this.instance ?: androidx.core.content.ContextCompat.getDrawable(context, this.resource!!)!!
