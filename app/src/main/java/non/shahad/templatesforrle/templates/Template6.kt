package non.shahad.templatesforrle.templates

import android.graphics.Path
import android.os.Bundle
import non.shahad.templatesforrle.R
import non.shahad.templatesforrle.callbacks.view.OnLineDrawListener
import non.shahad.templatesforrle.common.base.BaseActivity
import non.shahad.templatesforrle.databinding.ActivityTemplate6Binding
import non.shahad.templatesforrle.models.Line
import timber.log.Timber

class Template6 : BaseActivity<ActivityTemplate6Binding>() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        viewBinding.view1.setOnLineDrawListener(object: OnLineDrawListener{
            override fun onLineDraw(line: Path) {

            }

        })
    }

    override val layoutRes: Int
        get() = R.layout.activity_template6
}