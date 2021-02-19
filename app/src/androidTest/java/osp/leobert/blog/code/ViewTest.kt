package osp.leobert.blog.code

import android.util.Log
import android.view.View
import org.junit.Assert.assertEquals
import org.junit.Test
import osp.leobert.blog.code.b6.*

/**
 * <p><b>Package:</b> osp.leobert.blog.code </p>
 * <p><b>Project:</b> BlogCode </p>
 * <p><b>Classname:</b> ViewTest </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2021/2/18.
 */
class ViewTest {

    @Test
    fun testMeasure() {

        val tree = root().frameLayout { v1 ->

            v1.tag = "v1"
            v1.layoutWidth = MATCH_PARENT
            v1.layoutHeight = WRAP_CONTENT

            v1.frameLayout { frameLayout ->
                frameLayout.tag = "v2"
                frameLayout.layoutWidth = MATCH_PARENT
                frameLayout.layoutHeight = WRAP_CONTENT

                frameLayout.view {
                    it.tag = "v3"
                    it.layoutWidth = 200
                    it.layoutHeight = 300
                }

                frameLayout.frameLayout {
                    it.tag = "v4"
                    it.layoutWidth = WRAP_CONTENT
                    it.layoutHeight = WRAP_CONTENT
                }
            }
        }

        tree.tag = "root"


        tree.measure(
            View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(1920, View.MeasureSpec.EXACTLY)
        )
        assert(tree is FrameLayout)
        assertEquals(true, (tree as FrameLayout).allChildHasMeasured())
    }

    @Test
    fun testMeasure1() {

        //match wrap
        Log.d("view-test", "match wrap")

        val tree = root().frameLayout { v1 ->
            v1.tag = "v1"
            v1.layoutWidth = MATCH_PARENT
            v1.layoutHeight = WRAP_CONTENT

            v1.frameLayout { frameLayout ->
                frameLayout.tag = "v2"
                frameLayout.layoutWidth = WRAP_CONTENT
                frameLayout.layoutHeight = WRAP_CONTENT

                frameLayout.view {
                    it.tag = "v3"
                    it.layoutWidth = 200
                    it.layoutHeight = 300
                }
            }
        }

        tree.tag = "root"

        tree.measure(
            View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(1920, View.MeasureSpec.EXACTLY)
        )
        assert(tree is FrameLayout)
        assertEquals(true, (tree as FrameLayout).allChildHasMeasured())
    }

    @Test
    fun testMeasure2() {
        Log.d("view-test", "match match")

        val tree = root().frameLayout { v1 ->
            v1.tag = "v1"
            v1.layoutWidth = MATCH_PARENT
            v1.layoutHeight = WRAP_CONTENT

            v1.frameLayout { frameLayout ->
                frameLayout.tag = "v2"
                frameLayout.layoutWidth = MATCH_PARENT
                frameLayout.layoutHeight = WRAP_CONTENT

                frameLayout.view {
                    it.tag = "v3"
                    it.layoutWidth = 200
                    it.layoutHeight = 300
                }
            }
        }

        tree.tag = "root"

        tree.measure(
            View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(1920, View.MeasureSpec.EXACTLY)
        )
        assert(tree is FrameLayout)
        assertEquals(true, (tree as FrameLayout).allChildHasMeasured())
    }

    @Test
    fun testMeasure3() {
        Log.d("view-test", "match 400")

        val tree = root().frameLayout { v1 ->
            v1.tag = "v1"
            v1.layoutWidth = MATCH_PARENT
            v1.layoutHeight = WRAP_CONTENT

            v1.frameLayout { frameLayout ->
                frameLayout.tag = "v2"
                frameLayout.layoutWidth = 400
                frameLayout.layoutHeight = WRAP_CONTENT

                frameLayout.view {
                    it.tag = "v3"
                    it.layoutWidth = 200
                    it.layoutHeight = 300
                }
            }
        }

        tree.tag = "root"

        tree.measure(
            View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(1920, View.MeasureSpec.EXACTLY)
        )
        assert(tree is FrameLayout)
        assertEquals(true, (tree as FrameLayout).allChildHasMeasured())
    }

    @Test
    fun testMeasure4() {
        Log.d("view-test", "400 match")

        val tree = root().frameLayout { v1 ->
            v1.tag = "v1"
            v1.layoutWidth = 400
            v1.layoutHeight = WRAP_CONTENT

            v1.frameLayout { frameLayout ->
                frameLayout.tag = "v2"
                frameLayout.layoutWidth = MATCH_PARENT
                frameLayout.layoutHeight = WRAP_CONTENT

                frameLayout.view {
                    it.tag = "v3"
                    it.layoutWidth = 200
                    it.layoutHeight = 300
                }
            }
        }

        tree.tag = "root"

        tree.measure(
            View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(1920, View.MeasureSpec.EXACTLY)
        )
        assert(tree is FrameLayout)
        assertEquals(true, (tree as FrameLayout).allChildHasMeasured())
    }

    @Test
    fun testMeasure5() {
        Log.d("view-test", "400 wrap")

        val tree = root().frameLayout { v1 ->
            v1.tag = "v1"
            v1.layoutWidth = 400
            v1.layoutHeight = WRAP_CONTENT

            v1.frameLayout { frameLayout ->
                frameLayout.tag = "v2"
                frameLayout.layoutWidth = WRAP_CONTENT
                frameLayout.layoutHeight = WRAP_CONTENT

                frameLayout.view {
                    it.tag = "v3"
                    it.layoutWidth = 200
                    it.layoutHeight = 300
                }
            }
        }

        tree.tag = "root"

        tree.measure(
            View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(1920, View.MeasureSpec.EXACTLY)
        )
        assert(tree is FrameLayout)
        assertEquals(true, (tree as FrameLayout).allChildHasMeasured())
    }

    @Test
    fun testMeasure6() {
        Log.d("view-test", "400 400")

        val tree = root().frameLayout { v1 ->
            v1.tag = "v1"
            v1.layoutWidth = 400
            v1.layoutHeight = WRAP_CONTENT

            v1.frameLayout { frameLayout ->
                frameLayout.tag = "v2"
                frameLayout.layoutWidth = 400
                frameLayout.layoutHeight = WRAP_CONTENT

                frameLayout.view {
                    it.tag = "v3"
                    it.layoutWidth = 200
                    it.layoutHeight = 300
                }
            }
        }

        tree.tag = "root"

        tree.measure(
            View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(1920, View.MeasureSpec.EXACTLY)
        )
        assert(tree is FrameLayout)
        assertEquals(true, (tree as FrameLayout).allChildHasMeasured())
    }

    @Test
    fun testMeasure7() {
        Log.d("view-test", "wrap match")

        val tree = root().frameLayout { v1 ->
            v1.tag = "v1"
            v1.layoutWidth = WRAP_CONTENT
            v1.layoutHeight = WRAP_CONTENT

            v1.frameLayout { frameLayout ->
                frameLayout.tag = "v2"
                frameLayout.layoutWidth = MATCH_PARENT
                frameLayout.layoutHeight = WRAP_CONTENT

                frameLayout.view {
                    it.tag = "v3"
                    it.layoutWidth = 200
                    it.layoutHeight = 300
                }
            }
        }

        tree.tag = "root"

        tree.measure(
            View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(1920, View.MeasureSpec.EXACTLY)
        )
        assert(tree is FrameLayout)
        assertEquals(true, (tree as FrameLayout).allChildHasMeasured())
    }

    @Test
    fun testMeasure8() {
        Log.d("view-test", "wrap wrap")

        val tree = root().frameLayout { v1 ->
            v1.tag = "v1"
            v1.layoutWidth = WRAP_CONTENT
            v1.layoutHeight = WRAP_CONTENT

            v1.frameLayout { frameLayout ->
                frameLayout.tag = "v2"
                frameLayout.layoutWidth = WRAP_CONTENT
                frameLayout.layoutHeight = WRAP_CONTENT

                frameLayout.view {
                    it.tag = "v3"
                    it.layoutWidth = 200
                    it.layoutHeight = 300
                }
            }
        }

        tree.tag = "root"

        tree.measure(
            View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(1920, View.MeasureSpec.EXACTLY)
        )
        assert(tree is FrameLayout)
        assertEquals(true, (tree as FrameLayout).allChildHasMeasured())
    }

    @Test
    fun testMeasure9() {
        Log.d("view-test", "wrap 400")

        val tree = root().frameLayout { v1 ->
            v1.tag = "v1"
            v1.layoutWidth = WRAP_CONTENT
            v1.layoutHeight = WRAP_CONTENT

            v1.frameLayout { frameLayout ->
                frameLayout.tag = "v2"
                frameLayout.layoutWidth = 400
                frameLayout.layoutHeight = WRAP_CONTENT

                frameLayout.view {
                    it.tag = "v3"
                    it.layoutWidth = 200
                    it.layoutHeight = 300
                }
            }
        }

        tree.tag = "root"

        tree.measure(
            View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(1920, View.MeasureSpec.EXACTLY)
        )
        assert(tree is FrameLayout)
        assertEquals(true, (tree as FrameLayout).allChildHasMeasured())
    }
}