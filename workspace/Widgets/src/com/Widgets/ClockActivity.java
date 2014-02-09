package com.Widgets;

import java.util.Calendar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClockActivity extends Activity {
	//ClockActivity�D�{��
	public Calendar mCalendar;
	public int mHour;
	public int mMinutes;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clock_activity);		
		
		final TextView mTextView01 = (TextView)findViewById(R.id.TextView01);
		final Button mButton01 = (Button)findViewById(R.id.Button01);
		//���U[ñ��ɶ�]���s
		mButton01.setOnClickListener(new Button.OnClickListener() {		
			public void onClick(View v) {
				//���o�t�ήɶ�time
				long time = System.currentTimeMillis();
				//�إߤ��mCalendar
				final Calendar mCalendar = Calendar.getInstance();
				mCalendar.setTimeInMillis(time);
				//Ū���ɪ���/��
				mHour = mCalendar.get(Calendar.HOUR);
				mMinutes = mCalendar.get(Calendar.MINUTE);
				mTextView01.setText("���w�A�A��ñ��ɶ�: "+mHour+" : "+mMinutes);
			}
		});
	}
}
