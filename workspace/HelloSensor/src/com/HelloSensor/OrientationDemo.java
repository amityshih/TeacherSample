package com.HelloSensor;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class OrientationDemo extends Activity implements SensorEventListener {
	private SensorManager sensorManager;
	private MySurfaceView view;
	private Object[] orientation = {
			"Rotate Z-axis Orientation", "Rotate X-axis Orientation","Rotate Y-axis Orientation",
	};
	//OrientationDemo主程式
	@Override
	public void onCreate(Bundle savedInstanceState) { //建立OrientationDemo主程式
		super.onCreate(savedInstanceState);
		sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE); //設定擷取Android手機的感應信號
		view = new MySurfaceView(this); //實作MySurfaceView類別的變數view
		setContentView(view); //顯示Android方向感應偵測畫面。
	}
	@Override
	protected void onResume() {
		super.onResume();
		List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ORIENTATION); //實作取得感應偵測Sensor是方向感應種類(Sensor.TYPE_ORIENTATION)。
		if (sensors.size() > 0) {
			sensorManager.registerListener(this, sensors.get(0), SensorManager.SENSOR_DELAY_NORMAL);//註冊感應偵測Sensor是方位感應的監聽功能
		}
	}
	@Override
	protected void onPause() {
		super.onPause();
		sensorManager.unregisterListener(this);
	}
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}
	public void onSensorChanged(SensorEvent event) {
		view.onValueChanged(event.values); //當偵測到方位有所變更時，益SurfaceView類別view Callback程式。
	}
	class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
		private Bitmap bitmap, bitmap1, bitmap2,curBitmap;
		private float x, y;
		private float x1=130, y1=160;
		private int curWidth, curHeight;
		public MySurfaceView(Context context) {
			super(context);
			getHolder().addCallback(this);
			bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.androidplate);
			bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.androidheight);
			bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.androidwidth);
		}
		public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
			x = getWidth()/2;
			y = getHeight()/2;
			onValueChanged(new float[3]);
		}
		public void surfaceCreated(SurfaceHolder holder) {
		}
		public void surfaceDestroyed(SurfaceHolder holder) {
		}
		@SuppressWarnings("static-access")
		void onValueChanged(float[] values) {
			Canvas canvas = getHolder().lockCanvas();
			if (canvas != null) {
				Paint paint = new Paint();
				paint.setAntiAlias(true);
				paint.setColor(Color.BLUE);
				paint.setTextSize(24);
				canvas.drawColor(Color.WHITE);
				canvas.save();
				Matrix matrix = new Matrix();
				curWidth = (int) (bitmap.getWidth()* 1);
				curHeight =  (int) (bitmap.getHeight()* 1);
				curBitmap = bitmap.createScaledBitmap(bitmap, curWidth, curHeight, false);
				matrix.setRotate(-values[0], x , y );
				canvas.setMatrix(matrix);
				canvas.drawBitmap(curBitmap, x-curWidth/2, y-curHeight/2, null);
				matrix.setRotate(values[1], x-x1 , y+y1 );
				canvas.setMatrix(matrix);
				canvas.drawBitmap(bitmap1, x-x1-bitmap1.getWidth()/2, y+y1-bitmap1.getHeight()/2, null);
				matrix.setRotate(-values[2], x+x1 , y+y1 );
				canvas.setMatrix(matrix);
				canvas.drawBitmap(bitmap2, x+x1-bitmap2.getWidth()/2, y+y1-bitmap2.getHeight()/2, null);
				canvas.restore();
				for (int i = 0; i < values.length; i++) {
					canvas.drawText(orientation[i] + ": "  + values[i], 0, paint.getTextSize() * (i + 1), paint);
				}
				getHolder().unlockCanvasAndPost(canvas);
			}
		}
	}
}

