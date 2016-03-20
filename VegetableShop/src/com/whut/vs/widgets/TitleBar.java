package com.whut.vs.widgets;

import com.whut.vegetableshop.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * @author simon
 * @date 2015-06-16
 */
public class TitleBar extends LinearLayout {

	private Context context;
	private LayoutInflater inflater;
	private TextView buttonLeft;
	private Button buttonRight;
	private TextView textTitle;
	private LinearLayout leftLayout;
	private OnClickTitleBarListener onClickTitleBarListener;

	private View.OnClickListener onClickListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v.getId() == R.id.title_bar_left_layout) {

				if (onClickTitleBarListener != null) {
					onClickTitleBarListener.onClickLeftButton();
				}
			} else if (v.getId() == R.id.title_bar_right) {

				if (onClickTitleBarListener != null) {
					onClickTitleBarListener.onClickRightButton();
				}
			}

		}
	};

	public TitleBar(Context context) {
		this(context, null);
	}

	public TitleBar(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public TitleBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs);
		this.context = context;
		inflater = LayoutInflater.from(context);
		init();
	}

	private void init() {
		setOrientation(VERTICAL);
		setBackgroundResource(R.color.orange);
		View view = inflater.inflate(R.layout.layout_title_bar, null);
		if (isInEditMode()) return;
		buttonLeft 	= (TextView) view.findViewById(R.id.title_bar_left);
		buttonRight = (Button) view.findViewById(R.id.title_bar_right);
		textTitle 	= (TextView) view.findViewById(R.id.title_bar_title);
		leftLayout 	= (LinearLayout) view.findViewById(R.id.title_bar_left_layout);
		addView(view);

	}

	public void setTitleText(String text) {

		if (textTitle != null) {
			textTitle.setText(text);
		}
	}

	public void setTitleText(String text,int color) {

		if (textTitle != null) {
			textTitle.setText(text);
			textTitle.setTextColor(color);
		}
	}
	
	////////left button setting starts
	public void enableLeft() {
		if (buttonLeft != null && leftLayout != null) {
			buttonLeft.setVisibility(View.VISIBLE);
			leftLayout.setOnClickListener(onClickListener);
		}
	}
	
	public void disableLeft() {
		if (buttonLeft != null && leftLayout != null) {
			buttonLeft.setVisibility(View.INVISIBLE);
			leftLayout.setOnClickListener(null);
		}
	}
	
	public boolean leftIsVisible() {
		if(buttonLeft.getVisibility() == View.VISIBLE){
			return true;
		} else {
			return false;
		}
	}
	
	public TitleBar setLeftImage(int resId) {
		if(leftIsVisible()){
			buttonLeft.setBackgroundResource(resId);
			setLeftMargin(5);
		}
		return this;
	}
	
	public TitleBar setLeftImageAndText(int resId,String text) {
		Drawable drawable = context.getResources().getDrawable(resId);
		if(leftIsVisible() && drawable != null){
			buttonLeft.setCompoundDrawables(drawable, null, null, null);
		}
		if (text != null) {
			buttonLeft.setText(text);
		}
		return this;
	}
	
	public TitleBar setLeftImageAndText(int resId,int pad,String text) {
		setLeftImageAndText(resId, text);
		if (buttonLeft != null) {
			buttonLeft.setCompoundDrawablePadding(pad);
		}
		return this;
	}
	
	public TitleBar setLeftImageAndText(int resId,int pad,String text,int color) {
		setLeftImageAndText(resId, pad, text);
		if (buttonLeft != null) {
			buttonLeft.setTextColor(color);
		}
		return this;
	}
	
	public void setLeftPaading(int left, int top, int right, int bottom) {

		if (leftIsVisible()) {
			buttonLeft.setPadding(left, top, right, bottom);
		}
	}

	public void setLeftMargin(int marginLeft) {

		if (leftIsVisible()) {
			LinearLayout.LayoutParams params = (android.widget.LinearLayout.LayoutParams) buttonLeft.getLayoutParams();
			params.leftMargin = marginLeft;
			buttonLeft.setLayoutParams(params);
		}
	}
	
	////////left button setting ends
	

	/////// right button setting starts
	public void disableRightButton() {
		if (buttonRight != null) {
			buttonRight.setVisibility(View.INVISIBLE);
			buttonRight.setOnClickListener(null);
		}
	}

	public void enableRightButton() {
		if (buttonRight != null) {
			buttonRight.setVisibility(View.VISIBLE);
			buttonRight.setOnClickListener(onClickListener);
		}
	}
	
	public boolean rightIsVisible() {
		if(buttonRight.getVisibility() == View.VISIBLE){
			return true;
		} else {
			return false;
		}
	}

	public void setRightButtonText(int rid) {
		if (rightIsVisible()) {
			buttonRight.setText(rid);
		}
	}
	
	public void setRightButtonText(String text) {
		if (rightIsVisible()) {
			buttonRight.setText(text);
		}
	}

	public void enableRightButtonImage(int rid) {

		if (rightIsVisible()) {
			buttonRight.setBackgroundResource(rid);
		}
	}
	
	public void setRightButtonPadding(int left, int top, int right, int bottom) {

		if (buttonRight != null) {
			buttonRight.setPadding(left, top, right, bottom);
		}
	}

	public void setRightButtonMargin(int marginRight) {

		if (buttonRight != null) {
			RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) buttonRight.getLayoutParams();
			params.rightMargin = marginRight;
			buttonRight.setLayoutParams(params);
		}
	}

	///////////// right button setting ends

	public void setOnClickTitleBarListener(OnClickTitleBarListener onClickTitleBarListener) {
		this.onClickTitleBarListener = onClickTitleBarListener;
	}

	public interface OnClickTitleBarListener {

		void onClickLeftButton();

		void onClickRightButton();
	}

}
