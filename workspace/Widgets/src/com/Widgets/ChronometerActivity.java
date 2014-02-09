package com.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class ChronometerActivity extends Activity {
	//ChronometerActivity主程式
	private Chronometer chronometer;
	private Button button;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chronometer_activity);
		//Chronometer一開機就開始計時
		chronometer = (Chronometer)findViewById(R.id.Chronometer01);
		chronometer.start();
		//按下Button01按鈕時，Button01被設計成交替切換按鈕，可以開始計時或停止計時
		button = (Button)findViewById(R.id.Button01);
		button.setOnClickListener(new View.OnClickListener() {				
			public void onClick(View v) {
				if (button.getText().equals("Start")) {
					chronometer.start();
					button.setText("Stop");
				} else {
					chronometer.stop();
					button.setText("Start");
				}
			}		
		});
	}
}
