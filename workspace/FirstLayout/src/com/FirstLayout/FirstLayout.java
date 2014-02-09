package com.FirstLayout;
import java.util.Date;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class FirstLayout extends Activity {
Button btn;
@Override
public void onCreate(Bundle icicle) {
	super.onCreate(icicle);
     	setContentView(R.layout.main);
	btn = (Button) findViewById(R.id.myButton);
	btn.setOnClickListener(new OnClickListener()
	{
		
		public void onClick(View v) {
			updateTime();
		}
	});
}// onCreate
private void updateTime() {
	btn.setText(new Date().toString());
	}
}
