package com.HelloGesture;

import java.util.ArrayList;
import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.gesture.GestureOverlayView.OnGestureListener;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.GestureOverlayView.OnGesturingListener;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class HelloGesture extends Activity {
	//HelloGesture主程式
	@Override
	public void onCreate(Bundle savedInstanceState) { //建立HelloGesture應用程式
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main); //顯示main.xml畫面。
		TextView textView = (TextView)findViewById(R.id.TextView01); //從顯示畫面模板中取得TextView01，定義TextView類別，實作變數textView。
		textView.setText(R.string.app_description); //在顯示文字欄位TextView01上放上訊息。
		
		
		//GestureLibrary-登錄Gesture的圖書庫
		final GestureLibrary gl = GestureLibraries.fromPrivateFile(this, "gestures"); //實作一個GestureLibrary類別變數gl，登錄Gesture的圖書庫gl，定義名稱是"gestures"。
		//GestureOverlayView-Gesture輸入的透明性重疊層
		GestureOverlayView gov = (GestureOverlayView)findViewById(R.id.GestureOverlayView01); //從顯示畫面模板中取得GestureOverlayView01，定義GestureOverlayView類別，實作變數gov，gov是Gesture輸入的透明性重疊層。
		//實作OnGestureListener監聽功能
		
		gov.addOnGestureListener(new OnGestureListener() { 	
			public void onGestureStarted(GestureOverlayView overlay, MotionEvent event) {
				Toast.makeText(HelloGesture.this, "onGestureStarted", Toast.LENGTH_SHORT).show(); 
			}		
			public void onGestureEnded(GestureOverlayView overlay, MotionEvent event) {
				Toast.makeText(HelloGesture.this, "onGestureEnded", Toast.LENGTH_SHORT).show();
			}	
			public void onGestureCancelled(GestureOverlayView overlay, MotionEvent event) {
				Toast.makeText(HelloGesture.this, "onGestureCancelled", Toast.LENGTH_SHORT).show();
			}	
			public void onGesture(GestureOverlayView overlay, MotionEvent event) {
				Toast.makeText(HelloGesture.this, "onGesture", Toast.LENGTH_SHORT).show();
			}
		});
		//實作OnGesturePerformedListener監聽功能
		
		gov.addOnGesturePerformedListener(new OnGesturePerformedListener() {
			public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
				if (gl.getGestureEntries().size() == 0) { //從GestureLibrary取得所有Gesture輸入次數，審查是否為零？
					gl.addGesture("First", gesture);
					gl.save();
					Toast.makeText(HelloGesture.this, "First", Toast.LENGTH_SHORT).show();
				} else {
					//呼叫GestureLibrary.recognize(gesture)取得predictions
					ArrayList<Prediction> predictions = gl.recognize(gesture); // //Gesture輸入次數不是零時，呼叫GestureLibrary.recognize(gesture)取得predictions。
					//Log.v("Gesture", "predictions.size:" + predictions.size());
					for (Prediction p : predictions) {
						//Log.v("Gesture", "Prediction name:" + p.name + " score:" + p.score);
						Toast.makeText(HelloGesture.this, "score:" + p.score, Toast.LENGTH_SHORT).show(); //使用Toast警示方法來顯示predictions數值。
					}
				}
			}		
		});
		//實作OnGesturingListener監聽功能
		gov.addOnGesturingListener(new OnGesturingListener() {
			public void onGesturingEnded(GestureOverlayView overlay) {
				Toast.makeText(HelloGesture.this, "onGesturingEnded", Toast.LENGTH_SHORT).show();
			}
			public void onGesturingStarted(GestureOverlayView overlay) {
				Toast.makeText(HelloGesture.this, "onGesturingStarted", Toast.LENGTH_SHORT).show();
			}		
		});
	}
}