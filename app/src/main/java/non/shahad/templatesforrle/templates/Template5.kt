package non.shahad.templatesforrle.templates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.animation.TranslateAnimation
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.google.android.flexbox.FlexboxLayout
import non.shahad.templatesforrle.R
import non.shahad.templatesforrle.common.exts.pxToDp
import non.shahad.templatesforrle.common.textview.AnswerTextView
import non.shahad.templatesforrle.databinding.ActivityTemplate1Binding
import non.shahad.templatesforrle.databinding.ActivityTemplate5Binding
import non.shahad.templatesforrle.models.Answer
import non.shahad.templatesforrle.models.RemoveAnswerListener

class Template5 : AppCompatActivity(),RemoveAnswerListener {
    lateinit var viewBinding: ActivityTemplate5Binding

    private var isMoved = false

    private val questions = listOf<String>(
            "are",
            "How",
            "you",
            "old?"
    )

    private val selectedAnswers = mutableListOf<Answer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding  = DataBindingUtil.setContentView(this,R.layout.activity_template5)
        setUpInitialState()

//        viewBinding.textToMove.setOnClickListener {
//            if (viewBinding.textToMove.isAlreadyMoved){
//                viewBinding.textToMove.resetPosition()
//            }else {
//                viewBinding.textToMove.moveToPositionAboveTo(viewBinding.lineFirst)
//            }
//
//        }

    }

    private fun setUpInitialState(){
        questions.forEach {
            val question = createAnswerTextView(it)
            viewBinding.answerContainer.addView(question)
        }
    }

    private fun createAnswerTextView(txt: String) = AnswerTextView(this).apply {
        setPadding(30,15,30,30)
        setBackgroundColor(ContextCompat.getColor(context,R.color.yellow_accent))
        val params = FlexboxLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(30, 30, 30, 30)
        layoutParams = params
        text = txt

        setOnClickListener { moveToAnswer(it) }
    }

    private fun moveToAnswer(view: View){
        var originX = viewBinding.lineFirst.x
        val originY = viewBinding.lineFirst.y - 120F

        // We need to stop listening click event as we don't want any animation except from onRemove listener
        view.setOnClickListener(null)

        selectedAnswers.add(
             Answer(view,view.x,view.y,(view as AnswerTextView).text.toString(),this)
        )

        if (selectedAnswers.size > 1){
            // get total width of all Views to get start point
            var totalWidthOfViews = 0F

            selectedAnswers.forEach {
                totalWidthOfViews += (it.view)?.width!! + 10F
            }

            // And then decrease width of current view as we already counted it
            totalWidthOfViews -= view.width

            // count from start
            originX = totalWidthOfViews + viewBinding.lineFirst.x

        }

        view.animate()
                .x(originX)
                .y(originY)
                .start()
    }

    override fun onRemove(answer: Answer) {
        // Remove from list first
        selectedAnswers.remove(answer)

        // Recount the total width to shrink
        var totalWidthOfViews = 0f

        selectedAnswers.forEach {
            totalWidthOfViews += it.view?.width!! + 10f

            if (it == selectedAnswers.first()){
                it.view!!.animate().x(0f)
            }else {
                // remove one place of width
                totalWidthOfViews -= it.view?.width!!
                it.view?.animate()
                        ?.x(totalWidthOfViews)
            }

        }

        // Reattach onClickListener
        answer.view?.setOnClickListener {
            moveToAnswer(it)
        }

    }


//    private fun move(){
//
//        val XofViewToMove = viewBinding.view.x
//        val XofViewToBeMove = viewBinding.textToMove.x
//        val xOffset = XofViewToMove - XofViewToBeMove
//
//        val YofViewToMove = viewBinding.view.y
//        val YofViewToBeMove = viewBinding.textToMove.y
//        val yOffset = (YofViewToMove - YofViewToBeMove) - 182
//
//        val animation = TranslateAnimation(0f,xOffset,0f,yOffset).apply {
//            repeatMode = 0
//            duration = 300
//            fillAfter = true
//        }
//
//        viewBinding.textToMove.startAnimation(animation)
//    }
}