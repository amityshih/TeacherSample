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
		//取得可能匹配的手勢
		ArrayList<Prediction> predictions = gestureLibrary.recognize(gesture);
		//有可能匹配的手勢
		if (predictions.size() > 0)
		{

			StringBuilder sb = new StringBuilder();
			int n = 0;
			//開始掃描所有可能匹配的手勢
			for (int i = 0; i < predictions.size(); i++)
			{
				Prediction prediction = predictions.get(i);
				//根據相似度，只列出score大於1的匹配手勢
				if (prediction.score > 1.0)
				{
					sb.append("score:" + prediction.score + "  name:"
							+ prediction.name + "\n");
					n++;
				}
			}
			
			sb.insert(0,n + "個相匹配的手勢.\n");
			//顯示最終的匹配資訊
			Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
		}

	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		//指定手勢資源檔案的位置
		//gestureLibrary = GestureLibraries.fromFile("/sdcard/gestures");
		gestureLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures);
		//從raw資源中處理手執資源
		if (gestureLibrary.load())
		{
			setTitle("手勢檔處理成功（輸出文字）.");
			GestureOverlayView gestureOverlayView = (GestureOverlayView) findViewById(R.id.gestures);
			gestureOverlayView.addOnGesturePerformedListener(this);
		}
		else
		{
			setTitle("手勢檔處理失敗.");
		}
	}
}