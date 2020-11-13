package non.shahad.templatesforrle.callbacks.view

import android.view.View

interface OnWordSelectionListener {
    fun onReturn(view: View)
    fun onSelect(text: String,forNo: Int)
}