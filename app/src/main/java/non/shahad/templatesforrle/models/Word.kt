package non.shahad.templatesforrle.models

import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import non.shahad.templatesforrle.common.exts.growAnimator
import non.shahad.templatesforrle.common.exts.shrinkAnimator

data class Word(
    val originX: Float,
    val originY: Float,
    val text: String,
    val view: View,
)