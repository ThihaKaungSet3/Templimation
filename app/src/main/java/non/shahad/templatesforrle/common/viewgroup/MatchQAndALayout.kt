package non.shahad.templatesforrle.common.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class MatchQAndALayout @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        styleDef: Int = 0
): LinearLayout(context,attrs,styleDef){

    init {
        orientation = VERTICAL
    }

}