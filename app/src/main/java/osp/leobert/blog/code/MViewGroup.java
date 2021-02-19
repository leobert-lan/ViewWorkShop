package osp.leobert.blog.code;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

/**
 * <p><b>Package:</b> osp.leobert.blog.code </p>
 * <p><b>Project:</b> BlogCode </p>
 * <p><b>Classname:</b> MViewGroup </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2021/2/16.
 */
public class MViewGroup extends RelativeLayout {
    public static final String tag = "xxxx2";

    public MViewGroup(Context context) {
        super(context);
    }

    public MViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e(tag, getTag() + " w:" + widthMeasureSpec + "   h:" + heightMeasureSpec);

//
//       Log.e("xxxx", "w:" + widthMeasureSpec + "   h:" + heightMeasureSpec, new Throwable());


        Log.e(tag, getTag() + " w mode:" + A.Companion.getMode(MeasureSpec.getMode(widthMeasureSpec)));
        Log.e(tag, getTag() + " w size:" + MeasureSpec.getSize(widthMeasureSpec));
        Log.e(tag, " ");


        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

//    @Override
//    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
//        layoutChildren(left, top, right, bottom, false /* no force left gravity */);
//    }
//
//    void layoutChildren(int left, int top, int right, int bottom, boolean forceLeftGravity) {
//        final int count = getChildCount();
//
//        final int parentLeft = 0;
//        final int parentRight = right - left;
//
//        final int parentTop = 0;
//        final int parentBottom = bottom - top;
//
//        for (int i = 0; i < count; i++) {
//            final View child = getChildAt(i);
//            if (child.getVisibility() != GONE) {
//                final ViewGroup.LayoutParams lp = child.getLayoutParams();
//
//                final int width = child.getMeasuredWidth();
//                final int height = child.getMeasuredHeight();
//
//                int childLeft = 0;
//                int childTop = 0;
//
//                int gravity = Gravity.TOP;
//
//                final int layoutDirection = 0;
//                final int absoluteGravity = Gravity.getAbsoluteGravity(gravity, layoutDirection);
//                final int verticalGravity = gravity & Gravity.VERTICAL_GRAVITY_MASK;
//
////                switch (absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK) {
////                    case Gravity.CENTER_HORIZONTAL:
////                        childLeft = parentLeft + (parentRight - parentLeft - width) / 2 +
////                                lp.leftMargin - lp.rightMargin;
////                        break;
////                    case Gravity.RIGHT:
////                        if (!forceLeftGravity) {
////                            childLeft = parentRight - width - lp.rightMargin;
////                            break;
////                        }
////                    case Gravity.LEFT:
////                    default:
////                        childLeft = parentLeft + lp.leftMargin;
////                }
//
////                switch (verticalGravity) {
////                    case Gravity.TOP:
////                        childTop = parentTop + lp.topMargin;
////                        break;
////                    case Gravity.CENTER_VERTICAL:
////                        childTop = parentTop + (parentBottom - parentTop - height) / 2 +
////                                lp.topMargin - lp.bottomMargin;
////                        break;
////                    case Gravity.BOTTOM:
////                        childTop = parentBottom - height - lp.bottomMargin;
////                        break;
////                    default:
////                        childTop = parentTop + lp.topMargin;
////                }
//
//                child.layout(childLeft, childTop, childLeft + width, childTop + height);
//            }
//        }
//    }
}
