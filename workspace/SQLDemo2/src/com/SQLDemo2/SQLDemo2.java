// WARNING. for the time being run this app using SDK1.5 target
// as the app fails on SDK1.6 (unable to find sd card...)

package com.SQLDemo2;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.widget.Toast;

public class SQLDemo2 extends Activity {
	SQLiteDatabase db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        try {        	
            db =  this.openOrCreateDatabase(
    				"myfriendsDB2",            		
    				 MODE_PRIVATE, 
    				 null);
        	db.close();
        	Toast.makeText(this, "All done!", 1).show();
        }
        catch (SQLiteException e) {
        	 Toast.makeText(this, e.getMessage(), 1).show(); 
        }
        catch (Exception e) {
            	 Toast.makeText(this, e.getMessage(), 1).show();   
        }
        

    }
}