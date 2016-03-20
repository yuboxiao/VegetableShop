package com.whut.vs.widgets;

import java.util.List;

import net.tsz.afinal.FinalBitmap;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.whut.vegetableshop.R;
import com.whut.vs.adapters.CustomAdapter;
import com.whut.vs.bean.CategoryBean;
import com.whut.vs.utils.ScreenUtils;

/**
 * @author xiongbin
 * @date 2015-07-06
 */
public class ClassifyView extends LinearLayout implements OnItemClickListener {

	private ListView lV;
	private GridView gridView;
	private View splitView;

	private LeftListviewAdapter mLeftListviewAdapter;
	private RightGridviewAdapter mRightGridviewAdapter;
	
	private ILeftListviewItemListener mILeftListviewItemListener;
	private IRightGridviewItemListener mIRightGridviewItemListener;

	private int screenWidth;
	private Context mContext;
	private int selectedPosition; // 左边的ListView被选中时的item位置

	public ClassifyView(Context context) {
		this(context, null);
	}

	public ClassifyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOrientation(LinearLayout.HORIZONTAL);
		setBackgroundColor(Color.WHITE);

		mContext = context;
		initView();
	}

	private void initView() {
		screenWidth = ScreenUtils.getScreenWidth(mContext);
		mLeftListviewAdapter = new LeftListviewAdapter(mContext);

		lV = new ListView(mContext);
		// lV.setBackgroundColor(Color.WHITE);
		lV.setCacheColorHint(0);// 去掉拖动背景颜色
		lV.setDivider(new ColorDrawable(0xcccccccc));
		lV.setDividerHeight(2);
		lV.setVerticalScrollBarEnabled(false);
		lV.setFadingEdgeLength(0);
		lV.setOnItemClickListener(this);// 点击item监听
		lV.setOnScrollListener(new ListViewOnScrollListener());// 滑动监听
		addView(lV);

		splitView = new View(mContext);
		splitView.setBackgroundDrawable(new ColorDrawable(0xcccccccc));
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(1, LayoutParams.MATCH_PARENT);
		addView(splitView,params);

		gridView = new GridView(mContext);
		gridView.setNumColumns(3);
		gridView.setBackgroundColor(Color.WHITE);
		gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
		gridView.setCacheColorHint(0);// 去掉拖动背景颜色
		gridView.setOnItemClickListener(this);
		addView(gridView);
	}

	/****
	 * 添加Listview的数据
	 * @param list
	 */
	public void setListViewData(List<String> list) {
		mLeftListviewAdapter.setData(list);
		lV.setAdapter(mLeftListviewAdapter);
	}

	/****
	 * 添加Gridview的数据
	 * @param list
	 */
	public void setGridViewData(List<CategoryBean> list) {
		mRightGridviewAdapter = new RightGridviewAdapter(mContext, list);
		gridView.setAdapter(mRightGridviewAdapter);
	}

	public void recoveryListViewSelection() {
		lV.setSelectionFromTop(firstVisiblePosition, firstVisibleItemFromTop);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		lV.getLayoutParams().width = (int) (screenWidth * 0.3);
		// splitView.getLayoutParams().width = 1;
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		if (parent instanceof ListView) {
			listviewEvent(view, position);
		} else if (parent instanceof GridView) {
			gridviewEvent(view, position);
		}
	}
	
	/*****
	 * 左边的Listview被选择的监听响应
	 * @param view
	 * @param position
	 */
	private void listviewEvent(View view,int position){
		selectedPosition = position;
		final int firstVisiblePosition = lV.getFirstVisiblePosition();
		final int lastVisiblePosition = lV.getLastVisiblePosition();
		view.setBackgroundColor(Color.WHITE);
		view.findViewById(R.id.classify_listview_right_split_line)
				.setBackgroundColor(Color.WHITE);

		for (int i = 0; i <= lastVisiblePosition - firstVisiblePosition; i++) {
			View v = lV.getChildAt(i);
			if (v != view) {
				v.setBackgroundColor(Color.GRAY);
				v.findViewById(R.id.classify_listview_right_split_line)
						.setBackgroundColor(Color.GRAY);
			}
		}
		
		lV.post(new Runnable() {

			@TargetApi(VERSION_CODES.HONEYCOMB)
			@Override
			public void run() {

				if (firstVisiblePosition >= 0
						&& lastVisiblePosition < mLeftListviewAdapter
								.getCount() - 1) {
					if (VERSION.SDK_INT >= VERSION_CODES.HONEYCOMB) {
						// 此方法最小Api 11
						lV.smoothScrollToPositionFromTop(selectedPosition,
								0, 500);
					} else {
						lV.setSelection(selectedPosition);
					}
				}
			}
		});
		
		if (mILeftListviewItemListener != null) {
			mILeftListviewItemListener.OnItemClick(view, position);
		}
	}
	
	/*****
	 * 右边的Gridview被选择的监听响应
	 * @param view
	 * @param position
	 */
	private void gridviewEvent(View view,int position){
		if (mIRightGridviewItemListener != null) {
			mIRightGridviewItemListener.OnItemClick(view, position);
		}
	}

	private int firstVisiblePosition; // ListView滚动停止时第一个可见item的position
	private int firstVisibleItemFromTop;// ListView滚动停止时第一个可见item距离顶端的位置

	/*****
	 * 监听左边的ListView的滑动（包括手动滑动）
	 * 
	 * @author xiongbin
	 */
	private class ListViewOnScrollListener implements OnScrollListener {

		@Override
		public void onScrollStateChanged(AbsListView view, int scrollState) {
			if (scrollState == OnScrollListener.SCROLL_STATE_IDLE) {
				firstVisiblePosition = lV.getFirstVisiblePosition();
				View v = lV.getChildAt(0);
				if (v != null) {
					firstVisibleItemFromTop = v.getTop();
				} else {
					firstVisibleItemFromTop = 0;
				}
			}
		}

		@Override
		public void onScroll(AbsListView view, int firstVisibleItem,
				int visibleItemCount, int totalItemCount) {
			if (selectedPosition >= firstVisibleItem
					&& selectedPosition <= firstVisibleItem + visibleItemCount
							- 1) {
				View v = lV.getChildAt(selectedPosition - firstVisibleItem);
				v.setBackgroundColor(Color.WHITE);
				v.findViewById(R.id.classify_listview_right_split_line)
						.setBackgroundColor(Color.WHITE);
			}
		}

	}

	public static class LeftListviewAdapter extends BaseAdapter {
		private Context mContext;
		private List<String> list;
		private LayoutInflater mInflater;

		public LeftListviewAdapter(Context context) {
			mContext = context;
			mInflater = LayoutInflater.from(context);
		}

		public LeftListviewAdapter(Context context, List<String> list) {
			mContext = context;
			this.list = list;
			mInflater = LayoutInflater.from(context);
		}

		public void setData(List<String> list) {
			this.list = list;
		}

		public void addData(List<String> someList) {
			list.addAll(someList);
		}

		public void addItem(String item) {
			list.add(item);
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder mViewHolder;
			if (convertView == null) {
				mViewHolder = new ViewHolder();
				convertView = mInflater.inflate(
						R.layout.layout_classify_left_item, null);
				mViewHolder.tv = (TextView) convertView
						.findViewById(R.id.tv_classify_listview_item);
				mViewHolder.view = convertView
						.findViewById(R.id.classify_listview_right_split_line);
				convertView.setTag(mViewHolder);
			} else {
				mViewHolder = (ViewHolder) convertView.getTag();
			}

			mViewHolder.tv.setText(list.get(position));
			mViewHolder.view.setBackgroundColor(Color.GRAY);
			convertView.setBackgroundColor(Color.GRAY);
			return convertView;
		}

		class ViewHolder {
			TextView tv;
			View view;
		}

	}

	/**
	 * @author xiongbin
	 * @since 2016-03-02
	 */
	public static class RightGridviewAdapter extends
			CustomAdapter<CategoryBean> {

		private FinalBitmap mFinalBitmap;

		public RightGridviewAdapter(Context context, List<CategoryBean> list) {
			super(context, list);
			initFinalBitmap();
		}

		private void initFinalBitmap() {
			mFinalBitmap = FinalBitmap.create(mContext);
		}

		@Override
		public int obtainView() {
			return R.layout.layout_classify_right_item;
		}

		@Override
		public void bindView(CustomViewHolder vh, CategoryBean bean) {
			if (bean.getCategory() != null) {
				TextView tv = vh.getView(R.id.tv_classify_gridview_item);
				tv.setText(bean.getCategory());
			}

			ImageView iv = vh.getView(R.id.iv_classify_gridview_item);
			if (bean.getImageUrl() != null && !bean.getImageUrl().equals("")) {
				mFinalBitmap.display(iv, bean.getImageUrl());
			} /*
			 * else { iv.setImageResource(R.drawable.ic_launcher); }
			 */
		}

	}
	
	
	public ILeftListviewItemListener getmILeftListviewItemListener() {
		return mILeftListviewItemListener;
	}

	public void setmILeftListviewItemListener(
			ILeftListviewItemListener mILeftListviewItemListener) {
		this.mILeftListviewItemListener = mILeftListviewItemListener;
	}

	public IRightGridviewItemListener getmIRightGridviewItemListener() {
		return mIRightGridviewItemListener;
	}

	public void setmIRightGridviewItemListener(
			IRightGridviewItemListener mIRightGridviewItemListener) {
		this.mIRightGridviewItemListener = mIRightGridviewItemListener;
	}

	public interface ILeftListviewItemListener{
		public void OnItemClick(View view,int position);
	}
	
	public interface IRightGridviewItemListener{
		public void OnItemClick(View view,int position);
	}

}
