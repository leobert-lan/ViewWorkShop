package osp.leobert.blog.code.b6

/**
 * <p><b>Package:</b> osp.leobert.blog.code.b6 </p>
 * <p><b>Project:</b> BlogCode </p>
 * <p><b>Classname:</b> ViewGroup </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2021/2/15.
 */

abstract class ViewGroup : View() {
    protected val children = arrayListOf<View>()

    abstract override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int)

    fun addView(view: View, layoutParams: LayoutParams = generateDefaultLayoutParams()) {
        if (view.parent != null) {
            throw IllegalArgumentException("view has a parent")
        }

        if (!checkLayoutParams(layoutParams)) {
            throw  IllegalArgumentException("layoutParams 不符合要求")
        }
        view.layoutParams = layoutParams

        children.add(view)
        view.parent = this
    }

    @Throws(IllegalStateException::class)
    abstract fun checkLayoutParams(layoutParams: LayoutParams): Boolean

    open fun generateDefaultLayoutParams(): LayoutParams {
        return MarginLayoutParams(MATCH_PARENT, MATCH_PARENT)
    }

    open class LayoutParams(var width: Int, var height: Int) {

    }

    open class MarginLayoutParams(width: Int, height: Int) : LayoutParams(width, height) {
        var leftMargin = 0

        var topMargin = 0

        var rightMargin = 0

        var bottomMargin = 0
    }
}