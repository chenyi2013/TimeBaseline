package com.example.timebaseline;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class TimeBaselineView extends View {

	/**
	 * 时间轴之间的距离
	 */
	private float mSpacing;

	/**
	 * 被当前被选中的时间点
	 */
	private float mSelected;
	/**
	 * 没有被选中的时间点的内圆半径
	 */
	private float mCircleRadius;
	/**
	 * 没有被选中的时间点的外圆环宽度
	 */
	private float mOuterCircleWidth;
	/**
	 * 当前被选中的时间点的内圆半径
	 */
	private float mSelectedCircleRadius;
	/**
	 * 当前被选中的时间点的内圆环宽度
	 */
	private float mSelectedInnerCircleWidth;
	/**
	 * 当前被选中的时间点的外圆环宽度
	 */
	private float mSelectedOuterCircleRadius;

	/**
	 * 时间轴的高度
	 */
	private float mTimeBaselineHeight;

	/**
	 * 时间点处的文字集合
	 */
	private ArrayList<?> mContent;

	/**
	 * 监听被选中的时间点的回调接口
	 * 
	 * @author Kevin
	 * 
	 */
	public interface OnSelectedListener {
		/**
		 * 时间点被选中的时候会调用此方法
		 * 
		 * @param position
		 */
		public void onSelect(int position);
	}

	public TimeBaselineView(Context context) {
		super(context);

	}

	public TimeBaselineView(Context context, AttributeSet attrs) {
		super(context, attrs);

		float density = getResources().getDisplayMetrics().density;

		TypedArray typedArray = context.getTheme().obtainStyledAttributes(
				attrs, R.styleable.TimeBaseLine, 0, 0);
		mSpacing = typedArray.getDimension(R.styleable.TimeBaseLine_spacing,
				80 * density);
		mSelected = typedArray.getInteger(R.styleable.TimeBaseLine_selected, 0);
		mCircleRadius = typedArray.getDimension(
				R.styleable.TimeBaseLine_circleRadius, 20 * density);
		mOuterCircleWidth = typedArray.getDimension(
				R.styleable.TimeBaseLine_outerCircleWidth, 10 * density);
		mSelectedCircleRadius = typedArray.getDimension(
				R.styleable.TimeBaseLine_selectedCircleRadius, 30 * density);
		mSelectedInnerCircleWidth = typedArray
				.getDimension(
						R.styleable.TimeBaseLine_selectedInnerCircleWidth,
						10 * density);
		mSelectedOuterCircleRadius = typedArray
				.getDimension(
						R.styleable.TimeBaseLine_selectedOuterCircleWidth,
						10 * density);
		mTimeBaselineHeight = typedArray.getDimension(
				R.styleable.TimeBaseLine_timeBaselineHeight, 10 * density);

		typedArray.recycle();

	}

	public TimeBaselineView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
		int measureHeight = MeasureSpec.getSize(heightMeasureSpec);

		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);

		int width = Math
				.round((mSpacing + (mCircleRadius + mSelectedInnerCircleWidth) * 2)
						* (mContent.size() - 1)
						+ (mSelectedCircleRadius + mSelectedInnerCircleWidth + mSelectedOuterCircleRadius)
						* 2);
		;
		int height = Math
				.round(20 * getResources().getDisplayMetrics().density);
		;

		if (widthMode == MeasureSpec.EXACTLY) {
			if (width < measureWidth) {
				width = measureWidth;
			}
		}

		if (heightMode == MeasureSpec.EXACTLY) {
			if (height < measureHeight) {
				height = measureHeight;
			}
		}

		setMeasuredDimension(width, height);

	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return super.onTouchEvent(event);
	}

}
