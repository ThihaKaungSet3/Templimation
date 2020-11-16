package non.shahad.templatesforrle.common.textview.point

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import non.shahad.templatesforrle.callbacks.view.OnLineDrawListener
import non.shahad.templatesforrle.common.viewgroup.DrawLayout
import non.shahad.templatesforrle.models.Line
import timber.log.Timber
import kotlin.math.abs

class PointDrawerView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        styleDef: Int = 0
): AppCompatTextView(context,attrs,styleDef){

    var startX = 0f
    var startY = 0f

    private var mPath: Path? = null
    private var onLineDrawListener: OnLineDrawListener? = null

    init {
        mPath = Path()
        setOnTouch()
    }

    private fun onTouchStart(x: Float,y: Float){
        mPath?.reset()
        mPath?.moveTo(x,y)
        startX = x
        startY = y
    }

    private fun onTouchMove(x: Float,y: Float){
        val dX = abs(x - startX)
        val dY = abs(y - startY)
        if (dX >= 4 || dY <= 4){
            startX = x
            startY = y
        }
    }

    private fun onTouchUp(){
        mPath?.lineTo(startX,startY)
        onLineDrawListener?.onLineDraw(mPath!!)
        mPath?.reset()
    }

    fun setOnLineDrawListener(onLineDraw: OnLineDrawListener){
        this.onLineDrawListener = onLineDraw
    }

    private fun setOnTouch(){
        setOnTouchListener { v, event ->
            when(event.action){
                MotionEvent.ACTION_DOWN -> {
                    onTouchStart(event.x,event.y)
                    return@setOnTouchListener  true
                }

                MotionEvent.ACTION_MOVE -> {
                    onTouchMove(event.x,event.y)
                }

                MotionEvent.ACTION_UP -> {
                    onTouchUp()
                    return@setOnTouchListener true
                }
            }
            return@setOnTouchListener false
        }
    }
}