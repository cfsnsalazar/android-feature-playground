package org.js.denisvieira.featureplayground.commons.bottomsheet

import android.app.Dialog
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BottomSheetBehaviorTest {

    val bottomSheetFragment = BottomSheetDialogFragment()

    @Test
    fun shouldSetOnShowListener() {
        val dialog = mock<Dialog>()
        bottomSheetFragment.setBottomSheetState(dialog)

        verify(dialog).setOnShowListener(any())
    }
}
