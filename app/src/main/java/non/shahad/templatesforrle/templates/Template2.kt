package non.shahad.templatesforrle.templates

import android.os.Bundle
import android.os.PersistableBundle
import non.shahad.templatesforrle.R
import non.shahad.templatesforrle.common.base.BaseActivity
import non.shahad.templatesforrle.databinding.ActivityTemplate2Binding


class Template2 : BaseActivity<ActivityTemplate2Binding>() {

    override val layoutRes: Int
        get() = R.layout.activity_template2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.cardView.setOnClickListener {  }
    }

    private fun prepareAudio(){

    }
}