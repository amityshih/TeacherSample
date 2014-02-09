package com.SelectionWidgetsList;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SelectionWidgetsList extends ListActivity {
	TextView selection;
	String[] items = { "this", "is", "a", "really",
		          "really2", "really3","really4",
		          "really5", "silly", "list" };
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setListAdapter(new ArrayAdapter<String>(
			        this,
			        android.R.layout.simple_list_item_1, items));
		selection=(TextView)findViewById(R.id.selection);
		}
		@Override
		protected void onListItemClick(ListView l, View v, int position, long id) {
			super.onListItemClick(l, v, position, id);
			String text = " position:" + position + " " + items[position];
			selection.setText(text);
		}
	}
