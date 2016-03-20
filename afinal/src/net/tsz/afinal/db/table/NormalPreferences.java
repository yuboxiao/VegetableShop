package net.tsz.afinal.db.table;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
/**
 * @author xiongbin
 *  2015-06-15
 */
public final class NormalPreferences {

	private static NormalPreferences instance;
	
	public static boolean isSoundOpen 							= true;
	public static boolean isShakeOpen 							= true;
	public static boolean isDownOpen 							= true;
	
	private SharedPreferences mSharedPreferences;
	private Editor 				mEditor ;
	
	private NormalPreferences(Context context){
		mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		mEditor = mSharedPreferences.edit();
	}
	
	public static NormalPreferences defaultPresence(){
		if(instance != null){
			return instance;
		}
		
		return null;
	}
	
	public static NormalPreferences getInstance(Context context){
		
		if(instance == null){
			instance = new NormalPreferences(context);
		}
		
		return instance;
	}
	
	private boolean checkPutInput(String key){
		
		if(key == null || key.equals("")){
			return false ;
		}
		
		if(mEditor == null){
			return false ;
		}
		
		return true ;
	}
	
	public void putString(String key,String value){
		
		if(!checkPutInput(key) || value == null) return ;
		
		mEditor.putString(key, value).commit() ;
	} 
	
	public void putInt(String key,int value){
		
		if(!checkPutInput(key)) return ;
		
		mEditor.putInt(key, value).commit() ;
	}
	
	public void putLong(String key,long value){
		
		if(!checkPutInput(key)) return ;
		
		mEditor.putLong(key, value).commit() ;
	}
	
	public void putBoolean(String key,boolean value){
		
		if(!checkPutInput(key)) return ;
		
		mEditor.putBoolean(key, value).commit() ;
	}
	
	public void putFloat(String key,float value){
		
		if(!checkPutInput(key)) return ;
		
		mEditor.putFloat(key, value).commit() ;
	}
	
	private boolean checkGetInput(String key){
		
		if(key == null || key.equals("")){
			return false ;
		}
		
		if(mSharedPreferences == null){
			return false ;
		}
		
		return true ;
	}
	
	public String getString(String key){
		
		if(!checkGetInput(key)) return null ;
		
		return mSharedPreferences.getString(key, "");
	}
	
	public int getInt(String key){
		
		if(!checkGetInput(key)) return -1 ;
		
		return mSharedPreferences.getInt(key, -1);
	}
	
	public long getLong(String key){
		
		if(!checkGetInput(key)) return -1 ;
		
		return mSharedPreferences.getLong(key, -1) ;
	}
	
	public float getFloat(String key){
		
		if(!checkGetInput(key)) return -1 ;
		
		return mSharedPreferences.getFloat(key, 0.0f) ;
	}
	
	public boolean getBoolean(String key){
		
		if(!checkGetInput(key)) return false ;
		
		return mSharedPreferences.getBoolean(key, false) ;
	}
	
	public boolean getBoolean(String key,boolean defaultValue){
		
		if(!checkGetInput(key)) return false ;
		
		return mSharedPreferences.getBoolean(key, defaultValue) ;
	}
	
	
	public void clear(){
		mSharedPreferences 	= null ;
		mEditor				= null ;
		instance			= null ;
	}
}
