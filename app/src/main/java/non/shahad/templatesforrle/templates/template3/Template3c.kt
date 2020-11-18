package non.shahad.templatesforrle.templates.template3

import android.os.Bundle
import non.shahad.templatesforrle.R
import non.shahad.templatesforrle.adapter.template3c.MessageAdapterDelegation
import non.shahad.templatesforrle.adapter.template3c.data.Message
import non.shahad.templatesforrle.common.base.BaseActivity
import non.shahad.templatesforrle.databinding.ActivityTemplate3cBinding
import timber.log.Timber

class Template3c : BaseActivity<ActivityTemplate3cBinding>() {

    private val message = mutableListOf<Message>(
        Message("Hello, I am Iron Man. What is your name?",true)
    )

    private val answers = listOf<String>(
        "Hello, I am Iron Man. What is your name?",
        "Advancing AI for everyone",
        "Our research groups are advancing",
        "We’re fostering a collaborative ecosystem"
    )

    private val delegate = MessageAdapterDelegation()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createRecyclerView()
        delegate.items = message

        answers.forEach {
            viewBinding.answerContainer.addAnswerViews(it){ choseAnswer ->
                Timber.d("$choseAnswer")
                val current = delegate.items.toMutableList()
                current.add(Message(choseAnswer,false))
                delegate.items.toMutableList().clear()
                delegate.items = current
            }
        }

    }

    private fun createRecyclerView(){
        viewBinding.chatRV.apply {
            adapter = delegate
            setHasFixedSize(false)
        }
    }

    override val layoutRes: Int
        get() = R.layout.activity_template3c
}