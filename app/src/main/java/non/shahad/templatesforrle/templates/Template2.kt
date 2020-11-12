package non.shahad.templatesforrle.templates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import non.shahad.templatesforrle.R
import non.shahad.templatesforrle.common.base.BaseActivity
import non.shahad.templatesforrle.common.exts.rect
import non.shahad.templatesforrle.databinding.ActivityTemplate2Binding
import timber.log.Timber

class Template2 : BaseActivity<ActivityTemplate2Binding>() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.player.setOnTouchListener(onTouchListener)
    }

    // Work answer 1
    private val onTouchListener = View.OnTouchListener { v, event ->

        // If you programmatically add Custom Views to view group
        // Create new LayoutParams
        val params = v.layoutParams as FrameLayout.LayoutParams

        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                v.layoutParams = params
                return@OnTouchListener true
            }

            MotionEvent.ACTION_UP -> {
                params.topMargin = (event.rawY - v.height).toInt()
                params.leftMargin = (event.rawX - v.width / 2).toInt()
                v.layoutParams = params
                if (v.isOverlayTo(viewBinding.target)) {
                    Toast.makeText(applicationContext, "Overlayed", Toast.LENGTH_SHORT).show()
                }
                return@OnTouchListener true
            }

            MotionEvent.ACTION_MOVE -> {
                params.topMargin = (event.rawY - v.height).toInt()
                params.leftMargin = (event.rawX - v.width / 2).toInt()
                v.layoutParams = params
                return@OnTouchListener true
            }
        }
        return@OnTouchListener false
    }

//    Work answer 2 (not yet!)
    private val onSmoothTouchListener = View.OnTouchListener { v, event ->
        var previousY = 0
        var previousX = 0

        // If you programmatically add Custom Views to view group
        // Create new LayoutParams
        val params = v.layoutParams as FrameLayout.LayoutParams

        when(event.action){
            MotionEvent.ACTION_DOWN -> {

                return@OnTouchListener true
            }

            MotionEvent.ACTION_UP -> {
                return@OnTouchListener true
            }

            MotionEvent.ACTION_MOVE -> {
                return@OnTouchListener true
            }
        }
        return@OnTouchListener false
    }

    private fun View.isOverlayTo(target: View): Boolean {
        return this.rect().intersect(target.rect())
    }


    override val layoutRes: Int
        get() = R.layout.activity_template2
}