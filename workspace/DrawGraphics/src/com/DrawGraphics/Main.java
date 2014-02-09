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
		{ 15, 18, 21, 24, 27 }; //�Ω�]�wø�s��r���r��j�p

		@Override
		public boolean onTouchEvent(MotionEvent event)
		{
			if (useCenter)
			{
				useCenter = false;
				//�]�w�e�����C��
				paint1.setColor(Color.RED);
				paint2.setColor(Color.BLACK);
				paint3.setColor(Color.GREEN);
				//�]�w�e�����e��
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
			//��sView
			invalidate(); //����View����ø�A��I�s��method�ɡA�t�δN�|�I�sonDraw��k�ӭ�øView
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
		{//���]�ٲ��y�Ъ�float�}�C���׬�pts.length�A����ͦ��Q�ٲ��y�Ы᪺float�}�C�����׬Opts.length*2-4

			float[] points = new float[pts.length * 2 - 4];
			for (int i = 0, j = 0; i < pts.length; i = i + 2)
			{
				points[j++] = pts[i];
				points[j++] = pts[i + 1];
				//���F�Ĥ@��M�̫�@��y�Х~�A��L�y�г��ƻs�@��
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
			//�sø���I
			canvas.drawPoint(60, 120, paint3);
			canvas.drawPoint(70, 130, paint3);
			canvas.drawPoints(new float[]
			{ 70, 140, 75, 145, 75, 160 }, paint2);
			//canvas.drawPoints(new float[]
			  //              			{ 70, 140, 75, 145, 75, 160 }, 1,4,paint2);
			//ø�s���u
			canvas.drawLine(10, 10, 300, 10, paint1);
			canvas.drawLine(10, 30, 300, 30, paint2);
			canvas.drawLine(10, 50, 300, 50, paint3);
			//ø�s�����
			drawLinesExt(canvas, new float[]
			{ 10, 70, 120, 70, 120, 170, 10, 170, 10, 70 }, paint2);
			drawLinesExt(canvas, new float[]
			{ 25, 85, 105, 85, 105, 155, 25, 155, 25, 85 }, paint3);
			//ø�s�T����
			drawLinesExt(canvas, new float[]
			{ 160, 70, 230, 150, 170, 155, 160, 70 }, paint2);
			//�]�w�D��R���A
			paint2.setStyle(Style.STROKE);
			//�e�Ť߶�
			canvas.drawCircle(260, 110, 40, paint2);
			//�]�w��R���A			
			paint2.setStyle(Style.FILL);
			//�e��߭�
			canvas.drawCircle(260, 110, 30, paint2);

			RectF rectF = new RectF();
			rectF.left = 30;
			rectF.top = 190;
			rectF.right = 120;
			rectF.bottom = 280;
			//�e��
			canvas.drawArc(rectF, 0, 200, useCenter, paint2);
			
			rectF.left = 140;
			rectF.top = 190;
			rectF.right = 280;
			rectF.bottom = 290;
			paint2.setStyle(Style.STROKE);
			//�e�Ť߾��
			canvas.drawArc(rectF, 0, 360, useCenter, paint2);

			rectF.left = 160;
			rectF.top = 190;
			rectF.right = 260;
			rectF.bottom = 290;
			paint3.setStyle(Style.STROKE);
			//�e�Ť߶�
			canvas.drawArc(rectF, 0, 360, useCenter, paint3);
			//ø�s��r
			float y = 0;
			for (int i = 0; i < textSizeArray.length; i++)
			{
				paint1.setTextSize(textSizeArray[i]);

				paint1.setColor(Color.BLUE);
				//���o��r�e�ץi�H��measureText��k
				canvas.drawText("Android�]�e�סG" + paint1.measureText("Android")
						+ "�^", 20, 315 + y, paint1); 
				y += paint1.getTextSize() + 5;
			}
			paint1.setTextSize(22);
			//ø�s��r�A��W�]�w�C�@�Ӧr�����y�СA��1�Ӯy��(180,230)�O"��"���y�СA��2�Ӯy��(210,250)�O"��"���y��
			canvas.drawPosText("���", new float[]{180,230, 210,250}, paint1);

		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this));
	}
}
