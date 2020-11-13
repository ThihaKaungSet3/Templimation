package non.shahad.templatesforrle.common.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayout

class MatchQAndALayout @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        styleDef: Int = 0
): FlexboxLayout(context,attrs,styleDef){

    init {
        flexDirection = FlexDirection.ROW
        flexWrap = FlexWrap.NOWRAP
    }

}