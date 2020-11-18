package non.shahad.templatesforrle.adapter.template3c

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import non.shahad.common_ui.layoutInflater
import non.shahad.templatesforrle.adapter.template3c.data.Message
import non.shahad.templatesforrle.databinding.ViewholderIncomingMessageBinding

class IncomingMessageAdapter: AdapterDelegate<List<Message>>() {

    override fun isForViewType(items: List<Message>, position: Int): Boolean {
        return items[position].isIncoming
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return IncomingMessageViewHolder(ViewholderIncomingMessageBinding.inflate(parent.layoutInflater()))
    }

    override fun onBindViewHolder(
        items: List<Message>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as IncomingMessageViewHolder).bind(items[position].message)
    }

    private inner class IncomingMessageViewHolder(
        private val viewBinding: ViewholderIncomingMessageBinding
    ): RecyclerView.ViewHolder(viewBinding.root){
        fun bind(message: String){
            viewBinding.message = message
        }
    }
}