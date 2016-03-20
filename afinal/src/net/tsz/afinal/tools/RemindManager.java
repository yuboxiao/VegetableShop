package net.tsz.afinal.tools;

import net.tsz.afinal.db.table.NormalPreferences;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Vibrator;

/**
 * @author xiongbin
 * 声音震动管理工具类
 */
public final class RemindManager {

	private static long[] pattern 		= { 50, 50 };
	private static long lastTime ;
	
	public static void remind(Context context) {
		
		if(System.currentTimeMillis() - lastTime > 1000){

			if (NormalPreferences.isSoundOpen) {
				sound(context);
			}
			
			if (NormalPreferences.isShakeOpen) {
				shake(context);
			}
			
			lastTime	= System.currentTimeMillis() ;
		}
	}
	
	private static void sound(Context context) {
		
		try {
			AudioManager am=(AudioManager)context.getSystemService(Context.AUDIO_SERVICE); 
			am.setStreamVolume(AudioManager.STREAM_MUSIC,
					am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
					AudioManager.FLAG_PLAY_SOUND);   
			
			MediaPlayer mPlayer = new MediaPlayer();
			
			mPlayer.reset();
			mPlayer.setDataSource(context, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
			mPlayer.setOnErrorListener(new OnErrorListener() {
				
				@Override
				public boolean onError(MediaPlayer mp, int what, int extra) {
					
					if(mp != null){
						mp.release() ;
					}
					
					return false;
				}
			}) ;
			
			mPlayer.setOnCompletionListener(new OnCompletionListener() {
				
				@Override
				public void onCompletion(MediaPlayer mp) {
					
					if(mp != null){
						mp.release() ;
					}
				}
			}) ;
			mPlayer.prepare();
			mPlayer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void shake(Context context) {
		
		try{
			
			Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
			vibrator.vibrate(pattern, -1);
			
		} catch(Exception e){
			e.printStackTrace() ;
		}
	}
}
