package osp.leobert.blog.code;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * <p><b>Package:</b> osp.leobert.blog.code </p>
 * <p><b>Project:</b> BlogCode </p>
 * <p><b>Classname:</b> MView </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2021/2/15.
 */
public class MView extends View {
    public MView(Context context) {
        super(context);
    }

    public MView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("xxxx", "w:" + widthMeasureSpec + "   h:" + heightMeasureSpec);

//        Log.e("xxxx", "w:" + widthMeasureSpec + "   h:" + heightMeasureSpec, new Throwable());

        Log.e("xxxx", "w mode:" + A.Companion.getMode(MeasureSpec.getMode(widthMeasureSpec)));
        Log.e("xxxx", "w size:" + MeasureSpec.getSize(widthMeasureSpec));

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void layout(int l, int t, int r, int b) {}
}
