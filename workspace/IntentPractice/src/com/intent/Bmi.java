package com.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Bmi extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViews();
        setListeners();
    }

    private Button calcbutton;
    private EditText field_height;
    private EditText field_weight;
    
    private void findViews(){
    	calcbutton = (Button)findViewById(R.id.submit);
    	field_height = (EditText)findViewById(R.id.height);
        field_weight = (EditText)findViewById(R.id.weight);
    }

    //Listen for button clicks
    private void setListeners(){
    	calcbutton.setOnClickListener(calcBMI);
    }
    
    private Button.OnClickListener calcBMI = new Button.OnClickListener() { 
        public void onClick(View v) {
      	
        	//Switch to report page
            Intent intent = new Intent();
            intent.setClass(Bmi.this, Report.class);
            startActivity(intent);
        }
    };
    
  
    
    
}