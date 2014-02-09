package com.PreferencePractice;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Bmi extends Activity {
//	private static final String TAG = "Bmi";
	private static final String TAG = Bmi.class.getSimpleName();
	
	public static final String PREF = "BMI_PREF";
    public static final String PREF_HEIGHT = "BMI_HEIGHT";
    public static final String PREF_WEIGHT = "BMI_WEIGHT";
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d(TAG, "find Views");
        findViews();
        Log.d(TAG, "set Listensers");
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
            Bundle bundle = new Bundle();
            bundle.putString("KEY_HEIGHT", field_height.getText().toString());
            bundle.putString("KEY_WEIGHT", field_weight.getText().toString());
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };   
   
}




