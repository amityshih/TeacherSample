package com.SelectionWidgetsSlidingDrawer;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class SelectionWidgetsSlidingDrawer extends Activity
{
		Button btn1;
		Button btn2;
		TextView label1;
		TextView label2;
		TextView label3;
		SlidingDrawer myDrawer;
		
		@Override
		public void onCreate(Bundle savedInstanceState)
		{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.main);
				myDrawer = (SlidingDrawer)findViewById(R.id.drawer);
				btn1 = (Button)findViewById(R.id.btn1);
				btn2 = (Button)findViewById(R.id.btn2);
				label1 = (TextView)findViewById(R.id.label1);
				label2 = (TextView)findViewById(R.id.label2);
				label3 = (TextView)findViewById(R.id.label3);
				
				btn1.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Date dt = new Date();
						String now = dt.toLocaleString();						
						label1.setText("111 - Hola amigos " + now);
						label2.setText("222 - Hola amigos " + now) ;
						label3.setText("333 - Hola amigos " + now);
											
					}					
				});

				btn2.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						myDrawer.animateClose();					
					}					
				});
				
		}
} 
