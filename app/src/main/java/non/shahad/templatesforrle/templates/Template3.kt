package non.shahad.templatesforrle.templates

import android.content.Intent
import android.os.Bundle
import non.shahad.templatesforrle.R
import non.shahad.templatesforrle.common.base.BaseActivity
import non.shahad.templatesforrle.databinding.ActivityTemplate3Binding
import non.shahad.templatesforrle.templates.template3.Template3a
import non.shahad.templatesforrle.templates.template3.Template3b
import non.shahad.templatesforrle.templates.template3.Template3c
import non.shahad.templatesforrle.templates.template3.Template3d

class Template3 : BaseActivity<ActivityTemplate3Binding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding.aBtn.setOnClickListener {
            switch(Template3a::class.java)
        }

        viewBinding.bBtn.setOnClickListener {
            switch(Template3b::class.java)
        }

        viewBinding.cBtn.setOnClickListener {
            switch(Template3c::class.java)
        }

        viewBinding.dBtn.setOnClickListener {
            switch(Template3d::class.java)
        }
    }

    private fun<T> switch(activityName: Class<T>){
        val intent = Intent(this,activityName)
        startActivity(intent)
    }

    override val layoutRes: Int
        get() = R.layout.activity_template3
}