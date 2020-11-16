package non.shahad.templatesforrle.diffitem

import androidx.recyclerview.widget.DiffUtil
import non.shahad.templatesforrle.models.MultipleChoice

object MultipleChoiceDiffItemCallback: DiffUtil.ItemCallback<MultipleChoice>() {

    override fun areItemsTheSame(oldItem: MultipleChoice, newItem: MultipleChoice): Boolean {
        return oldItem.answer == newItem.answer
    }

    override fun areContentsTheSame(oldItem: MultipleChoice, newItem: MultipleChoice): Boolean {
        return oldItem.isSelected == newItem.isSelected
    }

}