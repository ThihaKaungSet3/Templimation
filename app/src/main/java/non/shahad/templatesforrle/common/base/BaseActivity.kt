package non.shahad.templatesforrle.common.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB: ViewDataBinding>: AppCompatActivity() {

    abstract val layoutRes: Int

     val viewBinding: VB by lazy { DataBindingUtil.setContentView(this,layoutRes) }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

}