package com.Widgets;

import java.util.Calendar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClockActivity extends Activity {
	//ClockActivity主程式
	public Calendar mCalendar;
	public int mHour;
	public int mMinutes;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clock_activity);		
		
		final TextView mTextView01 = (TextView)findViewById(R.id.TextView01);
		final Button mButton01 = (Button)findViewById(R.id.Button01);
		//按下[簽到時間]按鈕
		mButton01.setOnClickListener(new Button.OnClickListener() {		
			public void onClick(View v) {
				//取得系統時間time
				long time = System.currentTimeMillis();
				//建立日曆mCalendar
				final Calendar mCalendar = Calendar.getInstance();
				mCalendar.setTimeInMillis(time);
				//讀到當時的時/分
				mHour = mCalendar.get(Calendar.HOUR);
				mMinutes = mCalendar.get(Calendar.MINUTE);
				mTextView01.setText("早安，你的簽到時間: "+mHour+" : "+mMinutes);
			}
		});
	}
}
