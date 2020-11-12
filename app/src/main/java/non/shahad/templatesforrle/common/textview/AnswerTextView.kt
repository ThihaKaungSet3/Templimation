package non.shahad.templatesforrle.common.textview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatTextView

class AnswerTextView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        styleDef: Int = 0
): AppCompatTextView(context,attrs,styleDef){

    private var isAlreadyMoved_ = false
    val isAlreadyMoved get() = isAlreadyMoved_

    fun setIsAlreadyMoved(isAlreadyMoved: Boolean){
        this.isAlreadyMoved_ = isAlreadyMoved
    }

    init {
        setOnClickListener {
            if (isAlreadyMoved_){
                resetPosition()
            }
        }
    }

    fun moveToPositionAboveTo(target: View,duration: Long = 200){
            animate()
                .x(target.x)
                .y(target.y - 182)
                .setDuration(duration)
                .start()
        isAlreadyMoved_ = true
    }

    fun resetPosition(){
        animate()
                .translationX(0f)
                .translationY(0f)
                .setDuration(200)
                .start()
        isAlreadyMoved_ = false
    }


}