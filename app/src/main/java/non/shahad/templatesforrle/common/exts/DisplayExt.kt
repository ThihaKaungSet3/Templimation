package non.shahad.templatesforrle.common.exts

import android.content.Context
import android.util.DisplayMetrics

fun Context.dpToPx(dp: Float): Float {
    val displayMetrics = this.resources.displayMetrics
    return (dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
}

fun Context.pxToDp(px: Float): Float {
    val displayMetrics = this.resources.displayMetrics
    return (px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
}
