package non.shahad.templatesforrle.callbacks.view

import android.graphics.Path
import non.shahad.templatesforrle.models.Line

interface OnLineDrawListener {
    fun onLineDraw(line: Path)
}