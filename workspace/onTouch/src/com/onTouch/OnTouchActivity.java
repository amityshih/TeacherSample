package com.onTouch;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.Toast;

public class OnTouchActivity extends Activity {

	/** Called when the activity is first created. */
	TextView tv;
	boolean flag = false;
	EditText xx;
	EditText yy;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		xx = (EditText) findViewById(R.id.xx);
		yy = (EditText) findViewById(R.id.yy);
		tv = (TextView) findViewById(R.id.tv);
		
		tv.setOnTouchListener(new OnTouchListener() {
 
			public boolean onTouch(View v, MotionEvent event) {
				flag = true;
				// 當控制項被點中時，flag設為true
				//不能寫在onClick事件中
				return false;
			} 
		});
 	}
 
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (flag) {
			// flag為true即控制項被點到時，執行移動控制項操作
			int x = (int) event.getX();
			int y = (int) event.getY();	
			xx.setText(Integer.toString(x));
			yy.setText(Integer.toString(y));
			//Toast.makeText(getBaseContext(), "x座標" + Integer.toString(x), Toast.LENGTH_SHORT).show();
			//Toast.makeText(getBaseContext(), "y座標" + Integer.toString(y), Toast.LENGTH_SHORT).show();
			// 得到X，Y座標
			LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, x , y);
			// 四參數分別為寬，高，X，Y座標，wrap_conent為根據內容自動調整
			tv.setLayoutParams(params);
			// 設置最終位置 
		}
		if (event.getAction() == MotionEvent.ACTION_UP) {
			// 手指離開螢幕時，把flag設為false
			flag = false;
		} 
		return super.onTouchEvent(event);
 
	}
}
