package non.shahad.templatesforrle.common.textview.matching

import android.content.ClipData
import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.google.android.flexbox.FlexboxLayout
import non.shahad.templatesforrle.R
import non.shahad.templatesforrle.common.exts.dpToPx
import timber.log.Timber

class MatchWordTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    styleDef: Int = 0
): AppCompatTextView(context,attrs,styleDef){

    private var originX = 0f
    private var originY = 0f

    init {
        position()
        onTouchListener()
        Timber.d("Width: $width and Height: $height")
    }

    private fun backgroundAndStyling(){
        val gradient = GradientDrawable()
        gradient.setColor(ContextCompat.getColor(context, R.color.primary_yellow))
        gradient.shape = GradientDrawable.RECTANGLE
        gradient.cornerRadius = 16f
        background = gradient
        setTextColor(ContextCompat.getColor(context,R.color.black))
    }

    private fun position(){
        setPadding(48,32,48,32)
        val params = FlexboxLayout.LayoutParams(
                context.dpToPx(112),
                context.dpToPx(56)
        )
        gravity = Gravity.CENTER
        params.setMargins(context.dpToPx(16), context.dpToPx(16), context.dpToPx(16), context.dpToPx(16))
        layoutParams = params
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        backgroundAndStyling()
        position()

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        originX = x
        originY = y
    }

    private fun onTouchListener(){
        setOnTouchListener { v, event ->
            when(event.actionMasked){
                MotionEvent.ACTION_DOWN -> {
                    val data = ClipData.newPlainText("","")
                    val shadowBuilder = DragShadowBuilder(v)
                    v.startDrag(data,shadowBuilder,v,0)

                    return@setOnTouchListener true
                }

            }
            return@setOnTouchListener false
        }
    }

    fun resetPosition(){
        animate().x(originX).y(originY)
    }


}