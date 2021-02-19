package osp.leobert.blog.code

/**
 * <p><b>Package:</b> osp.leobert.blog.code </p>
 * <p><b>Project:</b> BlogCode </p>
 * <p><b>Classname:</b> Mode </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2021/2/16.
 */
enum class Mode(val v: Int) {

    /**
     * Measure specification mode: The parent has not imposed any constraint
     * on the child. It can be whatever size it wants.
     */
    UNSPECIFIED(0 shl 30),

    /**
     * Measure specification mode: The parent has determined an exact size
     * for the child. The child is going to be given those bounds regardless
     * of how big it wants to be.
     */
    EXACTLY(1 shl 30),

    /**
     * Measure specification mode: The child can be as large as it wants up
     * to the specified size.
     */
    AT_MOST(2 shl 30)
}

class A {
    companion object {
        fun getMode(v: Int): Mode {
            Mode.values().forEach {
                if (it.v == v)
                    return it
            }
            throw IllegalStateException()
        }
    }
}