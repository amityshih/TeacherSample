package com.DialogBoxesToast;

import com.DialogBoxesToast.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogBoxesToast extends Activity {
    EditText xBox;
    EditText yBox;
    Button   btn1;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
       
        xBox = (EditText)findViewById(R.id.xBox);
        yBox = (EditText)findViewById(R.id.yBox);
        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		        try {
					Toast.makeText(       
							getApplicationContext(), 
							"Saludos amigos \n Hasta la vista", 
							Toast.LENGTH_LONG).show();
					
				} catch (NumberFormatException e) {
					Toast.makeText(
							getApplicationContext(), 
							e.getMessage(), 
							Toast.LENGTH_LONG).show();
				}								
			}
		});
        

    }
}