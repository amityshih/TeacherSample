package com.SelectionWidgetsListSpinner;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class SelectionWidgetsListSpinner extends Activity {
	SQLiteDatabase db;
TextView selection;
TextView selection2;

String[] items;
String[] items2;

private void openDatabase() {
    try {        	
    	db = SQLiteDatabase.openDatabase(
    			"sdcard/DBTest/mydb.db",    		 
				null,
				SQLiteDatabase.CREATE_IF_NECESSARY) ;       	
    	
    	Toast.makeText(this, "DB was opened!", 1).show();
    }
    catch (SQLiteException e) {
    	 Toast.makeText(this, e.getMessage(), 1).show();        	
    }
}//createDatabase  

private void useCursor1() {
		try {
		
			// obtain a list of <recId, name, phone> from DB
			String[] columns = {"name", "mobilephone" };
			
			Cursor c = db.query("addressbook", columns, 
					            null, null, null, null, null);
			
			int theTotal = c.getCount();
			items = new String[theTotal];
			items2 = new String[theTotal];
			Toast.makeText(this, "Total6: " + theTotal, 1).show();
			
			int idCol =0;
			int nameCol = c.getColumnIndex("name");
			int phoneCol = c.getColumnIndex("mobilephone");

			while (c.moveToNext()) {	
				items[idCol]=c.getString(nameCol);
				items2[idCol]=c.getString(phoneCol);
				idCol++;
			}			
		} catch (Exception e) {
			Toast.makeText(this, e.getMessage(), 1).show();
		}
  }//useCursor1    


@Override
public void onCreate(Bundle icicle) {
	super.onCreate(icicle);
	setContentView(R.layout.main);
	
	selection = (TextView) findViewById(R.id.selection);
	Spinner spin = (Spinner) findViewById(R.id.spinner);
	openDatabase();		//open (create if needed) database
	useCursor1();		//retrieve rows from a table
	spin.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
	      public void onItemSelected(AdapterView<?> parent, View view, int position, long id )
	      {
	    	  selection.setText(items[position]);;
	      }
	 
	      @Override
	      public void onNothingSelected(AdapterView<?> arg0) {
	        // TODO Auto-generated method stub
	    	  selection.setText("");
	      }
	    });
	
	ArrayAdapter<String> aa = new ArrayAdapter<String>(
		this, android.R.layout.simple_spinner_item, items);
	aa.setDropDownViewResource(
		android.R.layout.simple_spinner_dropdown_item);
	spin.setAdapter(aa);
	
	selection2 = (TextView) findViewById(R.id.selection2);
	Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
	
	spin2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
	      public void onItemSelected(AdapterView<?> parent, View view, int position, long id )
	      {
	    	  selection2.setText(items2[position]);;
	      }
	 
	      @Override
	      public void onNothingSelected(AdapterView<?> arg0) {
	        // TODO Auto-generated method stub
	    	  selection2.setText("");
	      }
	    });
	
	ArrayAdapter<String> aa2 = new ArrayAdapter<String>(
		this, android.R.layout.simple_spinner_item, items2);
	aa2.setDropDownViewResource(
		android.R.layout.simple_spinner_dropdown_item);
	spin2.setAdapter(aa2);	
	}
}
