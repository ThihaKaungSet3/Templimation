package non.shahad.templatesforrle.common.exts

import android.graphics.Rect
import android.view.View

fun View.rect() = Rect(
        left,
        top,
        right,
        bottom
)