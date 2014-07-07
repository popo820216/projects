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
		
		String summary_txt = "库格牧场一套洋房，跌至70万美金";
		TextView summary = (TextView)findViewById(R.id.text_summary);
		summary.setText(summary_txt);
		
		ImageView image_summary = (ImageView)findViewById(R.id.image_summary);
		image_summary.setBackgroundResource(R.drawable.pic);
		
		String detail_txt = "针对中国人日益增强的投资意识和赴美移民的需求提高的情况下，近年来在美购置房产的需求量越来越大，购置美国房产的中国人越来越多，门槛也越来越低。以往在海外购置房产等行为通常基于海外有亲戚朋友，并且自身经济条件良好的情况下才可实现，所以一直市场行情并无较大提升。随着近年来国内房价经过一段的快速攀升后，房价进入了相对的稳定期，并且国内房贷收紧也使得购房炒房的成本日益增高，再加上人民币对内贬值对外升值的大背景下，越来越多的购房者将眼光投到的海外市场，反观美国的房产市场价格还相对处于低位，并且贷款政策也便于外国人进行投资，与国内相比不论升值空间和租售比均要好于国内市场。所以未来几年的海外购房主力已经不单单是富裕阶层，年龄在40左右具备一定的经济基础的国内中产阶级会逐步成为主力军，这个阶层的人群特点具有以下几方面：投资意识较强烈、大部分有移民倾向、重视子女的教育问题、良好的经济基础愿意了解并尝试新生事物。基于以上几点，此套软件的开发受众人群定位在此。目的是能够通过此套软件建立起与客户沟通的桥梁";
		TextView detail = (TextView)findViewById(R.id.detail);
		detail.setText(detail_txt);
		
	}
}
