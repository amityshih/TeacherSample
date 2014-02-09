package com.HelloSensor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class HelloSensor extends Activity {
	//5個範例的選單名稱和應用程式Class
	private Object[] activities = { 
		"Compass",				CompassDemo.class,
		"Orientation",			OrientationDemo.class,
		"Accelerometer",		AccelerometerDemo.class,
		"Magnetic Field",		MagneticFieldDemo.class,	
		"Temperature",			TemperatureDemo.class,
	};
	//HelloSensor主程式
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//建立5個範例選單名稱的陣列list
		CharSequence[] list = new CharSequence[activities.length / 2];
		for (int i = 0; i < list.length; i++) {
			list[i] = (String)activities[i * 2];
		}
		//將5個範例選單名稱安置在listView
		ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, list);
		ListView listView = (ListView)findViewById(R.id.ListView01);
		listView.setAdapter(adapter);
		//按下選單名稱指向相關的應用程式Class
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(HelloSensor.this, (Class<?>)activities[position * 2 + 1]);
				startActivity(intent);
			}
		});
	}
}
