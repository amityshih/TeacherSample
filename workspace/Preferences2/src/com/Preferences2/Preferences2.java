package com.Preferences2;

import java.util.Date;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;

public class Preferences2 extends Activity {

	public static final String MYPREFS = "MySharedPreferences001";
	//this data values describe a typical customer record
	String custName = "n.a.";
	int    custAge = 0;
	float  custCredit = 0;
	long   custNumber = 0;
	String custDateLastCall;
	
	TextView captionBox;
	EditText txtPref;
	final int mode = Activity.MODE_PRIVATE;
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        txtPref = (EditText)findViewById(R.id.txtPref);      
        captionBox = (TextView) findViewById(R.id.captionBox);       
        captionBox.setText("SharedPreference Container: \n\n"+
        		        "we are working on customer Macarena \n" +
        		        "fake an interruption, press 'Back Button' \n" +
        		        "re-execute the application.");
        
        //create a reference to the shared preferences object
        int mode = Activity.MODE_PRIVATE;
        SharedPreferences mySharedPreferences = getSharedPreferences(MYPREFS, mode);
        //is there an existing Preferences from previous executions of this app?
        if (mySharedPreferences != null && mySharedPreferences.contains("custName")) {
            //object and key found, show all saved values 
            showSavedPreferences();            
        }
        else
        {
        	txtPref.setText("nada");
        }        
    }//onCreate
    

    @Override
	  protected void onPause() {
     //warning: activity is on last state of visibility!
     //on the edge of been killed! Better save current state in Preference object
     savePreferences();
	   super.onPause();
	  }
 

    protected void savePreferences(){
    	//create the shared preferences object    	
    	SharedPreferences mySharedPreferences = getSharedPreferences(MYPREFS, mode);    	
        
    	//obtain an editor to add data to (my)SharedPreferences object
    	SharedPreferences.Editor myEditor = mySharedPreferences.edit();
    	
    	//put some <key/value> data in the preferences object
    	myEditor.putString("custName", "Maria Macarena");
    	myEditor.putInt("custAge", 21);
    	myEditor.putFloat("custCredit", 1500000.00F);
    	myEditor.putLong("custNumber", 9876543210L);
    	myEditor.putString("custDateLastCall", new Date().toLocaleString());
    	
    	myEditor.commit();	
    }//savePreferences
    

    public void showSavedPreferences() {
    	//retrieve the SharedPreferences object
    	
    	SharedPreferences mySharedPreferences = getSharedPreferences(MYPREFS, mode);
    	
    	//extract the <key/value> pairs, use default param for missing data
    	custName = mySharedPreferences.getString("custName", "defNameValue");
    	custAge = mySharedPreferences.getInt("custAge", 18);
    	custCredit = mySharedPreferences.getFloat("custCredit", 1000.00F);
    	custNumber = mySharedPreferences.getLong("custNumber", 1L);
    	custDateLastCall = mySharedPreferences.getString("custDateLastCall",
    											new Date().toLocaleString());
    	//show saved data on screen
    	String msg = "name: " + custName + "\nAge: " + custAge + 
    	             "\nCredit: " + custCredit + 
    	             "\nLastCall: " + custDateLastCall; 
    	txtPref.setText(msg);
    }//loadPreferences
    
}//Preferences1 
