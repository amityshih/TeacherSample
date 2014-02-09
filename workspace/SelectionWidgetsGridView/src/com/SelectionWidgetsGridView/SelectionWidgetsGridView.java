package com.SelectionWidgetsGridView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
public class SelectionWidgetsGridView extends Activity implements OnItemClickListener  {
TextView selection;
String[] items = { "this", "is", "a",
	         "really", "really2", "really3",
	         "really4", "really5", "silly", "list" };
@Override
public void onCreate(Bundle icicle) {
	super.onCreate(icicle);
		setContentView(R.layout.main);
		selection = (TextView) findViewById(R.id.selection);
		GridView g = (GridView) findViewById(R.id.grid);
		ArrayAdapter<String> aa = new ArrayAdapter<String>(
			this, android.R.layout.simple_list_item_1, items);
		g.setAdapter(aa);
		g.setOnItemClickListener(this);
	}

public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	// TODO Auto-generated method stub
	selection.setText(items[position]);
}
}
