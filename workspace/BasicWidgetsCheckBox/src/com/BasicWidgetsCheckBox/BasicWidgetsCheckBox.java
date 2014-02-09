package com.BasicWidgetsCheckBox;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.CheckBox;
public class BasicWidgetsCheckBox extends Activity {
	CheckBox chkCream;
	CheckBox chkSugar;
	Button btnPay;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//binding XMl controls with Java code
		chkCream = (CheckBox)findViewById(R.id.chkCream);
		chkSugar = (CheckBox)findViewById(R.id.chkSugar);
		btnPay = (Button) findViewById(R.id.btnPay);
		//LISTENER: wiring button-events-&-code
		btnPay.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String msg = "Coffee ";
				if (chkCream.isChecked()) {
					msg += " & cream ";
				}
				if (chkSugar.isChecked()){
					msg += " & Sugar";
				}
				Toast.makeText(getApplicationContext(),	msg, Toast.LENGTH_SHORT).show();
				//go now and compute cost...
				}//onClick
				});
			}//onCreate
		}//class
