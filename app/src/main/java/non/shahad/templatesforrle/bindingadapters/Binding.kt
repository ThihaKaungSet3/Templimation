package non.shahad.templatesforrle.bindingadapters

import android.widget.TextView
import androidx.core.content.ContextCompat

import androidx.databinding.BindingAdapter
import non.shahad.templatesforrle.R
import non.shahad.templatesforrle.common.viewgroup.MultipleChoiceLayout

@BindingAdapter("considerIsSelectedOrNot")
fun considerIsSelectedOrNot(layout: MultipleChoiceLayout,isSelected: Boolean){
    if(isSelected){
        layout.setShapeBackground(R.color.primary_yellow)
    }else {
        layout.setShapeBackground(R.color.yellow_accent)
    }
}

@BindingAdapter("changeTextColorIfItsSelected")
fun changeTextColorIfItsSelected(textView: TextView,isSelected: Boolean){
    if(isSelected){
        textView.setTextColor(ContextCompat.getColor(textView.context,R.color.white))
    }else {
        textView.setTextColor(ContextCompat.getColor(textView.context,R.color.white))
    }
}