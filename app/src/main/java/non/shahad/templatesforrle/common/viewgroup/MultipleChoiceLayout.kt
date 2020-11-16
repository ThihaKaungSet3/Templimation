package non.shahad.templatesforrle.common.viewgroup

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import non.shahad.templatesforrle.R
import non.shahad.templatesforrle.common.exts.dpToPx

class MultipleChoiceLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    styleDef: Int = 0
): ConstraintLayout(context,attrs,styleDef){


    init {
        // Default
        setShapeBackground(R.color.yellow_accent)
    }

    fun setShapeBackground(color: Int){
        background = GradientDrawable().apply {
            setColor(ContextCompat.getColor(context,color))
            shape = GradientDrawable.RECTANGLE
            cornerRadius = context.dpToPx(16).toFloat()
        }
    }

}