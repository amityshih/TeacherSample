package com.HelloShape;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.View;

public class HelloShape extends Activity {
    private CustomDrawableView mCustomDrawableView;
    public int width;
    public int x;
    public int y;
    public int height;
    //HelloShape主程式
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCustomDrawableView = new CustomDrawableView(this);
        setContentView(mCustomDrawableView);
    }
    //CustomDrawableView類別
    public class CustomDrawableView extends View {    
    	private ShapeDrawable mDrawable;    
    	public CustomDrawableView(Context context) {        
    		super(context);        
    		x = 10;        
    		y = 30;        
    		width = 100;        
    		height = 50;        
    		mDrawable = new ShapeDrawable(new OvalShape()); 	//定義mDrawable物件是個橢圖形  
    		mDrawable.getPaint().setColor(0xff74AC23); 			//定義mDrawable物件的顏色是綠色
    		//mDrawable.setBounds(x, y, x + width, y + height);	//定義mDrawable物件的圖形範圍，左上角是(10,10)、長=300和高=50。
    	}    
    	protected void onDraw(Canvas canvas) {        
    		mDrawable.setBounds(x, y, x + width, y + height);	//定義mDrawable物件的圖形範圍，左上角是(10,10)、長=300和高=50。
    		width=width+1;
    		mDrawable.draw(canvas);    							//在畫布上描繪mDrawable物件。
    		invalidate();    		
    	}
    }
}