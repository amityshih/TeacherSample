package com.example.android.media;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class HelloMediaPlayer extends Activity {
	private static final String MEDIA = "media";    
	private static final int LOCAL_AUDIO = 1;    
	private static final int STREAM_AUDIO = 2;    
	private static final int RESOURCES_AUDIO = 3;    
	private static final int LOCAL_VIDEO = 4;    
	private static final int STREAM_VIDEO = 5;    
	private static final int RESOURCES_VIDEO = 6;
	//6個範例的選單名稱和應用程式Class
	private Object[] activities = {
			"MediaPlayer_Audio_Local", 	MediaPlayerAudio.class,
			"MediaPlayer_Audio_Stream",	MediaPlayerAudio.class,
			"MediaPlayer_Audio_Resource",	MediaPlayerAudio.class,
			"MediaPlayer_Video_Local",	MediaPlayerVideo.class,
			"MediaPlayer_Video_Stream",	MediaPlayerVideo.class,
			"MediaPlayer_Video_Resource",	MediaPlayerVideo.class,
		};
	//HelloMediaPlayer主程式
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//建立6個範例選單名稱的陣列list
		CharSequence[] list = new CharSequence[activities.length / 2];
		for (int i = 0; i < list.length; i++) {
			list[i] = (String)activities[i * 2];
		}
		//將6個範例選單名稱安置在listView
		ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, list);
		ListView listView = (ListView)findViewById(R.id.ListView01);
		listView.setAdapter(adapter);
		//按下選單名稱指向相關的應用程式Class
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//選單範例需要傳送media的內容
				Intent intent = new Intent(HelloMediaPlayer.this, (Class<?>)activities[position * 2 + 1]);
				if (position == 0) intent.putExtra(MEDIA, LOCAL_AUDIO);
				if (position == 1) intent.putExtra(MEDIA, STREAM_AUDIO);
				if (position == 2) intent.putExtra(MEDIA, RESOURCES_AUDIO);
				if (position == 3) intent.putExtra(MEDIA, LOCAL_VIDEO);
				if (position == 4) intent.putExtra(MEDIA, STREAM_VIDEO);
				if (position == 5) intent.putExtra(MEDIA, RESOURCES_VIDEO);
				startActivity(intent);
			}		
		});	
	}
}