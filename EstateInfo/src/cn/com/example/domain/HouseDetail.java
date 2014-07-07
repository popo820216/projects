package cn.com.example.domain;

import com.google.gson.Gson;

public class HouseDetail {
	int error;
	House data;
	
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public House getData() {
		return data;
	}
	public void setData(House data) {
		this.data = data;
	}
	
	public static HouseDetail convertJsonToBean(String jsonStr){
		Gson gson = new Gson();
		return gson.fromJson(jsonStr, HouseDetail.class);
	}
}
