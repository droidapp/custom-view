package kg.begali.circlebutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Begali on 5/6/2017.
 */

public class CustomView extends View {

    private int circleCol, labelCol;
    private String circleText;
    private Paint circlePaint;
    private int lableSize;
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        circlePaint = new Paint();
        //retrieve attrs from attrs.xml
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,R.styleable.CustomView, 0, 0);

        try {
            circleText = typedArray.getString(R.styleable.CustomView_circleLabel);
            circleCol = typedArray.getInteger(R.styleable.CustomView_circleColor, Color.DKGRAY);
            labelCol = typedArray.getInteger(R.styleable.CustomView_labelColor, Color.WHITE);
            lableSize = typedArray.getDimensionPixelSize(R.styleable.CustomView_labelSize, 28);
        }
        finally {
            typedArray.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = this.getMeasuredWidth()/2;
        int height = this.getMeasuredHeight()/2;
        int radius =0;
        if (width<height){
            radius = width;
        }
        else {
            radius = height;
        }
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(circleCol);
        canvas.drawCircle(width, height, radius, circlePaint);

        circlePaint.setColor(labelCol);
        circlePaint.setTextAlign(Paint.Align.CENTER);
        circlePaint.setTextSize(lableSize);
        canvas.drawText(circleText, width, height, circlePaint);
    }
    //    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }
}
