package osp.leobert.blog.code.b6

import android.view.View
import androidx.annotation.VisibleForTesting

/**
 * <p><b>Package:</b> osp.leobert.blog.code.b6 </p>
 * <p><b>Project:</b> BlogCode </p>
 * <p><b>Classname:</b> FrameLayout </p>
 * Created by leobert on 2021/2/18.
 */
class FrameLayout : ViewGroup() {
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //handle horizon
        val widthMode = View.MeasureSpec.getMode(widthMeasureSpec)
        var widthSize = View.MeasureSpec.getSize(widthMeasureSpec)

        var wMeasured = false
        var hMeasured = false
        when (widthMode) {
            View.MeasureSpec.EXACTLY -> {
                // widthSize 即为Parent 为此决定的准确值，直接采用
                wMeasured = true
            }
            View.MeasureSpec.AT_MOST -> {
                // 需要再次测量，但可以保存该信息了
                measuredWidth = widthMeasureSpec
            }
            else -> {
                throw IllegalStateException("暂不支持测量模式：$widthMode")
            }
        }

        //同理处理 vertical方向

        val heightMode = View.MeasureSpec.getMode(heightMeasureSpec)
        var heightSize = View.MeasureSpec.getSize(heightMeasureSpec)

        when (heightMode) {
            View.MeasureSpec.EXACTLY -> {
                hMeasured = true
            }
            View.MeasureSpec.AT_MOST -> {
                measuredHeight = heightMeasureSpec
            }
            else -> {
                throw IllegalStateException("暂不支持测量模式：$widthMode")
            }
        }

        if (hMeasured && wMeasured) {
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
        }

        children.forEach {
//            Log.e("view-debug", "$tag ,for child, $widthMode, $widthSize, ${it.layoutWidth}")
            val childWidthMeasureSpec = makeMeasureSpec(widthMode, widthSize, it.layoutWidth)
            val childHeightMeasureSpec = makeMeasureSpec(heightMode, heightSize, it.layoutHeight)
            it.measure(childWidthMeasureSpec, childHeightMeasureSpec)
        }


        if (!hMeasured || !wMeasured) {
            var w = 0
            var h = 0
            children.forEach {
                if (!wMeasured)
                    w = maxOf(w, it.widthMeasuredSize)

                if (!hMeasured)
                    h = maxOf(h, it.heightMeasuredSize)
            }

            if (wMeasured)
                w = widthSize

            if (hMeasured)
                h = heightSize

            setMeasuredDimension(
                View.MeasureSpec.makeMeasureSpec(w, widthMode),
                View.MeasureSpec.makeMeasureSpec(h, heightMode),
            )
        }
        if (!allChildHasMeasured())
            throw IllegalStateException("child 未全部完成测量")

        debugMeasureInfo()
    }

    private fun makeMeasureSpec(mode: Int, size: Int, childSize: Int): Int {
        // 参考Android中FrameLayout的布局规则，它对于Child要求的大小为：
        // 子View 可以 要求 比自身大 的展示大小，但是超过自身显示范围的不予显示。
        // 所以，不 按照自身情况 调整 子View的 size
        val childMode = when (childSize) {
            WRAP_CONTENT -> View.MeasureSpec.AT_MOST
            else -> View.MeasureSpec.EXACTLY
        }


        val childSize2 = when (childSize) {
            WRAP_CONTENT -> size
            MATCH_PARENT -> size
            else -> childSize
        }
        return View.MeasureSpec.makeMeasureSpec(childSize2, childMode)
    }

    @VisibleForTesting
    fun allChildHasMeasured(): Boolean {
        val i = children.iterator()
        while (i.hasNext()) {
            if (!i.next().isMeasured())
                return false
        }

        return true
    }

}