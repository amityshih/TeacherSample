package com.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressActivity extends Activity {
	//ProgressActivity�D�{��
	private ProgressBar progressBar;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.progress_activity);
		//�]�wProgressBar�O�i����
		setProgressBarVisibility(true);
		
		progressBar = (ProgressBar)findViewById(R.id.ProgressBar01);
		//�]�wHandle���O
		final Handler handler = new Handler();
		//���n�i����ܳB�z�{��-callback1
		final Runnable callback1 = new Runnable() {		
			public void run() {
				progressBar.incrementSecondaryProgressBy(1);
				setSecondaryProgress(100 * progressBar.getSecondaryProgress());
			}		
		};
		//�D�n�i����ܳB�z�{��-callback2
		final Runnable callback2 = new Runnable() {		
			public void run() {
				progressBar.incrementProgressBy(10);
				setProgress(100 * progressBar.getProgress());
				progressBar.incrementSecondaryProgressBy(-100);
				setSecondaryProgress(100 * progressBar.getSecondaryProgress());
			}		
		};
		//��ܹϧγB�z�{��-callback3
		final Runnable callback3 = new Runnable() {		
			public void run() {
				TextView textView = (TextView)findViewById(R.id.TextView01);
				textView.setVisibility(View.GONE);
				progressBar.setVisibility(View.GONE);
				ImageView imageView = (ImageView)findViewById(R.id.ImageView01);
				imageView.setImageResource(R.drawable.sakura01);
				imageView.setVisibility(View.VISIBLE);
			}	
		};
		//�إߤ@��Thread��Run
		Thread thread = new Thread() {	
			@Override
			public void run() {
				try {
					for (int i = 0; i < progressBar.getMax() / 10; i++) {
						for (int j = 0; j < progressBar.getMax(); j++) {
							Thread.sleep(20);
							handler.post(callback1);
						}
						handler.post(callback2);
					}
					handler.post(callback3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}		
		};
		thread.start();
	}
}
