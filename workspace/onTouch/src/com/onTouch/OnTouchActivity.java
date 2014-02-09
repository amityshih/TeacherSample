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
				// ����Q�I���ɡAflag�]��true
				//����g�bonClick�ƥ�
				return false;
			} 
		});
 	}
 
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (flag) {
			// flag��true�Y����Q�I��ɡA���沾�ʱ���ާ@
			int x = (int) event.getX();
			int y = (int) event.getY();	
			xx.setText(Integer.toString(x));
			yy.setText(Integer.toString(y));
			//Toast.makeText(getBaseContext(), "x�y��" + Integer.toString(x), Toast.LENGTH_SHORT).show();
			//Toast.makeText(getBaseContext(), "y�y��" + Integer.toString(y), Toast.LENGTH_SHORT).show();
			// �o��X�AY�y��
			LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, x , y);
			// �|�ѼƤ��O���e�A���AX�AY�y�СAwrap_conent���ھڤ��e�۰ʽվ�
			tv.setLayoutParams(params);
			// �]�m�̲צ�m 
		}
		if (event.getAction() == MotionEvent.ACTION_UP) {
			// ������}�ù��ɡA��flag�]��false
			flag = false;
		} 
		return super.onTouchEvent(event);
 
	}
}
