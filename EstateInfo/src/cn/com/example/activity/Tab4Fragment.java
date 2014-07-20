package cn.com.example.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Tab4Fragment extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab4_fragment_layout);
		
		ImageView title = (ImageView)this.findViewById(R.id.title);
		title.setBackgroundResource(R.drawable.women_title);
		
		 LinearLayout telphone = (LinearLayout)this.findViewById(R.id.telphone);
		 telphone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showtel();
			}
		});
		 
	}
	
	private void showTips(){
		AlertDialog alertDialog = new AlertDialog.Builder(Tab4Fragment.this)
		.setTitle("�˳�����")
		.setMessage("�Ƿ��˳�����")
		.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which){
				Tab4Fragment.this.finish();
				System.exit(0);
			}
		})
		.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which){
			return;
		}})
		.create();  //�����Ի���
		alertDialog.show(); // ��ʾ�Ի���
	}
	
	private void showtel(){
		AlertDialog alertDialog = new AlertDialog.Builder(Tab4Fragment.this)
		.setTitle("��ʾ")
		.setMessage("�Ƿ񲦴�400-041-7515")
		.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which){
				Intent phoneIntent = new Intent(
						"android.intent.action.CALL", Uri.parse("tel:"
								+ "400-041-7515"));
				// 启动
				startActivity(phoneIntent);
			}
		})
		.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which){
			dialog.dismiss();
		}})
		.create();  //�����Ի�
		alertDialog.show(); // ��ʾ�Ի���
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0){
			this.showTips();
			return false;
		}
		return false;
	}
	
	final int COMMON_DIALOG = 1;

	protected Dialog onCreateDialog(int id) { // ��дonCreateDialog����
		Dialog dialog = null; // ����һ��Dialog�������ڷ���
		switch (id) { // ��id�����ж�
		case COMMON_DIALOG:
			Builder b = new AlertDialog.Builder(this);
			// b.setIcon(); //���öԻ����ͼ��
			b.setTitle("��ʾ"); // ���öԻ���ı���
			b.setMessage("�Ƿ�������绰"); // ���öԻ������ʾ����
			b.setPositiveButton( // ��Ӱ�ť
					"ȷ��", new DialogInterface.OnClickListener() { // Ϊ��ť��Ӽ�����
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							System.exit(0);
						}
					});
			b.setNegativeButton( // ��Ӱ�ť
					"ȡ��", new DialogInterface.OnClickListener() { // Ϊ��ť��Ӽ�����
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
						}
					});
			dialog = b.create(); // ����Dialog����
			break;
		default:
			break;
		}
		return dialog; // ��������Dialog�Ķ���
	}
}