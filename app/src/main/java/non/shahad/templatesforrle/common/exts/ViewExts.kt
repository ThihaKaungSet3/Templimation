package non.shahad.templatesforrle.common.exts

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.Rect
import android.view.View
import timber.log.Timber

private const val SHRINK_VALUE = 1.5f

fun View.rect() = Rect(
        left,
        top,
        right,
        bottom
)

fun View.isOverlayTo(target: View): Boolean {
    val firstPosition = IntArray(2)
    val secondPosition = IntArray(2)

//    this.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED)
    getLocationOnScreen(firstPosition)
//    target.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED)
    target.getLocationOnScreen(secondPosition)

    Timber.d("${firstPosition[0]}, ${firstPosition[1]}")
    Timber.d("${secondPosition[0]}, ${secondPosition[1]}")

    val firstRect = Rect(
            firstPosition[0],
            firstPosition[1],
            firstPosition[0] + this.measuredWidth,
            firstPosition[1] + this.measuredHeight
    )
    val secondRect = Rect(
            secondPosition[0],
            secondPosition[1],
            secondPosition[0] + target.measuredWidth,
            secondPosition[1] + target.measuredHeight
    )

    Timber.d("FirstRect: $firstRect And SecondRect: $secondRect")

//    val right = measuredWidth + firstPosition[0]
//    val left = secondPosition[0]

//    return right >= left && (right != 0 && left != 0)
    return firstRect.intersect(secondRect)
}

fun View.shrinkAnimator(): Animator?{
    val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1f, SHRINK_VALUE)
    val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f, SHRINK_VALUE)
    this.apply {
        val animator = ObjectAnimator.ofPropertyValuesHolder(this, scaleX, scaleY)
        animator.duration = 100
        return animator
    }
    return null
}

fun View.growAnimator(): Animator?{
    val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, SHRINK_VALUE, 1f)
    val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, SHRINK_VALUE, 1f)
    this.apply {
        val animator = ObjectAnimator.ofPropertyValuesHolder(this, scaleX, scaleY)
        animator.duration = 100
        return animator
    }
    return null
}