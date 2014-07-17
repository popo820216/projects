package cn.com.example.utils;

import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
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
	
	public static String post(String url, Map<String, Object> paramsMap) {
		HttpPost httpRequest = new HttpPost(url);
		HttpParams httpParams = httpRequest.getParams();
		for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
			httpParams.setParameter(entry.getKey(), entry.getValue());
		}
		
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
