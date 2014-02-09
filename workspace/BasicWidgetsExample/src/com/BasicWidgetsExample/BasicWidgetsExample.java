package com.BasicWidgetsExample;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// "LOGIN" - a gentle introduction to UI controls
public class BasicWidgetsExample extends Activity {
	TextView labelUserName;
	EditText txtUserName;
	Button btnBegin;
@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//binding the UI's controls defined in "main.xml" to Java code
		labelUserName = (TextView) findViewById(R.id.labelUserName);
		txtUserName = (EditText) findViewById(R.id.txtUserName);
		btnBegin = (Button) findViewById(R.id.btnBegin);
		//LISTENER: wiring the button widget to events-&-code
		btnBegin.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			String userName = txtUserName.getText().toString();
				if (userName.compareTo("Maria Macarena")==0){
					labelUserName.setText("OK, please wait...");
					Toast.makeText(getApplicationContext(),
						"Bienvenido " + userName,
						Toast.LENGTH_SHORT).show();
				}
				Toast.makeText(getApplicationContext(),
					"Bienvenido " + userName,
					Toast.LENGTH_SHORT).show();
				}
					});// onClick
			}//onCreate
		}//class

