package com.whut.vs.ui;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.whut.vegetableshop.R;
import com.whut.vs.application.SApplication;
import com.whut.vs.config.MsgType;
import com.whut.vs.ui.fragments.ClassifyFragment;
import com.whut.vs.ui.fragments.CookbookFragment;
import com.whut.vs.ui.fragments.MainPageFragment;
import com.whut.vs.ui.fragments.MyMarketFragment;
import com.whut.vs.ui.fragments.ShoppingCarFragment;

/****
 * @description 系统主界面
 * @author xiongbin
 *
 */
public class MainActivity extends FinalActivity implements View.OnTouchListener{
	
	@ViewInject(id = R.id.main_activity)
	private LinearLayout main_activity;
    private FragmentTabHost mTabHost;  
    private LayoutInflater mInflater;  
    private Class<?>[] mFragmentAry = { MainPageFragment.class, ClassifyFragment.class,  
    		CookbookFragment.class, ShoppingCarFragment.class, MyMarketFragment.class };  
    private int mImgAry[] = { R.drawable.menu1_n, R.drawable.menu2_n,  
    		R.drawable.menu3_n, R.drawable.menu4_n, R.drawable.menu4_n}; 
    private int mImgAry2[] = { R.drawable.menu1_f, R.drawable.menu2_f,  
    		R.drawable.menu3_f, R.drawable.menu4_f, R.drawable.menu4_f};
    private String mTxtAry[] = { "首页", "分类","菜谱", "购物车", "我的菜场" }; 

	private Handler mHandler = new Handler(new Handler.Callback() {
		
		@Override
		public boolean handleMessage(Message msg) {
			switch (msg.what) {

			default:
				break;
			}
			return false;
		}
	});
 
  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);
        
        SApplication.getInstance().addActivity(this);
  
        // 初始化
        initView();  
    }  
  
    /** 
     * 初始化组件 
     */  
    private void initView() {
    	main_activity.setOnTouchListener(this);
        mInflater = LayoutInflater.from(this);  
  
        // 实例化TabHost对象，得到TabHost  
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);  
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
  
        int count = mFragmentAry.length;  
        for (int i = 0; i < count; i++) {  
            TabSpec tabSpec = mTabHost.newTabSpec(mTxtAry[i]).setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec, mFragmentAry[i], null);
        }  
        mTabHost.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				setTabItemContent(tabId);
			}
		}); 
    }
    
    
    /***
     * 设置tabItem的内容
     * @param tabId
     */
    private void setTabItemContent(String tabId){
		for(int i = 0;i < 5;i++){
			View view = mTabHost.getTabWidget().getChildAt(i);
	        ImageView imageView = (ImageView) view.findViewById(R.id.tab_imageview);
	        TextView textView = (TextView) view.findViewById(R.id.tab_textview);
	        
			if(mTxtAry[i].equals(tabId)){
	        	view.setBackgroundResource(R.drawable.tab_bg2);
	        	imageView.setBackgroundResource(mImgAry2[i]);
	        	textView.setTextColor(Color.WHITE);
			}else{
				view.setBackgroundResource(R.drawable.tablayout_bg2);
	        	imageView.setBackgroundResource(mImgAry[i]);
	        	textView.setTextColor(Color.BLACK);
			}
		}
    }
  
    /** 
     * 给Tab按钮设置图标和文字 
     * @param index 
     * @return 
     */  
    private View getTabItemView(int index) {  
        View view = mInflater.inflate(R.layout.tab_item_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.tab_imageview);
        TextView textView = (TextView) view.findViewById(R.id.tab_textview);
      
        textView.setText(mTxtAry[index]);
        if (index == 0) {
            imageView.setBackgroundResource(mImgAry2[index]);
        	view.setBackgroundResource(R.drawable.tab_bg2);
        	textView.setTextColor(Color.WHITE);
		} else {
            imageView.setBackgroundResource(mImgAry[index]);
        	view.setBackgroundResource(R.drawable.tablayout_bg2);
        	textView.setTextColor(Color.BLACK);
		}
  
        return view;  
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
		return imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
	}
    
}
