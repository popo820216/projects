package cn.com.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Tab3HousingInfo extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab3_housinginfo_layout);
		
		ImageView back = (ImageView)this.findViewById(R.id.tab3_housing_back);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		String summary_txt = "�������һ���󷿣�����70������";
		TextView summary = (TextView)findViewById(R.id.text_summary);
		summary.setText(summary_txt);
		
		ImageView image_summary = (ImageView)findViewById(R.id.image_summary);
		image_summary.setBackgroundResource(R.drawable.pic);
		
		String detail_txt = "����й���������ǿ��Ͷ����ʶ�͸��������������ߵ�����£��������������÷�����������Խ��Խ�󣬹��������������й���Խ��Խ�࣬�ż�ҲԽ��Խ�͡������ں��⹺�÷�������Ϊͨ�����ں������������ѣ������������������õ�����²ſ�ʵ�֣�����һֱ�г����鲢�޽ϴ����������Ž��������ڷ��۾���һ�εĿ��������󣬷��۽�������Ե��ȶ��ڣ����ҹ��ڷ����ս�Ҳʹ�ù��������ĳɱ��������ߣ��ټ�������Ҷ��ڱ�ֵ������ֵ�Ĵ󱳾��£�Խ��Խ��Ĺ����߽��۹�Ͷ���ĺ����г������������ķ����г��۸���Դ��ڵ�λ�����Ҵ�������Ҳ��������˽���Ͷ�ʣ��������Ȳ�����ֵ�ռ�����۱Ⱦ�Ҫ���ڹ����г�������δ������ĺ��⹺�������Ѿ��������Ǹ�ԣ�ײ㣬������40���Ҿ߱�һ���ľ��û����Ĺ����в��׼����𲽳�Ϊ������������ײ����Ⱥ�ص�������¼����棺Ͷ����ʶ��ǿ�ҡ��󲿷�����������������Ů�Ľ������⡢���õľ��û���Ը���˽Ⲣ������������������ϼ��㣬��������Ŀ���������Ⱥ��λ�ڴˡ�Ŀ�����ܹ�ͨ�����������������ͻ���ͨ������";
		TextView detail = (TextView)findViewById(R.id.detail);
		detail.setText(detail_txt);
		
	}
}
