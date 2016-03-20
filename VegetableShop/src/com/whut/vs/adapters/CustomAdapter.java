package com.whut.vs.adapters;

import java.util.List;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/*** 
 * @author xiongbin
 * @date 2016-3-18
 * @description 通用适配器
 */
public abstract class CustomAdapter<T> extends BaseAdapter {
	
	protected List<T> list;
	protected Context mContext;
	
	public CustomAdapter(Context context,List<T> list){
		this.list = list;
		this.mContext = context;
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public T getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CustomViewHolder vh = CustomViewHolder.get(mContext, convertView, parent, obtainView(), position);
		bindView(vh,getItem(position));
		return vh.getConvertView();
	}
	
	public abstract int obtainView();
	public abstract void bindView(CustomViewHolder vh,T bean);
	
	public static class CustomViewHolder {

		private Context mContext;
		private int position;
		private View convertView;
		private SparseArray<View> mViews = new SparseArray<View>();
		
		private CustomViewHolder(Context context,ViewGroup parent,int layoutId,int position){
			this.mContext = context;
			this.position = position;
			convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
			convertView.setTag(this);
		}
		
		/****
		 * 如果convertView为空，就创建一个CustomViewHolder并返回。
		 * 如果convertView不为空，就由{@link View#getTag() getTag()}返回CustomViewHolder
		 * @param context
		 * @param convertView
		 * @param parent
		 * @param layoutId
		 * @param position
		 * @return
		 */
		public static CustomViewHolder get(Context context,View convertView,ViewGroup parent,int layoutId,int position){
			if (convertView == null) {
				return new CustomViewHolder(context, parent, layoutId, position);
			} else {
				CustomViewHolder vh = (CustomViewHolder) convertView.getTag();
				vh.position = position;
				return vh;
			}
		}
		
		/****
		 * 根据控件id返回控件引用
		 * @param viewId 
		 * 			item布局的控件id
		 * @return 控件引用
		 */
		@SuppressWarnings("unchecked")
		public <T extends View> T getView(int viewId){
			View view = mViews.get(viewId);
			if (view == null) {
				view = convertView.findViewById(viewId);
				mViews.put(viewId, view);
			}
			return (T) view;
		}
		
		/****
		 * getter 方法区
		 */
		public View getConvertView(){
			return convertView;
		}

		public int getPosition() {
			return position;
		}

		public Context getmContext() {
			return mContext;
		}
		
	}

}
