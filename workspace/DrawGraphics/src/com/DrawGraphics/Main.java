package com.DrawGraphics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class Main extends Activity
{
	class MyView extends View
	{
		private Paint paint1 = new Paint();
		private Paint paint2 = new Paint();
		private Paint paint3 = new Paint();
		private boolean useCenter = true;
		private float[] textSizeArray = new float[]
		{ 15, 18, 21, 24, 27 }; //用於設定繪製文字的字體大小

		@Override
		public boolean onTouchEvent(MotionEvent event)
		{
			if (useCenter)
			{
				useCenter = false;
				//設定畫筆的顏色
				paint1.setColor(Color.RED);
				paint2.setColor(Color.BLACK);
				paint3.setColor(Color.GREEN);
				//設定畫筆的寬度
				paint1.setStrokeWidth(6);
				paint2.setStrokeWidth(4);
				paint3.setStrokeWidth(2);

			}
			else
			{
				useCenter = true;
				paint1.setColor(Color.BLACK);
				paint2.setColor(Color.RED);
				paint3.setColor(Color.BLUE);
				paint1.setStrokeWidth(2);
				paint2.setStrokeWidth(4);
				paint3.setStrokeWidth(6);
			}
			for (int i = 0; i < textSizeArray.length / 2; i++)
			{
				float textSize = textSizeArray[i];

				textSizeArray[i] = textSizeArray[textSizeArray.length - i - 1];
				textSizeArray[textSizeArray.length - i - 1] = textSize;
			}
			//刷新View
			invalidate(); //控制View的重繪，當呼叫此method時，系統就會呼叫onDraw方法來重繪View
			return super.onTouchEvent(event);
		}

		public MyView(Context context)
		{
			super(context);
			setBackgroundColor(Color.WHITE);

			paint1.setColor(Color.BLACK);
			paint1.setStrokeWidth(2);
			paint2.setColor(Color.RED);
			paint2.setStrokeWidth(4);
			paint3.setColor(Color.BLUE);
			paint3.setStrokeWidth(6);

		}

		private void drawLinesExt(Canvas canvas, float[] pts, Paint paint)
		{//假設省略座標的float陣列長度為pts.length，那麼生成被省略座標後的float陣列的長度是pts.length*2-4

			float[] points = new float[pts.length * 2 - 4];
			for (int i = 0, j = 0; i < pts.length; i = i + 2)
			{
				points[j++] = pts[i];
				points[j++] = pts[i + 1];
				//除了第一對和最後一對座標外，其他座標都複製一份
				if (i > 1 && i < pts.length - 2)
				{
					points[j++] = pts[i];
					points[j++] = pts[i + 1];
				}
			}

			canvas.drawLines(points, paint);
		}

		@Override
		protected void onDraw(Canvas canvas)
		{
			//製繪圖點
			canvas.drawPoint(60, 120, paint3);
			canvas.drawPoint(70, 130, paint3);
			canvas.drawPoints(new float[]
			{ 70, 140, 75, 145, 75, 160 }, paint2);
			//canvas.drawPoints(new float[]
			  //              			{ 70, 140, 75, 145, 75, 160 }, 1,4,paint2);
			//繪製直線
			canvas.drawLine(10, 10, 300, 10, paint1);
			canvas.drawLine(10, 30, 300, 30, paint2);
			canvas.drawLine(10, 50, 300, 50, paint3);
			//繪製正方形
			drawLinesExt(canvas, new float[]
			{ 10, 70, 120, 70, 120, 170, 10, 170, 10, 70 }, paint2);
			drawLinesExt(canvas, new float[]
			{ 25, 85, 105, 85, 105, 155, 25, 155, 25, 85 }, paint3);
			//繪製三角形
			drawLinesExt(canvas, new float[]
			{ 160, 70, 230, 150, 170, 155, 160, 70 }, paint2);
			//設定非填充狀態
			paint2.setStyle(Style.STROKE);
			//畫空心圓
			canvas.drawCircle(260, 110, 40, paint2);
			//設定填充狀態			
			paint2.setStyle(Style.FILL);
			//畫實心員
			canvas.drawCircle(260, 110, 30, paint2);

			RectF rectF = new RectF();
			rectF.left = 30;
			rectF.top = 190;
			rectF.right = 120;
			rectF.bottom = 280;
			//畫弧
			canvas.drawArc(rectF, 0, 200, useCenter, paint2);
			
			rectF.left = 140;
			rectF.top = 190;
			rectF.right = 280;
			rectF.bottom = 290;
			paint2.setStyle(Style.STROKE);
			//畫空心橢圓
			canvas.drawArc(rectF, 0, 360, useCenter, paint2);

			rectF.left = 160;
			rectF.top = 190;
			rectF.right = 260;
			rectF.bottom = 290;
			paint3.setStyle(Style.STROKE);
			//畫空心圓
			canvas.drawArc(rectF, 0, 360, useCenter, paint3);
			//繪製文字
			float y = 0;
			for (int i = 0; i < textSizeArray.length; i++)
			{
				paint1.setTextSize(textSizeArray[i]);

				paint1.setColor(Color.BLUE);
				//取得文字寬度可以用measureText方法
				canvas.drawText("Android（寬度：" + paint1.measureText("Android")
						+ "）", 20, 315 + y, paint1); 
				y += paint1.getTextSize() + 5;
			}
			paint1.setTextSize(22);
			//繪製文字，單獨設定每一個字元的座標，第1個座標(180,230)是"圓"的座標，第2個座標(210,250)是"形"的座標
			canvas.drawPosText("圓形", new float[]{180,230, 210,250}, paint1);

		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this));
	}
}
