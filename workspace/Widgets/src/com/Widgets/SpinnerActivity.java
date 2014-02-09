package com.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class SpinnerActivity extends Activity {
	public Spinner spinner;
	//SpinnerActivity主程式
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner_activity);
		spinner = (Spinner)findViewById(R.id.Spinner01);
		//設定字串陣列-adapter
		ArrayAdapter<CharSequence> adapter = 
			ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
		//自訂下拉選單-Spinner
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
	}
	//下拉選單的選項處理-onItemSelected()
	public class MyOnItemSelectedListener implements OnItemSelectedListener {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			Toast.makeText(parent.getContext(), "你所選的行星是-" + parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
		}
		public void onNothingSelected(AdapterView<?> parent) {
			// Do nothing.    
		}
	}
}

