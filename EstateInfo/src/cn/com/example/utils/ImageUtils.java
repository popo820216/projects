package cn.com.example.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageUtils {
	public static Bitmap getHttpBitmap(String url){
		URL file = null;
		Bitmap bitmap = null;
		try{
			file = new URL(url);
			HttpURLConnection conn = (HttpURLConnection)file.openConnection();
			conn.setConnectTimeout(0);
			conn.setDoInput(true);
			InputStream is = conn.getInputStream();
			bitmap = BitmapFactory.decodeStream(is);
			is.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bitmap;
	}
	
	public static Map<String,Bitmap> getHttpBitmaps(Map<String,String> list){
		Map<String, Bitmap> result = new HashMap<String,Bitmap>();
		
		for (Entry<String, String> entry : list.entrySet()){
			URL file = null;
			Bitmap bitmap = null;
			
			String id = entry.getKey();
			String url = entry.getValue();
			try{
				file = new URL(url);
				HttpURLConnection conn = (HttpURLConnection)file.openConnection();
				conn.setConnectTimeout(0);
				conn.setDoInput(true);
				InputStream is = conn.getInputStream();
				bitmap = BitmapFactory.decodeStream(is);
				is.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			result.put(id, bitmap);
		}
		return result;
	}
}
