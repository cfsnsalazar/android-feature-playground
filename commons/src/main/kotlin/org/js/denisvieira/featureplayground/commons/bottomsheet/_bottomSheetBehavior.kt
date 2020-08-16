package org.js.denisvieira.featureplayground.commons.bottomsheet

import android.app.Dialog
import android.view.View
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Update how the BottomSheet will be displayed
 *
 * STATE_EXPANDED  is a full display of the dialog
 */
fun BottomSheetDialogFragment.setBottomSheetState(
    dialog: Dialog,
    state: Int = BottomSheetBehavior.STATE_EXPANDED
): Dialog =
    dialog.also {
        it.setOnShowListener {
            val bottomSheetDesign = getBottomSheetDesign(dialog)

            BottomSheetBehavior.from(bottomSheetDesign).state = state
        }
    }

private fun getBottomSheetDesign(dialog: Dialog) =
    dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
