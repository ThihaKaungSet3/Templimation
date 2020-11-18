package non.shahad.templatesforrle.adapter.template3c

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import non.shahad.common_ui.layoutInflater
import non.shahad.templatesforrle.R
import non.shahad.templatesforrle.adapter.template3c.data.Message
import non.shahad.templatesforrle.databinding.ViewholderOutcomingMessageBinding

class OutcomingMessageAdapter: AdapterDelegate<List<Message>>() {

    override fun isForViewType(items: List<Message>, position: Int): Boolean {
        return !items[position].isIncoming
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return OutComingMessageViewHolder(DataBindingUtil.inflate(parent.layoutInflater(),R.layout.viewholder_outcoming_message,parent,false) as ViewholderOutcomingMessageBinding)
    }

    override fun onBindViewHolder(
        items: List<Message>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as OutComingMessageViewHolder).bind(items[position].message)
    }

    inner class OutComingMessageViewHolder(
        private val viewBinding: ViewholderOutcomingMessageBinding
    ): RecyclerView.ViewHolder(viewBinding.root){
        fun bind(message: String){
            viewBinding.message = message
        }
    }
}
