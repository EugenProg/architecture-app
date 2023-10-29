package kz.just_code.architectureapp

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

class SquareLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, def: Int = 0
): FrameLayout(context, attrs, def) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}