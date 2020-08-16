package org.js.denisvieira.featureplayground.commons.systemservice

import android.content.Context

interface CellphoneVibrator {

    fun vibrate(activity: Context, vibrationTime: Long)
}
