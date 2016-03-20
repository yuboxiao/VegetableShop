package net.tsz.afinal.tools;

import java.io.File;

import android.content.Context;
import android.os.Environment;
/**
 * 文件管理工具类
 * @author xiongbin
 *  2015-06-15
 */
public final class FileUtils {

	private final static File getExternalCacheDir(Context context) {
		
		if(context == null){
			return null ;
		}
		
		final String cacheDir = "/Android/data/" + context.getPackageName() + "/";
		
		return new File(Environment.getExternalStorageDirectory().getPath() + cacheDir);
	}
	
	/****
	 * 得到设备可用路径
	 * @param context
	 * @param folderName
	 * @return
	 */
	public final static String createLocalDevicePath(Context context,String folderName) {
		
		final String dir = Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState()) ? getExternalCacheDir(context)
				.getPath() : context.getCacheDir().getPath();

		String out = dir != null ? (dir + File.separator + folderName) : null;

		// 路径是否存在
		if (out != null) {
			File f = new File(out);

			if (!f.exists()) {
				f.mkdirs();
			}
		}

		return out;
	}
}
