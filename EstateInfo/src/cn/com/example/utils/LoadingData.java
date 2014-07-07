package cn.com.example.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;

public class LoadingData extends AsyncTask<Integer, Integer, Integer> {
	ProgressDialog progressDialog;
	public int page = 0;
	Context mContext = null;
	Handler handler;

//	public List<PositionInfo> list;
	

	public LoadingData(Context mContext, Handler handler) {
		this.mContext = mContext;
		this.handler = handler;
	}

	/**
	 * �����Integer������ӦAsyncTask�еĵ�һ������ �����String����ֵ��ӦAsyncTask�ĵ���������
	 * �÷�������������UI�̵߳��У���Ҫ�����첽�����������ڸ÷����в��ܶ�UI���еĿռ�������ú��޸�
	 * ���ǿ��Ե���publishProgress��������onProgressUpdate��UI���в���
	 */

	@Override
	protected Integer doInBackground(Integer... params) {
		// TODO Auto-generated method stub
		int result = 0;
		switch (params[0]) {
		case 1:
			//list = new ArrayList<PositionInfo>();
			//selectdata();
			result = 1;
			break;
		}
		return result;
	}

	/**
	 * �����String������ӦAsyncTask�еĵ�����������Ҳ���ǽ���doInBackground�ķ���ֵ��
	 * ��doInBackground����ִ�н���֮�������У�����������UI�̵߳��� ���Զ�UI�ռ��������
	 */
	protected void onPostExecute(Integer result) {
		System.out.println("�첽����ִ�н���:" + result);
		progressDialog.cancel();
		progressDialog = null;
		switch (result) {
		case 1:
			handler.sendEmptyMessage(1);
			break;
		}
	}

	// �÷���������UI�̵߳���,����������UI�̵߳��� ���Զ�UI�ռ��������
	@Override
	protected void onPreExecute() {
		System.out.println("�첽����ִ�п�ʼ");
		progressDialog = ProgressDialog.show(mContext, "��ʾ", "���������������Ե�......",
				false);
	}

	/**
	 * �����Intege������ӦAsyncTask�еĵڶ�������
	 * ��doInBackground�������У���ÿ�ε���publishProgress�������ᴥ��onProgressUpdateִ��
	 * onProgressUpdate����UI�߳���ִ�У����п��Զ�UI�ռ���в���
	 */
	protected void onProgressUpdate(Integer... values) {
		int vlaue = values[0];
		System.out.println("vlae��" + vlaue);
	}

//	public void selectdata() {
//		JSONArray jsonArray = null;
//		String str;
//		try {
//			if (flag == false) {
//				System.out.println(Util.url + "searchJob.json?num=" + Util.num
//						+ "&startPos=" + page + keyword);
//				str = Util.getJSONData(Util.url + "searchJob.json?num="
//						+ Util.num + "&startPos=" + page + keyword);
//			} else {
//				System.out.println("Util.CITY_ID>>>"+Util.CITY_ID);
//				System.out.println(Util.url
//						+ "searchJob.json?num="
//						+ Util.num
//						+ "&startPos="
//						+ page
//						+ "&keyword="
//						+ Util.URLencode(keyword)
//						+ (Util.CITY_ID.equals("0") ? ""
//								: ("&workplace=" + Util.CITY_ID)));
//				str = Util.getJSONData(Util.url
//						+ "searchJob.json?num="
//						+ Util.num
//						+ "&startPos="
//						+ page
//						+ "&keyword="
//						+  Util.URLencode(keyword)
//						+ (Util.CITY_ID.equals("0") ? ""
//								: ("&workplace=" + Util.CITY_ID)));
//			}
//			System.out.println("�����ؼ���:" + str);
//			JSONObject jsonObject = new JSONObject(str);
//			if (jsonObject.getString("err").equals("none")) {
//				jsonObject = jsonObject.getJSONObject("res");
//				JSONObject jsonObjecta = jsonObject
//						.getJSONObject("facetFields");
//				JSONObject jsonObject1 = jsonObjecta.getJSONObject("salary");
//				ls.list_salary = new ArrayList<SiftInfo>();
//				result(jsonObject1, ls.list_salary, "salary");
//				JSONObject jsonObject2 = jsonObjecta
//						.getJSONObject("refreshTime");
//				ls.list_refreshTime = new ArrayList<SiftInfo>();
//				result(jsonObject2, ls.list_refreshTime, "refreshTime");
//				JSONObject jsonObject3 = jsonObjecta.getJSONObject("degree");
//				ls.list_degree = new ArrayList<SiftInfo>();
//				result(jsonObject3, ls.list_degree, "degree");
//				JSONObject jsonObject4 = jsonObjecta
//						.getJSONObject("experience");
//				ls.list_experience = new ArrayList<SiftInfo>();
//				result(jsonObject4, ls.list_experience, "experience");
//				JSONObject jsonObject5 = jsonObjecta
//						.getJSONObject("employerType");
//				ls.list_employerType = new ArrayList<SiftInfo>();
//				result(jsonObject5, ls.list_employerType, "employerType");
//				JSONObject jsonObject6 = jsonObjecta.getJSONObject("workType");
//				ls.list_workType = new ArrayList<SiftInfo>();
//				result(jsonObject6, ls.list_workType, "workType");
//				jsonArray = jsonObject.getJSONArray("jobElements");
//				for (int i = 0; i < jsonArray.length(); i++) {
//					JSONObject jsonObj = jsonArray.getJSONObject(i);
//					PositionInfo positioninfo = new PositionInfo();
//					positioninfo.setId(jsonObj.getString("id"));
//					positioninfo.setComName(Util.getJson(jsonObj, "comName"));
//					positioninfo.setJobName(Util.getJson(jsonObj, "jobName"));
//					positioninfo.setRefTime(Util.getJson(jsonObj, "refTime"));
//					positioninfo.setSalary(Util.getJson(jsonObj, "salary"));
//					JSONArray jsonArray1 = jsonObj.getJSONArray("workPlace");
//					JSONObject jsonObj1 = jsonArray1.getJSONObject(0);
//					positioninfo.setProvId(Util.getJson(jsonObj1, "provId"));
//					positioninfo
//							.setProvName(Util.getJson(jsonObj1, "provName"));
//					list.add(positioninfo);
//				}
//			} else {
//				System.out.println("" + jsonObject.getString("errNo"));
//			}
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	
	
}
