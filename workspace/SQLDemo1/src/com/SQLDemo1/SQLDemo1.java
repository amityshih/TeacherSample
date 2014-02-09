package com.SQLDemo1;

import android.app.Activity;
import android.database.sqlite.*;
import android.os.Bundle;
import android.widget.Toast;

public class SQLDemo1 extends Activity {
	SQLiteDatabase db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        //---------------------------------------------------------------------       
        // creating a SQLITE database.
        // Version1 uses the method: SQLiteOpenDatabase(filePath, cursor, flag)
        // where filePath is a complete destination of the form 
        //     "data/data/<namespace>/<databaseName>"
        //     "/sdcard/<databasename>"
        // ignore cursor param, flag could be: SQLiteDatabase.CREATE_IF_NECESSARY
        // SQLiteDatabase.OPEN_READWRITE, or SQLiteDatabase.OPEN_READONLY.
        //----------------------------------------------------------------------
        try {        	
        	db = SQLiteDatabase.openDatabase(
    				"data/data/com.SQLDemo1/myfriendsDB",    		 
        			//"sdcard/myfriendsDB",
    				null,
    				SQLiteDatabase.CREATE_IF_NECESSARY);
        	db.close();
        	Toast.makeText(this, "All done!", 1).show();
        }
        catch (SQLiteException e) {
        	 Toast.makeText(this, e.getMessage(), 1).show();        	
        }
    }
}