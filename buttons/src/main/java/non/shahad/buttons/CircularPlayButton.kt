package non.shahad.buttons

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Icon
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CircularPlayButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    styleDef: Int = 0
): FloatingActionButton(context,attrs,styleDef){

    private var isPlaying = false

    private var circlePaint: Paint? = null
    private var bgColor = Color.YELLOW

    init {
        circlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.FILL
        }

        val a = context.obtainStyledAttributes(attrs!!,R.styleable.CircularPlayButton)
        bgColor = a.getColor(R.styleable.CircularPlayButton_circleColor,Color.YELLOW)
        backgroundTintList = ColorStateList.valueOf(bgColor)

        a.recycle()
    }


    fun setOnPlayPauseListener(onPlayPauseListener: OnPlayPauseListener){
        setOnClickListener {
            isPlaying = !isPlaying
            onPlayPauseListener.onPlayPause(isPlaying)
            invalidate()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        considerImage()
    }


    private fun considerImage(){
        if (isPlaying){
            setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_pause_24))
        }else {
            setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_play_arrow_24))
        }
    }

    fun setPlaying(isPlaying: Boolean){
        this.isPlaying = isPlaying
        invalidate()
    }

    fun isPlaying() = this.isPlaying
}