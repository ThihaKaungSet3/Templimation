package non.shahad.buttons

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import non.shahad.common_ui.dpToPx

class ChoiceButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    styleDef: Int = 0
): AppCompatTextView(context,attrs,styleDef){

    private var isUsed = false

    private var selectedColor = Color.YELLOW
    private var unSelectedColor = Color.WHITE

    private var selectedTextColor = Color.WHITE
    private var unSelectedTextColor = Color.BLACK

    private var radius = context.dpToPx(8).toFloat()

    init {
        val a = context.obtainStyledAttributes(attrs!!,R.styleable.ChoiceButton)
        selectedColor = a.getColor(R.styleable.ChoiceButton_selectedColor,selectedColor)
        unSelectedColor = a.getColor(R.styleable.ChoiceButton_unSelectedColor,unSelectedColor)
        selectedTextColor = a.getColor(R.styleable.ChoiceButton_selectedTextColor,selectedTextColor)
        unSelectedTextColor = a.getColor(R.styleable.ChoiceButton_unSelectedTextColor,unSelectedTextColor)
        isUsed = a.getBoolean(R.styleable.ChoiceButton_isSelected,false)
        radius = a.getDimension(R.styleable.ChoiceButton_cornerRadius,radius)

        a.recycle()

        setOnClickListener {
            isUsed = !isUsed
            invalidate()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        setPadding(
            context.dpToPx(32),
            context.dpToPx(16),
            context.dpToPx(32),
            context.dpToPx(16)
        )
        if (isUsed){
            changeSelectedBackground()
        }else changeUnselectedBackground()
    }

    private fun changeSelectedBackground(){
        val gradientDrawable = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            setColor(selectedColor)
            setTextColor(selectedTextColor)
            cornerRadius = radius
        }
        background = gradientDrawable
    }

    private fun changeUnselectedBackground(){
        val gradientDrawable = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            setColor(unSelectedColor)
            setTextColor(unSelectedTextColor)
            cornerRadius = radius
        }
        background = gradientDrawable
    }

    fun setChecked(isChecked: Boolean){
        this.isUsed = isChecked
        invalidate()
    }
}