package osp.leobert.blog.code.b6

import android.util.Log
import osp.leobert.blog.code.A.Companion.getMode


open class View {

    companion object {
        const val layout_width = "layout_width"
        const val layout_height = "layout_height"
        var debug = true
    }

    var tag: Any? = null

    var parent: View? = null

    //    val layoutParams: MutableMap<String, Int> = mutableMapOf()
    var layoutParams: ViewGroup.LayoutParams? = null

    var measuredWidth: Int = WRAP_CONTENT

    var measuredHeight: Int = WRAP_CONTENT

    val heightMeasuredSize: Int
        get() = android.view.View.MeasureSpec.getSize(measuredHeight)

    val widthMeasuredSize: Int
        get() = android.view.View.MeasureSpec.getSize(measuredWidth)

    val heightMeasureMode: Int
        get() = android.view.View.MeasureSpec.getMode(measuredHeight)

    val widthMeasureMode: Int
        get() = android.view.View.MeasureSpec.getMode(measuredWidth)


    private var measured: Boolean = false

    fun isMeasured() = measured

    fun draw(canvas: Canvas) {

    }

    //绘制能力
    protected open fun onDraw(canvas: Canvas) {

    }

    protected open fun dispatchDraw(canvas: Canvas) {

    }

    fun measure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (!measured) {
            onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }

    //测量能力
    protected open fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimensionRaw(widthMeasureSpec, heightMeasureSpec)
        debugMeasureInfo()
    }


    open fun layout(l: Int, t: Int, r: Int, b: Int) {
        //todo
    }

    //布局能力
    protected open fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

    }

    protected fun debugMeasureInfo() {
        if (debug) {
            Log.d(
                "view-debug",
                "$tag has measured: $measured, w mode:${getMode(widthMeasureMode)}, w size: $widthMeasuredSize " +
                        "h mode:${getMode(heightMeasureMode)}, h size: $heightMeasuredSize "
            )
        }
    }

    protected fun setMeasuredDimension(measuredWidth: Int, measuredHeight: Int) {
        setMeasuredDimensionRaw(measuredWidth, measuredHeight)
    }

    private fun setMeasuredDimensionRaw(measuredWidth: Int, measuredHeight: Int) {
        this.measuredWidth = measuredWidth
        this.measuredHeight = measuredHeight
        measured = true
        if (debug) {
            Log.d(
                "view-debug",
                "$tag mark has measured: $measured"
            )
        }
    }


}