package com.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;

public class EditActivity extends Activity {
	//EditActivity主程式
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_activity);
		//設定字串陣列-adapter
		ArrayAdapter<CharSequence> adapter = 
			ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_dropdown_item_1line);
		//具自動提示字串的選單(單項)-AutoCompleteTextView
		AutoCompleteTextView autoCompleteTextView = 
			(AutoCompleteTextView)findViewById(R.id.AutoCompleteTextView01);
		autoCompleteTextView.setAdapter(adapter);
		//具自動提示字串的選單(多項)-MultiAutoCompleteTextView
		MultiAutoCompleteTextView multiAutoCompleteTextView = 
			(MultiAutoCompleteTextView)findViewById(R.id.MultiAutoCompleteTextView01);
		multiAutoCompleteTextView.setAdapter(adapter);
		multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		//設定字串陣列-adapter_spinner
		ArrayAdapter<CharSequence> adapter_spinner = 
			ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_dropdown_item_1line);
		//自訂下拉選單-Spinner
		adapter_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spinner = (Spinner)findViewById(R.id.Spinner01);
		spinner.setAdapter(adapter_spinner);
	}
}
