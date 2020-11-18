package non.shahad.templatesforrle.adapter.template3c.data

import androidx.recyclerview.widget.DiffUtil

object MessageDiffCallback: DiffUtil.ItemCallback<Message>() {
    override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem.message == newItem.message
    }

    override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem.isIncoming == newItem.isIncoming
    }
}