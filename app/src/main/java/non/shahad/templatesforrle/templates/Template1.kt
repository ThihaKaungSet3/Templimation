package non.shahad.templatesforrle.templates

import android.os.Bundle
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.children
import non.shahad.templatesforrle.R
import non.shahad.templatesforrle.common.base.BaseActivity
import non.shahad.templatesforrle.common.textview.MatchAnswerTextView
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
        Timber.d("$viewBinding")
    }







}