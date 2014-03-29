package com.SelectionWidgetsListSpinner;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
public class SelectionWidgetsListSpinner extends Activity {

TextView selection;
TextView selection2;
String[] items = { "this", "is", "a",
		  			"really", "really2", "really3",
		  			"really4", "really5", "silly", "list" };

String[] items2 = { "selection", "is", "Listview",
		  			"Spinner", "good", "bad",
		  			"fine", "rar", "zip", "exe" };

@Override
public void onCreate(Bundle icicle) {
	super.onCreate(icicle);
	setContentView(R.layout.main);
	
	selection = (TextView) findViewById(R.id.selection);
	Spinner spin = (Spinner) findViewById(R.id.spinner);
	
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
