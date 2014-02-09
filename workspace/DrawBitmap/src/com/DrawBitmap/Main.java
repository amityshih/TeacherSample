package com.DrawBitmap;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.view.View;

public class Main extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this));
	}

	private static class MyView extends View
	{
		private Bitmap bitmap1;
		private Bitmap bitmap2;
		private Bitmap bitmap3;
		private Bitmap bitmap4;
		private Drawable drawable;

		public MyView(Context context)
		{
			super(context);
			setBackgroundColor(Color.WHITE);
			java.io.InputStream is= context.getResources().openRawResource(R.drawable.panda);
			
			BitmapFactory.Options opts = new BitmapFactory.Options();
			opts.inSampleSize = 2; 
			bitmap1 = BitmapFactory.decodeStream(is, null, opts);

			is = context.getResources().openRawResource(R.drawable.tiger);
			bitmap2 = BitmapFactory.decodeStream(is);

			
			int w = bitmap2.getWidth();
			int h = bitmap2.getHeight();
			int[] pixels = new int[w * h];
			//複製bitmap2的所有圖素顏色值(pixels陣列)
			bitmap2.getPixels(pixels, 0, w, 0, 0, w, h);
			//將bitmap2複製2份(bitmap3和bitmap4)
			bitmap3 = Bitmap.createBitmap(pixels, 0, w, w, h,
					Bitmap.Config.ARGB_8888);
			bitmap4 = Bitmap.createBitmap(pixels, 0, w, w, h,
					Bitmap.Config.ARGB_4444);
			//取得影像資源的Drawable物件
			drawable = context.getResources().getDrawable(R.drawable.button);
			//設定繪製點陣圖的左上角座標、寬度和高度
			drawable.setBounds(50, 350, 180, 420);
		}

		@Override
		protected void onDraw(Canvas canvas)
		{
			//繪製5個點陣圖
			canvas.drawBitmap(bitmap1, 10, 10, null);
			canvas.drawBitmap(bitmap2, 10, 200, null);
			canvas.drawBitmap(bitmap3, 110, 200, null);
			canvas.drawBitmap(bitmap4, 210, 200, null);
			drawable.draw(canvas);

			
		}
	}
}