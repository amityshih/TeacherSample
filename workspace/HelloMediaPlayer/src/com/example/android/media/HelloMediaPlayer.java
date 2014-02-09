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
	//6�ӽd�Ҫ����W�٩M���ε{��Class
	private Object[] activities = {
			"MediaPlayer_Audio_Local", 	MediaPlayerAudio.class,
			"MediaPlayer_Audio_Stream",	MediaPlayerAudio.class,
			"MediaPlayer_Audio_Resource",	MediaPlayerAudio.class,
			"MediaPlayer_Video_Local",	MediaPlayerVideo.class,
			"MediaPlayer_Video_Stream",	MediaPlayerVideo.class,
			"MediaPlayer_Video_Resource",	MediaPlayerVideo.class,
		};
	//HelloMediaPlayer�D�{��
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//�إ�6�ӽd�ҿ��W�٪��}�Clist
		CharSequence[] list = new CharSequence[activities.length / 2];
		for (int i = 0; i < list.length; i++) {
			list[i] = (String)activities[i * 2];
		}
		//�N6�ӽd�ҿ��W�٦w�m�blistView
		ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, list);
		ListView listView = (ListView)findViewById(R.id.ListView01);
		listView.setAdapter(adapter);
		//���U���W�٫��V���������ε{��Class
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//���d�һݭn�ǰemedia�����e
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