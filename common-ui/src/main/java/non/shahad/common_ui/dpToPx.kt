package non.shahad.common_ui

import android.content.Context

fun Context.dpToPx(dp: Int): Int {
    val scale = this.resources.displayMetrics.density
    return (dp * scale + 0.5f).toInt()
}