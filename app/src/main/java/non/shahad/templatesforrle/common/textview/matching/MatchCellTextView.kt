package non.shahad.templatesforrle.common.textview.matching

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.google.android.flexbox.FlexboxLayout
import non.shahad.templatesforrle.R
import non.shahad.templatesforrle.callbacks.view.OnWordSelectionListener
import non.shahad.templatesforrle.common.exts.dpToPx

class MatchCellTextView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        styleDef: Int = 0
): AppCompatTextView(context,attrs,styleDef){

    var isChose = false
    private var originalText = ""

    private var guestView: View? = null
    private var onWordSelectionListener: OnWordSelectionListener? = null

    init {
        originalStyling()
        position()

        setOnClickListener {
            if (isChose){
                doOnUnselected()
                onWordSelectionListener?.onReturn(guestView!!)
                isChose = false
            }
        }
    }

    fun setOnUnselectedListener(onWordSelectionListener: OnWordSelectionListener){
        this.onWordSelectionListener = onWordSelectionListener
    }

    fun setMutationWhenOverlay(should: Boolean){
        if (should){
            setBackgroundColor(ContextCompat.getColor(context,R.color.primary_yellow))
        }
    }

    fun revertToOriginal(){
        if (!isChose){
            originalStyling()
            text = originalText
        }
    }

    fun doOnUnselected(){
        originalStyling()
        text = originalText
    }

    fun setOriginalText(origin: String){
        originalText = origin
        text = origin
    }

    fun setAsSelectedItem(text: String,view: View){
        val gradient = GradientDrawable()
        gradient.setColor(ContextCompat.getColor(context, R.color.primary_yellow))
        gradient.shape = GradientDrawable.RECTANGLE
        gradient.cornerRadius = 16f
        background = gradient
        setText(text)
        setTextColor(ContextCompat.getColor(context, R.color.black))

        onWordSelectionListener?.onSelect(text,originalText.toInt())
        guestView = view
        isChose = true
    }

    private fun originalStyling(){
        val gradient = GradientDrawable()
        gradient.setColor(ContextCompat.getColor(context, R.color.yellow_accent))
        gradient.shape = GradientDrawable.RECTANGLE
        gradient.cornerRadius = 16f
        background = gradient

        setTextColor(ContextCompat.getColor(context, R.color.black))
    }

    /**
     * Change to parent params if ViewGroup changes
     */
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




}