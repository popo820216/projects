package cn.com.example.activity;

import java.lang.reflect.Field;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;

public class MainActivity extends TabActivity {
	public static TabHost tabHost;
	private TabWidget tabWidget;
	Field mBottomLeftStrip;
	Field mBottomRightStrip;
	public static int widthPixels, heightPixels;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		// Ҫ��ȡ��Ļ�Ŀ�͸ߵȲ�����������Ҫ����һ��DisplayMetrics������Ļ�Ŀ�ߵ����Դ�������������
		DisplayMetrics DM = new DisplayMetrics();
		// ��ȡ���ڹ�����,��ȡ��ǰ�Ĵ���,����getDefaultDisplay()���佫������Ļ��һЩ��Ϣд��DM������,���ͨ��getMetrics(DM)��ȡ
		getWindowManager().getDefaultDisplay().getMetrics(DM);

		// ��ӡ��ȡ�Ŀ�͸�
		widthPixels = DM.widthPixels;
		heightPixels = DM.heightPixels;
		makeTab();
		
	}

	int focusImg[] = { R.drawable.xinxi_icon1, R.drawable.sousu_icon2_1,
			R.drawable.zixun_icon3_1, R.drawable.women_icon4_1 };
	int unfocusImg[] = { R.drawable.xinxi_icon1_1, R.drawable.sousu_icon2,
			R.drawable.zixun_icon3, R.drawable.women_icon4 };

	public void makeTab() {
		if (this.tabHost == null) {
			tabHost = getTabHost();
			tabWidget = getTabWidget();
			tabHost.setup();
			tabHost.bringToFront();
			tabWidget.setStripEnabled(false);

			TabSpec tab1 = tabHost.newTabSpec("1");
			TabSpec tab2 = tabHost.newTabSpec("2");
			TabSpec tab3 = tabHost.newTabSpec("3");
			TabSpec tab4 = tabHost.newTabSpec("4");
			
			//Intent intent3 = new Intent(this, Tab3_Recommend.class);

			tab1.setIndicator("").setContent(
					new Intent(this, Tab1Fragment.class));
			tab2.setIndicator("")
					.setContent(new Intent(this, Tab2Fragment.class));
			tab3.setIndicator("")
					.setContent(new Intent(this, Tab3Fragment.class));
			tab4.setIndicator("")
					.setContent(new Intent(this, Tab4Fragment.class));

			tabHost.addTab(tab1);
			tabHost.addTab(tab2);
//			tabHost.addTab(tab3.setIndicator(getIndicatorView()).setContent(
//					intent3));
			tabHost.addTab(tab3);
			tabHost.addTab(tab4);

			for (int i = 0; i < tabWidget.getChildCount(); i++) {
				tabWidget.getChildAt(i).getLayoutParams().height = heightPixels*108/1136;
				tabWidget.getChildAt(i).getLayoutParams().width = widthPixels / 4;
				View view = tabWidget.getChildAt(i);
				if (tabHost.getCurrentTab() == i) {
					view.setBackgroundDrawable(getResources().getDrawable(
							focusImg[i]));
				} else {
					view.setBackgroundDrawable(getResources().getDrawable(
							unfocusImg[i]));
				}
			}

			tabHost.setOnTabChangedListener(new OnTabChangeListener() {

				@Override
				public void onTabChanged(String tabId) {

					System.out.println("tabId:" + tabId);
					if (tabId.equals("1"))
//						if (Tab1_JobSearch.tab1_job != null) {
//							Intent intent = new Intent(Main.this, Ceshi.class);
//							startActivity(intent);
//						}
					if (tabId.equals("3"))
						num.setVisibility(View.GONE);
					for (int i = 0; i < tabWidget.getChildCount(); i++) {
						View view = tabWidget.getChildAt(i);
						if (tabHost.getCurrentTab() == i) {
							view.setBackgroundDrawable(getResources()
									.getDrawable(focusImg[i]));
						} else {
							view.setBackgroundDrawable(getResources()
									.getDrawable(unfocusImg[i]));
						}
					}
				}
			});

		}
	}

	LayoutInflater mInflater;
	public static Button num;

//	protected View getIndicatorView() {
//		mInflater = LayoutInflater.from(this);
//		View _View = mInflater.inflate(R.layout.addview, null);
//		num = (Button) _View.findViewById(R.id.num);
//		num.setVisibility(View.GONE);
//		return _View;
//	}

//	/**
//	 * �˳�
//	 */
//	@Override
//	public boolean dispatchKeyEvent(KeyEvent event) {
//		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
//				&& event.getAction() == KeyEvent.ACTION_DOWN
//				&& event.getRepeatCount() == 0) {
//			// ����Ĳ�������
//			showDialog(COMMON_DIALOG);
//		}
//		return super.dispatchKeyEvent(event);
//	}
//
//	@Override
//	public void onBackPressed() {
//		super.onBackPressed();
//	}

//	final int COMMON_DIALOG = 1;
//
//	protected Dialog onCreateDialog(int id) { // ��дonCreateDialog����
//		Dialog dialog = null; // ����һ��Dialog�������ڷ���
//		switch (id) { // ��id�����ж�
//		case COMMON_DIALOG:
//			Builder b = new AlertDialog.Builder(this);
//			// b.setIcon(); //���öԻ����ͼ��
//			b.setTitle(R.string.dialogTitle); // ���öԻ���ı���
//			b.setMessage(R.string.dialogMessage); // ���öԻ������ʾ����
//			b.setPositiveButton( // ��Ӱ�ť
//					R.string.Ok, new DialogInterface.OnClickListener() { // Ϊ��ť��Ӽ�����
//						public void onClick(DialogInterface dialog, int which) {
//							// TODO Auto-generated method stub
//							System.exit(0);
//						}
//					});
//			b.setNegativeButton( // ��Ӱ�ť
//					R.string.Cancel, new DialogInterface.OnClickListener() { // Ϊ��ť��Ӽ�����
//						public void onClick(DialogInterface dialog, int which) {
//							// TODO Auto-generated method stub
//						}
//					});
//			dialog = b.create(); // ����Dialog����
//			break;
//		default:
//			break;
//		}
//		return dialog; // ��������Dialog�Ķ���
//	}

}