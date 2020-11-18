package non.shahad.templatesforrle.adapter.template3c

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import non.shahad.templatesforrle.adapter.template3c.data.Message
import non.shahad.templatesforrle.adapter.template3c.data.MessageDiffCallback

class MessageAdapterDelegation: AsyncListDifferDelegationAdapter<Message>(MessageDiffCallback) {
    init {
        delegatesManager
            .addDelegate(IncomingMessageAdapter())
            .addDelegate(OutcomingMessageAdapter())
    }
}