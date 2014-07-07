package cn.com.example.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;
import cn.com.example.customview.XListView;
import cn.com.example.customview.XListView.IXListViewListener;

public class Tab3Fragment extends Activity implements IXListViewListener{
	private String[] ids = {"content_tab3"};
	private int[] rids = {R.id.content_tab3};
	
	private XListView mListView;
	private SimpleAdapter mSimpleAdapter;
	private List<Map<String,Object>> data = new ArrayList<Map<String, Object>>();
	private Handler mHandler;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab3_fragment_layout);
		ImageView title = (ImageView)this.findViewById(R.id.title);
		title.setBackgroundResource(R.drawable.zixun);
		
		mListView = (XListView) findViewById(R.id.tab3_xListView);
		mListView.setPullLoadEnable(true);
		
		getData();
		mSimpleAdapter = new SimpleAdapter(this, data, R.layout.table3listitem, ids, rids);
		mSimpleAdapter.setViewBinder(new ViewBinder() {
			
			@Override
			public boolean setViewValue(View view, Object data, String textRepresentation) {
				if (view instanceof ImageView && data instanceof Bitmap)
				{
					ImageView iv = (ImageView)view;
					iv.setImageBitmap((Bitmap)data);
					return true;
				}else
					return false;
			}
		});
		
		mListView.setAdapter(mSimpleAdapter);
		mListView.setXListViewListener(this);
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(Tab3Fragment.this, Tab3HousingInfo.class);
				startActivityForResult(intent, 0);
			}
			
		});
		mHandler = new Handler();
//		mAdapter = new ArrayAdapter<String>(this, R.layout.table1listitem, items);
//		mListView.setAdapter(mAdapter);
//		mListView.setPullLoadEnable(false);
//		mListView.setPullRefreshEnable(false);
		
	}

	private void getData() {
		for (int i = 0; i < 5; i++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("content_tab3", "库格牧场一套洋房，跌至70万美金库格牧场一套洋房，跌至70万美金");
			data.add(map);
		}
	}

	private void onLoad() {
		mListView.stopRefresh();
		mListView.stopLoadMore();
		mListView.setRefreshTime("刚刚");
	}
	
	@Override
	public void onRefresh() {
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				data.clear();
				getData();
				mSimpleAdapter.notifyDataSetChanged();
				mSimpleAdapter = new SimpleAdapter(Tab3Fragment.this, data, R.layout.table3listitem, ids, rids);
				mSimpleAdapter.setViewBinder(new ViewBinder() {

					@Override
					public boolean setViewValue(View view, Object data, String textRepresentation) {
						if (view instanceof ImageView && data instanceof Bitmap)
						{
							ImageView iv = (ImageView)view;
							iv.setImageBitmap((Bitmap)data);
							return true;
						}else
							return false;
					}
				});
				mListView.setAdapter(mSimpleAdapter);
				onLoad();
			}
		}, 2000);
	}

	@Override
	public void onLoadMore() {
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				getData();
				mSimpleAdapter.notifyDataSetChanged();
				onLoad();
			}
		}, 2000);
	}
	
	private void showTips(){
		AlertDialog alertDialog = new AlertDialog.Builder(Tab3Fragment.this)
		.setTitle("退出程序")
		.setMessage("是否退出程序")
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which){
				Tab3Fragment.this.finish();
				System.exit(0);
			}
		})
		.setNegativeButton("取消", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which){
			return;
		}})
		.create();  //创建对话框
		alertDialog.show(); // 显示对话框
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0){
			this.showTips();
			return false;
		}
		return false;
	}
}