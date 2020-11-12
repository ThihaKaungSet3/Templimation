package non.shahad.templatesforrle.common.textview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class MatchAnswerTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    styleDef: Int = 0
): AppCompatTextView(context,attrs,styleDef){

    private var isAlreadySettle: Boolean = false

    fun setAlreadySettle(isSettle: Boolean){
        this.isAlreadySettle = isSettle
    }

    fun isAlreadySettle() = isAlreadySettle

}