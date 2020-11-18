package non.shahad.common_ui

import android.graphics.Rect
import android.view.MotionEvent
import android.view.View

fun isTouchEventInBounds(view: View,event: MotionEvent): Boolean{
    val x = event.x
    val y = event.y

    val outRect = Rect()
    val location = IntArray(2)
    view.getDrawingRect(outRect)
    view.getLocationOnScreen(location)

    return outRect.contains(x.toInt(),y.toInt())
}