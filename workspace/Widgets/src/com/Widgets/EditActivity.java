package com.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;

public class EditActivity extends Activity {
	//EditActivity�D�{��
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_activity);
		//�]�w�r��}�C-adapter
		ArrayAdapter<CharSequence> adapter = 
			ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_dropdown_item_1line);
		//��۰ʴ��ܦr�ꪺ���(�涵)-AutoCompleteTextView
		AutoCompleteTextView autoCompleteTextView = 
			(AutoCompleteTextView)findViewById(R.id.AutoCompleteTextView01);
		autoCompleteTextView.setAdapter(adapter);
		//��۰ʴ��ܦr�ꪺ���(�h��)-MultiAutoCompleteTextView
		MultiAutoCompleteTextView multiAutoCompleteTextView = 
			(MultiAutoCompleteTextView)findViewById(R.id.MultiAutoCompleteTextView01);
		multiAutoCompleteTextView.setAdapter(adapter);
		multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		//�]�w�r��}�C-adapter_spinner
		ArrayAdapter<CharSequence> adapter_spinner = 
			ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_dropdown_item_1line);
		//�ۭq�U�Կ��-Spinner
		adapter_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spinner = (Spinner)findViewById(R.id.Spinner01);
		spinner.setAdapter(adapter_spinner);
	}
}
