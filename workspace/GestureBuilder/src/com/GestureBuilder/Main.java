package com.GestureBuilder;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Main extends Activity
{
	private EditText editText;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		GestureOverlayView overlay = (GestureOverlayView) findViewById(R.id.gestures_overlay);
		overlay.addOnGestureListener(new GesturesProcessor()); //建立手勢所需要的監聽事件，在開始繪製手勢、繪製的過程、繪製結束與取消繪製時都會呼叫該事件件中的方法，其中GesturesProcessor是一個事件類別
		editText = (EditText) findViewById(R.id.gesture_name);
	}

	private class GesturesProcessor implements GestureOverlayView.OnGestureListener
	{
		public void onGestureEnded(final GestureOverlayView overlay, MotionEvent event)
		{
			final Gesture gesture = overlay.getGesture();
			View gestureView = getLayoutInflater().inflate(R.layout.gesture, null);
			final TextView textView = (TextView) gestureView.findViewById(R.id.textview);
			ImageView imageView = (ImageView) gestureView.findViewById(R.id.imageview);

			//取得繪製的手勢影像(128 * 128)，0xFFFFFF00表示影像中手勢的顏色(黃色)
			Bitmap bitmap = gesture.toBitmap(128, 128, 8, 0xFFFFFF00);
			//從ImageView元件中顯示手勢圖形
			imageView.setImageBitmap(bitmap);
			
			textView.setText("手勢名：" + editText.getText());

			new AlertDialog.Builder(Main.this).setView(gestureView)
					.setPositiveButton("保存", new OnClickListener()
					{

						public void onClick(DialogInterface dialog, int which)
						{
							GestureLibrary store = GestureLibraries.fromFile("/sdcard/mygestures");

							store.addGesture(textView.getText().toString(), gesture);
							//保存手勢檔
							store.save();
						}
					}).setNegativeButton("取消", null).show();
		}

		public void onGestureCancelled(GestureOverlayView overlay,
				MotionEvent event)
		{
		}

		@Override
		public void onGesture(GestureOverlayView overlay, MotionEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onGestureStarted(GestureOverlayView overlay,
				MotionEvent event) {
			// TODO Auto-generated method stub
			
		}
	}
}