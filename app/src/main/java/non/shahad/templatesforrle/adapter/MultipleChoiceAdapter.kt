package non.shahad.templatesforrle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import non.shahad.templatesforrle.databinding.ViewholderMultipleChoiceQuestionBinding
import non.shahad.templatesforrle.diffitem.MultipleChoiceDiffItemCallback
import non.shahad.templatesforrle.models.MultipleChoice

class MultipleChoiceAdapter(
        private val answers: List<MultipleChoice> = mutableListOf()
): RecyclerView.Adapter<MultipleChoiceAdapter.QuestionViewHolder>() {

    private val asyncListDiffer = AsyncListDiffer<MultipleChoice>(this,MultipleChoiceDiffItemCallback)

    inner class QuestionViewHolder(
            private val viewBinding: ViewholderMultipleChoiceQuestionBinding
    ): RecyclerView.ViewHolder(viewBinding.root){
        fun bind(choice: MultipleChoice){
            viewBinding.choice = choice
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        return QuestionViewHolder(ViewholderMultipleChoiceQuestionBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int){
        holder.bind(asyncListDiffer.currentList[position])
    }

    override fun getItemCount(): Int = asyncListDiffer.currentList.size
}