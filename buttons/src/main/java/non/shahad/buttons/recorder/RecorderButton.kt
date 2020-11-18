package non.shahad.buttons.recorder

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.ScaleAnimation
import android.widget.RelativeLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import non.shahad.buttons.R
import non.shahad.buttons.recorder.utils.MediaRecorderUtil


class RecorderButton @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        styleDef: Int = 0
): FloatingActionButton(context,attrs,styleDef) {

    private val DEFAULT_DURATION = 2000
    private val recorder = MediaRecorderUtil(context)

    private var onRecordListener: RecordListener? = null

    init {
        val a = context.obtainStyledAttributes(attrs,R.styleable.RecorderButton)
        a.recycle()

        listenTouchEvent()
    }

    private fun listenTouchEvent(){
        setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    onRecordListener?.onStartRecording()
                    Log.d("RecorderButton", "Start recording")
                    return@setOnTouchListener true
                }

                MotionEvent.ACTION_MOVE -> {
                    onRecordListener?.onStopRecording()
                    Log.d("RecorderButton", "Release Recording")
                    return@setOnTouchListener true
                }

                MotionEvent.ACTION_UP -> {
                    Log.d("RecorderButton", "Finish Recording")
                    return@setOnTouchListener true
                }
            }
            return@setOnTouchListener false
        }
    }

    fun setOnRecordListener(onRecordListener: RecordListener) {
        this.onRecordListener = onRecordListener
    }


}