package com.whut.vs.application;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import com.whut.vs.adapters.CustomAdapter;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/*****
 * @author xiongbin
 * @since 2015-06-01
 * @company ������ͨ
 */
public class SApplication extends Application {
	
	private static SApplication instance;
	private List<Activity> activitys = new LinkedList<Activity>();
	
	@Override
	public void onCreate() {
		super.onCreate();
		setSystemLanguage();

		instance = this;
	}
	
	
	public void addActivity(Activity ac){
		activitys.add(ac);
	}
	
	public void deleteActivity(Activity ac){
		if(activitys.contains(ac)){
			activitys.remove(ac);
		}
	}
	
	
	public void exitSystem(){
		for(Activity ac : activitys){
			ac.finish();
		}
		System.exit(0);
	}
	
	/*****
	 * ����ϵͳ����
	 */
	private void setSystemLanguage(){
		Resources resources = getResources();
		Configuration config = resources.getConfiguration();//������ö���  
		DisplayMetrics dm = resources .getDisplayMetrics();//�����Ļ��������Ҫ�Ƿֱ��ʣ����صȡ�  
		config.locale = Locale.SIMPLIFIED_CHINESE; //��������  
		resources.updateConfiguration(config, dm);
	}
	
	public static SApplication getInstance(){
		
		return instance;
	}
}
