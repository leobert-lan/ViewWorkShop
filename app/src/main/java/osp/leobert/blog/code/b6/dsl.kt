package osp.leobert.blog.code.b6

/**
 * <p><b>Package:</b> osp.leobert.blog.code.b6 </p>
 * <p><b>Project:</b> BlogCode </p>
 * <p><b>Classname:</b> dsl </p>
 * Created by leobert on 2021/2/18.
 */

typealias Decor<T> = (v: T) -> Unit

val MATCH_PARENT: Int = android.view.ViewGroup.LayoutParams.MATCH_PARENT
val WRAP_CONTENT = android.view.ViewGroup.LayoutParams.WRAP_CONTENT

var View.layoutWidth: Int
    get() {
//        return layoutParams[View.layout_width] ?: WRAP_CONTENT
        return layoutParams!!.width
    }
    set(value) {
//        layoutParams[View.layout_width] = value
        layoutParams!!.width = value
    }

var View.layoutHeight: Int
    get() {
//        return layoutParams[View.layout_height] ?: WRAP_CONTENT
        return layoutParams!!.height
    }
    set(value) {
//        layoutParams[View.layout_height] = value
        layoutParams!!.height = value
    }


fun root(): FrameLayout = FrameLayout().apply {
    this.layoutParams = ViewGroup.MarginLayoutParams(1080,1920)
//    this.layoutWidth = 1080
//    this.layoutHeight = 1920
}

inline fun ViewGroup?.frameLayout(decor: Decor<FrameLayout>): ViewGroup {
    val child = FrameLayout()
    child.layoutParams = this?.generateDefaultLayoutParams()?:ViewGroup.MarginLayoutParams(WRAP_CONTENT,
        WRAP_CONTENT)
    child.let(decor)
    return this?.apply { addView(child) } ?: child
}

inline fun ViewGroup.view(decor: Decor<View>): ViewGroup {
    val child = View()
    child.layoutParams = this.generateDefaultLayoutParams()
    child.let(decor)
    return this.apply { addView(child) }
}