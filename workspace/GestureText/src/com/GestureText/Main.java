package com.GestureText;

import java.util.ArrayList;

import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.os.Bundle;
import android.widget.Toast;

public class Main extends Activity implements OnGesturePerformedListener
{
	private GestureLibrary gestureLibrary;

	public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture)
	{
		//���o�i��ǰt�����
		ArrayList<Prediction> predictions = gestureLibrary.recognize(gesture);
		//���i��ǰt�����
		if (predictions.size() > 0)
		{

			StringBuilder sb = new StringBuilder();
			int n = 0;
			//�}�l���y�Ҧ��i��ǰt�����
			for (int i = 0; i < predictions.size(); i++)
			{
				Prediction prediction = predictions.get(i);
				//�ھڬۦ��סA�u�C�Xscore�j��1���ǰt���
				if (prediction.score > 1.0)
				{
					sb.append("score:" + prediction.score + "  name:"
							+ prediction.name + "\n");
					n++;
				}
			}
			
			sb.insert(0,n + "�Ӭۤǰt�����.\n");
			//��̲ܳת��ǰt��T
			Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
		}

	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		//���w��ո귽�ɮת���m
		//gestureLibrary = GestureLibraries.fromFile("/sdcard/gestures");
		gestureLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures);
		//�qraw�귽���B�z����귽
		if (gestureLibrary.load())
		{
			setTitle("����ɳB�z���\�]��X��r�^.");
			GestureOverlayView gestureOverlayView = (GestureOverlayView) findViewById(R.id.gestures);
			gestureOverlayView.addOnGesturePerformedListener(this);
		}
		else
		{
			setTitle("����ɳB�z����.");
		}
	}
}