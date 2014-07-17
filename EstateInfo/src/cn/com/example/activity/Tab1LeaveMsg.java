package cn.com.example.activity;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import cn.com.example.utils.HttpAccessUtil;

public class Tab1LeaveMsg extends Activity{
	private EditText et_name;
	private EditText et_phone;
	private EditText et_email;
	private EditText et_msg;
	
	private Map<String, Object> params;
	private String uri = HttpAccessUtil.ip + "";
	private Tab1LeaveMsg context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab1_leavemsg_layout);
		
		ImageView back = (ImageView)findViewById(R.id.tab1_leavemsg_back);
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
		
		context = this;
		
		et_name = (EditText)findViewById(R.id.msg_name);
		et_phone = (EditText)findViewById(R.id.msg_phone);
		et_email = (EditText)findViewById(R.id.msg_email);
		et_msg = (EditText)findViewById(R.id.msg_message);
		
		ImageView submit_btn = (ImageView)findViewById(R.id.msg_submit);
		submit_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String name = et_name.getText().toString();
				String phone = et_phone.getText().toString();
				String email = et_email.getText().toString();
				String msg = et_msg.getText().toString();
				
				params = new HashMap<String, Object>();
				
				params.put("name", name);
				params.put("phone", phone);
				params.put("email", email);
				params.put("msg", msg);
				
				new Thread(submit).start();
			}
		});
	}
	
	ContextRunnable submit = new ContextRunnable(this) {
		@Override
		public void run() {
		//	String result = HttpAccessUtil.post(uri, params);
			Message msg = new Message();
			msg.what = 0;
			handler.sendMessage(msg);
		}
	};
	
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			if (msg.what == 0){
				context.finish();
			}
		};
	};
	
	abstract class ContextRunnable implements Runnable{
		@Override
		abstract public void run();
		private Context context;
		
		public ContextRunnable(Context context){
			this.context = context;
		}
	}
}
