package non.shahad.templatesforrle.callbacks.draganddrop

import android.view.View

interface OnWordDragListener {
    fun onDragging()
    fun onDragStarted()
    fun onDragReleased(v: View)
    fun onSettle()
}