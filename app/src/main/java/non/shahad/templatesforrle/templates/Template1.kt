package non.shahad.templatesforrle.templates

import android.os.Bundle
import android.view.*
import android.view.animation.Animation
import non.shahad.templatesforrle.R
import non.shahad.templatesforrle.callbacks.view.OnWordSelectionListener
import non.shahad.templatesforrle.common.base.BaseActivity
import non.shahad.templatesforrle.common.exts.toast
import non.shahad.templatesforrle.common.textview.matching.MatchCellTextView
import non.shahad.templatesforrle.common.textview.matching.MatchWordTextView
import non.shahad.templatesforrle.databinding.ActivityTemplate1Binding
import non.shahad.templatesforrle.models.Word
import timber.log.Timber

class Template1 : BaseActivity<ActivityTemplate1Binding>() {

    override val layoutRes: Int
        get() = R.layout.activity_template1

    private val randomWords = listOf<String>(
            "Cover",
            "Letter",
            "Word"
    )

    private val words = mutableListOf<Word>()
    private val cells = mutableListOf<Word>()


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        craftWords()

    }

    private fun craftWords(){
        randomWords.forEachIndexed { index, s ->
            val word = createWordTextView(s)
            val cell = createAnswerTextView((index + 1).toString()).apply {
                setOnDragListener(fakeOnDragListener)
                setOnUnselectedListener(object: OnWordSelectionListener {

                    override fun onReturn(view: View) {
                        view.visibility = View.VISIBLE
                    }

                    override fun onSelect(text: String, forNo: Int) {
                        Timber.d("$text for $forNo")
                    }

                })
            }

            viewBinding.answerContainer.addView(cell)
            viewBinding.randomWordsContainer.addView(word)

        }
    }

    private fun createWordTextView(txt: String) = MatchWordTextView(this).apply {
        text = txt
    }

    private val fakeOnDragListener = object: View.OnDragListener {
        override fun onDrag(v: View?, event: DragEvent?): Boolean {
            when(event?.action){

                DragEvent.ACTION_DRAG_ENTERED -> {
                    (v as MatchCellTextView).setMutationWhenOverlay(true)
                    toast("Drag entered")
                    return false
                }

                DragEvent.ACTION_DROP -> {
                    val snapShot = event.localState as View
                    val movingView = snapShot as MatchWordTextView
                    val target = v as MatchCellTextView
                    movingView.visibility = View.GONE
                    target.setAsSelectedItem(movingView.text.toString(),movingView)
                    return false
                }

                DragEvent.ACTION_DRAG_EXITED -> {
                    (v as MatchCellTextView).revertToOriginal()
                }
            }
            return true
        }

    }

    private fun createAnswerTextView(txt: String) = MatchCellTextView(this).apply {
        setOriginalText(txt)
    }







}