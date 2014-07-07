package cn.com.example.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.com.example.customview.MyDialog;
import cn.com.example.customview.MyDialog.LeaveMeetingDialogListener;

public class Tab1HousingInfo extends Activity implements LocationListener {

	private ViewPager mPager;
	// ��������ͼƬ��LinearLayout
	private ViewGroup viewPics;
	// ����СԲ���LinearLayout
	private ViewGroup viewPoints;
	// ��СԲ���ͼƬ�������ʾ
	private ImageView[] imageViews;
	private ImageView imageView;
	GuidePageAdapter GuidePageAdapter;
	ImageView contactus;
	Dialog dialog;
	private static final String MAP_URL = "http://gmaps-samples.googlecode.com/svn/trunk/articles-android-webmap/simple-android-map.html";
	private WebView webView;

	Location mostRecentLocation;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab1housinginfo);

		LinearLayout title = (LinearLayout) this.findViewById(R.id.title);
		title.setBackgroundResource(R.drawable.fangyuan_title);
		ImageView back = (ImageView) this.findViewById(R.id.back);
		contactus = (ImageView) this.findViewById(R.id.contactus);

		contactus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dialog = new MyDialog(Tab1HousingInfo.this, R.style.dialog,
						new LeaveMeetingDialogListener() {
							@Override
							public void onClick(View view) {
								switch (view.getId()) {
								case R.id.backdialog:
									dialog.dismiss();
									break;
								case R.id.consulting:
									//**********�������ת***********
									break;
								}
							}
						});
				dialog.show();
			}
		});
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});

		viewPoints = (ViewGroup) this.findViewById(R.id.viewGroup);
		// ���СԲ���ͼƬ
		imageViews = new ImageView[5];
		for (int i = 0; i < 5; i++) {
			imageView = new ImageView(this);
			// ����СԲ��imageview�Ĳ���
			imageView.setLayoutParams(new LayoutParams(15, 15));// ����һ����߾�Ϊ20
																// �Ĳ���
			imageView.setPadding(20, 0, 20, 0);
			// ��СԲ��layout��ӵ�������
			imageViews[i] = imageView;

			// Ĭ��ѡ�е��ǵ�һ��ͼƬ����ʱ��һ��СԲ����ѡ��״̬����������
			if (i == 0) {
				imageViews[i].setBackgroundResource(R.drawable.lan);
			} else {
				imageViews[i].setBackgroundResource(R.drawable.hui);
			}
			// ��imageviews��ӵ�СԲ����ͼ��
			viewPoints.addView(imageViews[i]);
		}
		mPager = (ViewPager) this.findViewById(R.id.guidePages);

		mPager.setAdapter(GuidePageAdapter = new GuidePageAdapter(this));
		mPager.setOnPageChangeListener(new GuidePageChangeListener());

		// getLocation();
		setupWebView();
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

	}

	private void getLocation() {
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		String provider = locationManager.getBestProvider(criteria, true);
		locationManager.requestLocationUpdates(provider, 1, 0, this);
		mostRecentLocation = locationManager.getLastKnownLocation(provider);
	}

	private void setupWebView() {
		double i = 39.832670;
		double j = 120.832670;
		final String centerURL = "javascript:centerAt(" + i + "," + j + ")";
		webView = (WebView) findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);
		// Wait for the page to load then send the location information
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageFinished(WebView view, String url) {
				webView.loadUrl(centerURL);
			}
		});
		webView.loadUrl(MAP_URL);
	}

	class GuidePageAdapter extends PagerAdapter {
		Context context;

		public GuidePageAdapter(Context context) {
			this.context = context;
		}

		// ����positionλ�õĽ���
		@Override
		public void destroyItem(View v, int position, Object arg2) {
			// TODO Auto-generated method stub
			// ((ViewPager) v).removeView((View) arg2);

		}

		@Override
		public void finishUpdate(View arg0) {
			// TODO Auto-generated method stub

		}

		// ��ȡ��ǰ���������
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 5;
			// return 0;
		}

		// ��ʼ��positionλ�õĽ���
		@Override
		public Object instantiateItem(View v, int position) {
			// TODO Auto-generated method stub
			System.out.println("position::" + position);
			// ((ViewPager) v).addView(pageViews.get(position));
			// return pageViews.get(position);
			ImageView iv = new ImageView(context);
			iv.setBackgroundResource(R.drawable.pic);
			((ViewPager) v).addView(iv);
			return iv;
		}

		// �ж��Ƿ��ɶ������ɽ���
		@Override
		public boolean isViewFromObject(View v, Object arg1) {
			// TODO Auto-generated method stub
			return v == arg1;
		}

		@Override
		public void startUpdate(View arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public int getItemPosition(Object object) {
			// TODO Auto-generated method stub
			return super.getItemPosition(object);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public Parcelable saveState() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	class GuidePageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int position) {
			// TODO Auto-generated method stub
			for (int i = 0; i < imageViews.length; i++) {
				imageViews[position].setBackgroundResource(R.drawable.lan);
				// ���ǵ�ǰѡ�е�page����СԲ������Ϊδѡ�е�״̬
				if (position != i) {
					imageViews[i].setBackgroundResource(R.drawable.bai);
				}
			}

		}
	}

	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub

	}

}
