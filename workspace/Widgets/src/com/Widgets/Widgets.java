package com.Widgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Widgets extends Activity {
	//12個範例的選單名稱和應用程式Class
	private Object[] activities = {
		"Button",				ButtonActivity.class,
		"Edit",					EditActivity.class,
		"Clock",				ClockActivity.class,
		"Progress",				ProgressActivity.class,
		"Date/Time Picker",		DateTimePickerActivity.class,
		"Chronometer",			ChronometerActivity.class,
		"Popup",				PopupActivity.class,
		"SpinnerSelect",		SpinnerActivity.class,
		"GridView",				GridActivity.class,
		"Video",				VideoActivity.class,
		"Gallery",				GalleryActivity.class,
		"Misc",					MiscActivity.class,
	};
	//Widgets主程式
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//建立12個範例選單名稱的陣列list
		CharSequence[] list = new CharSequence[activities.length / 2];
		for (int i = 0; i < list.length; i++) {
			list[i] = (String)activities[i * 2];
		}
		//將12個範例選單名稱安置在listView
		ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, list);
		ListView listView = (ListView)findViewById(R.id.ListView01);
		listView.setAdapter(adapter);
		//按下選單名稱指向相關的應用程式Class
		listView.setOnItemClickListener(new OnItemClickListener() {		
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {	
				Intent intent = new Intent(Widgets.this, (Class<?>)activities[position * 2 + 1]);
				startActivity(intent);
			}		
		});	
	}
}
