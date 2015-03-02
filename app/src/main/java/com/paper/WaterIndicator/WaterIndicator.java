package com.paper.WaterIndicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * ,==.              |~~~
 * /  66\             |
 * \c  -_)         |~~~
 * `) (           |
 * /   \       |~~~
 * /   \ \      |
 * ((   /\ \_ |~~~
 * \\  \ `--`|
 * / / /  |~~~
 * ___ (_(___)_|
 * <p/>
 * Created by Paper on 15-2-4 2015.
 */
public class WaterIndicator extends View implements PageIndicator{

    private float lastPosition;
    private int[] colors = {Color.BLUE,Color.CYAN,Color.GREEN,Color.RED};
    private Paint mPaint1;

    private float firstRadius,radius,secoundradius,radius2;

    private int viewheight,viewwidth,position_x,position_y,mPageCount;

    private int[] indicator_x,indicator_y;

    private int divider = 100;

    private int mCurPage ;
    private int viewPagerStatus;
    private int oritation;
    public WaterIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WaterIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        firstRadius =radius= 100;
        mPaint1 = new Paint();
        mPaint1.setColor(colors[1]);
        mPaint1.setAntiAlias(true);
        mPaint1.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        viewheight = getHeight();
        viewwidth = getWidth();
        position_x = viewwidth/mPageCount;
        position_y=viewheight/2;
        Log.e("hshs","mPageCount1:"+mPageCount);
        for (int i=0;i<mPageCount;i++){
            indicator_x[i] = position_x/2+i*position_x;
        }

    }

    @Override
    public void setViewPager(ViewPager view) {
        view.setOnPageChangeListener(this);
        mPageCount = view.getAdapter().getCount();
        indicator_x = new int[mPageCount];
        mCurPage = 0;
    }

    @Override
    public void setViewPager(ViewPager view, int initialPosition) {
        view.setOnPageChangeListener(this);
        view.setCurrentItem(initialPosition);
        mPageCount = view.getAdapter().getCount();
        mPageCount = initialPosition;
    }

    @Override
    public void setCurrentItem(int item) {

    }

    @Override
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {

    }

    @Override
    public void notifyDataSetChanged() {

    }

    @Override
    public void onPageScrolled(int i, float v, int i2) {
        if (lastPosition!=0&&v!=0.0&&lastPosition-v<0){
            //left
            radius=firstRadius*v;
            oritation = 1;
        }else if (lastPosition!=0&&v!=0.0&&lastPosition-v>0){
            //right
            radius=firstRadius*v;
            oritation =-1;
        }

        Log.e("hshs","radis:"+v);

        lastPosition = v;
        mCurPage = i;
        invalidate();
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {
        viewPagerStatus = i;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        Log.e("hshs","mPageCount2:"+mCurPage);
        Log.e("hshs", "ondraw:" + radius + "  " + position_x + "  " + position_y);
        if (viewPagerStatus == ViewPager.SCROLL_STATE_IDLE){
            canvas.drawCircle(indicator_x[mCurPage], position_y, firstRadius, mPaint1);
        }else if (viewPagerStatus == ViewPager.SCROLL_STATE_DRAGGING){
            canvas.drawCircle(indicator_x[mCurPage], position_y, radius, mPaint1);
//            canvas.drawCircle(indicator_x[mCurPage+oritation], position_y, firstRadius-radius, mPaint1);
        }

//        canvas.drawCircle(position_x+200,position_y,firstRadius-radius,mPaint1);
        canvas.restore();
        super.onDraw(canvas);
    }
}
