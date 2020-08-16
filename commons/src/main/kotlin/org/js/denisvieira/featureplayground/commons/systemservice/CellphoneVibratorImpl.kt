package org.js.denisvieira.featureplayground.commons.systemservice

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator

internal class CellphoneVibratorImpl : CellphoneVibrator {

    override fun vibrate(context: Context, vibrationTime: Long) {
        val vibratorService = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibratorService.vibrate(
                VibrationEffect.createOneShot(
                    vibrationTime,
                    VibrationEffect.DEFAULT_AMPLITUDE
                )
            )
        } else {
            vibratorService.vibrate(vibrationTime)
        }
    }
}
