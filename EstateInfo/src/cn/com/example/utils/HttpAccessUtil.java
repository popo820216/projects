package cn.com.example.utils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpAccessUtil {
	public static String ip = "http://182.92.78.141/";
	
	public static String connServerForResult(String url) {
		HttpGet httpRequest = new HttpGet(url);
		String result = null;
		HttpClient httpClient;
		HttpResponse httpResponse;
		try{
			httpClient = new DefaultHttpClient();
			httpResponse = httpClient.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				result = EntityUtils.toString(httpResponse.getEntity());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			httpResponse = null;
		}
		return result;
	}
	
}
