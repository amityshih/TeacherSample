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
	//HelloGesture�D�{��
	@Override
	public void onCreate(Bundle savedInstanceState) { //�إ�HelloGesture���ε{��
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main); //���main.xml�e���C
		TextView textView = (TextView)findViewById(R.id.TextView01); //�q��ܵe���ҪO�����oTextView01�A�w�qTextView���O�A��@�ܼ�textView�C
		textView.setText(R.string.app_description); //�b��ܤ�r���TextView01�W��W�T���C
		
		
		//GestureLibrary-�n��Gesture���ϮѮw
		final GestureLibrary gl = GestureLibraries.fromPrivateFile(this, "gestures"); //��@�@��GestureLibrary���O�ܼ�gl�A�n��Gesture���ϮѮwgl�A�w�q�W�٬O"gestures"�C
		//GestureOverlayView-Gesture��J���z���ʭ��|�h
		GestureOverlayView gov = (GestureOverlayView)findViewById(R.id.GestureOverlayView01); //�q��ܵe���ҪO�����oGestureOverlayView01�A�w�qGestureOverlayView���O�A��@�ܼ�gov�Agov�OGesture��J���z���ʭ��|�h�C
		//��@OnGestureListener��ť�\��
		
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
		//��@OnGesturePerformedListener��ť�\��
		
		gov.addOnGesturePerformedListener(new OnGesturePerformedListener() {
			public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
				if (gl.getGestureEntries().size() == 0) { //�qGestureLibrary���o�Ҧ�Gesture��J���ơA�f�d�O�_���s�H
					gl.addGesture("First", gesture);
					gl.save();
					Toast.makeText(HelloGesture.this, "First", Toast.LENGTH_SHORT).show();
				} else {
					//�I�sGestureLibrary.recognize(gesture)���opredictions
					ArrayList<Prediction> predictions = gl.recognize(gesture); // //Gesture��J���Ƥ��O�s�ɡA�I�sGestureLibrary.recognize(gesture)���opredictions�C
					//Log.v("Gesture", "predictions.size:" + predictions.size());
					for (Prediction p : predictions) {
						//Log.v("Gesture", "Prediction name:" + p.name + " score:" + p.score);
						Toast.makeText(HelloGesture.this, "score:" + p.score, Toast.LENGTH_SHORT).show(); //�ϥ�Toastĵ�ܤ�k�����predictions�ƭȡC
					}
				}
			}		
		});
		//��@OnGesturingListener��ť�\��
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