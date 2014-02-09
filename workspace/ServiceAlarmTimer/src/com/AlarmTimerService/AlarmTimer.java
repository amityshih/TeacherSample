package com.AlarmTimerService;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class AlarmTimer extends Activity {
//KitchenTimer主程式	
	public long alarmtimer;
	
	//定義BroadcastReceiver類別KitchenTimeeReceiver廣播接收程式
	private class KitchenTimerReceiver extends BroadcastReceiver {	
		@Override
		public void onReceive(Context context, Intent intent) {
			Toast toast = Toast.makeText(getApplicationContext(), "Time over!", Toast.LENGTH_LONG);
			toast.show();
	    	MediaPlayer mp = MediaPlayer.create(AlarmTimer.this, R.raw.alarm);
			try {
				mp.start();
			} catch (Exception e) {
				//例外發生時處理
			}
		kitchenTimerService.schedule(alarmtimer);
		}
	}
	
	//宣告Service程式kitchenTimerService
	private AlarmTimerService kitchenTimerService;
	
	//宣告BroadcastReceiver程式receiver
	private final KitchenTimerReceiver receiver = new KitchenTimerReceiver();
	
	//宣告ServiceConnection程式serviceConnection
	private ServiceConnection serviceConnection = new ServiceConnection() {	
		public void onServiceConnected(ComponentName className, IBinder service) {
			kitchenTimerService = ((AlarmTimerService.KitchenTimerBinder)service).getService();
		}	
		public void onServiceDisconnected(ComponentName className) {
			kitchenTimerService = null;
		}	
	};
	
	
	//建立和執行KitchenTimer主程式
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //用戶設定alarm time時間
		final TimePicker timePicker = (TimePicker)findViewById(R.id.TimePicker01);
		timePicker.setIs24HourView(true);
		timePicker.setCurrentHour(0);
		timePicker.setCurrentMinute(1);	
		Button button = (Button)findViewById(R.id.Button01);
		button.setOnClickListener(new View.OnClickListener() {	
			public void onClick(View view) {
				long hour = timePicker.getCurrentHour();
				long min = timePicker.getCurrentMinute();
				alarmtimer = (hour * 60 + min) * 60 * 1000;
				//將alarmtimer告知Service程式kitchenTimerService的schedule
				kitchenTimerService.schedule(alarmtimer);
				moveTaskToBack(true);
			}		
		});	
		
		//啓動服務程式KitchenTimerService
		Intent intent = new Intent(this, AlarmTimerService.class);
		startService(intent);
		//註冊廣播接收receiver
		IntentFilter filter = new IntentFilter(AlarmTimerService.ACTION);
		registerReceiver(receiver, filter);	
		
		//綁縛(Bind)服務程式KitchenTimerService
		bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
		//鬆綁(Unbind)服務程式KitchenTimerService
		unbindService(serviceConnection);
		//綁縛(Bind)服務程式KitchenTimerService
		bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
	}
	
	
	//結束時要交還資訊，Unbind Service, Unregister Receiver, Stop Service
	@Override
	public void onDestroy() {
		super.onDestroy();
		unbindService(serviceConnection); 	//Unbind service
		unregisterReceiver(receiver); 		//Unregister Receiver
		kitchenTimerService.stopSelf(); 	//Stop Service
	}
}