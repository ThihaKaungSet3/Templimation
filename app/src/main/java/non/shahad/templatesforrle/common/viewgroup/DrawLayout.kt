package non.shahad.templatesforrle.common.viewgroup

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import non.shahad.templatesforrle.models.Line
import timber.log.Timber

class DrawLayout @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        styleDef: Int = 0
): ConstraintLayout(context,attrs,styleDef){

    private val lines = mutableListOf<Path>()
    private var paint: Paint? = null

    init {
        paint = Paint().apply {
            strokeWidth = 8f
            color = Color.YELLOW
            isAntiAlias = true
        }
    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        Timber.d("draw")
        for (line in lines) {
            canvas?.drawPath(line,paint!!)
//            canvas?.drawLine(line.startX,line.startY,line.endX,line.endY,paint!!)
        }
    }

    fun addLine(line: Path){
        lines.add(line)
        invalidate()
    }


}