package cn.com.example.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;

public class Tab4Fragment extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab4_fragment_layout);
		
		ImageView title = (ImageView)this.findViewById(R.id.title);
		title.setBackgroundResource(R.drawable.women_title);
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
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0){
			this.showTips();
			return false;
		}
		return false;
	}
}