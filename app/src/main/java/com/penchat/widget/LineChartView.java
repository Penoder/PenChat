package com.penchat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 折线图
 */
public class LineChartView extends View {

    /**
     * 需求： 绘制的折线图可以加上X、Y坐标，也可以不要坐标，只绘制折线
     * 1. X坐标集合
     * 2. Y坐标集合
     * 3. 需要绘制的折线点
     * 4 将点之间进行连线
     */

    private List<Float> xList = new ArrayList<>();
    private List<Float> yList = new ArrayList<>();
    private SparseIntArray pointArray = new SparseIntArray();

    // 记录缩放比例
    private int mScaleY = 1, mScaleX = 1;

    public LineChartView(Context context) {
        super(context);
    }

    public LineChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }



    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private float maxY, maxX;

    public void setPointArray(SparseIntArray pointArray) {
        this.pointArray = pointArray;
        for (int i = 0; i < pointArray.size(); i++) {
            int key = pointArray.keyAt(i);
            if (key > maxX) {
                maxX = key;
            }
            int value = pointArray.valueAt(i);
            if (value > maxY) {
                maxY = value;
            }
        }
    }
}
