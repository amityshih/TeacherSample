package com.PreferencePractice;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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
        restorePrefs();
        Log.d(TAG, "set Listensers");
        setListeners();
    }

    private void restorePrefs()
    {
        SharedPreferences settings = getSharedPreferences(PREF, 0);
        String pref_height = settings.getString(PREF_HEIGHT, "");
        String pref_weight = settings.getString(PREF_WEIGHT, "");
        if(! "".equals(pref_height) && ! "".equals(pref_weight))
        {
                field_height.setText(pref_height);
                field_weight.setText(pref_weight);
                field_weight.requestFocus();
        }
    } 
    
    @Override
    protected void onPause(){
            super.onPause();
            // Save user preferences. use Editor object to make changes.
            SharedPreferences settings = getSharedPreferences(PREF, 0);
            settings.edit()
              .putString(PREF_HEIGHT, field_height.getText().toString())
              .putString(PREF_WEIGHT, field_weight.getText().toString())
              .commit();
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




