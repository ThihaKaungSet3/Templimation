package non.shahad.templatesforrle.common.exts

import android.content.Context
import android.util.DisplayMetrics

fun Context.dpToPx(dp: Int): Int {
    val scale = this.resources.displayMetrics.density
    return (dp * scale + 0.5f).toInt()
}

fun Context.pxToDp(px: Float): Float {
    val displayMetrics = this.resources.displayMetrics
    return (px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
}
