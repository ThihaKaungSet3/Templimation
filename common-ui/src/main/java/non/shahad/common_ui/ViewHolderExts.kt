package non.shahad.common_ui

import android.view.LayoutInflater
import android.view.ViewGroup

fun ViewGroup.layoutInflater(): LayoutInflater {
    return LayoutInflater.from(this.context)
}