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
    //HelloShape�D�{��
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCustomDrawableView = new CustomDrawableView(this);
        setContentView(mCustomDrawableView);
    }
    //CustomDrawableView���O
    public class CustomDrawableView extends View {    
    	private ShapeDrawable mDrawable;    
    	public CustomDrawableView(Context context) {        
    		super(context);        
    		x = 10;        
    		y = 30;        
    		width = 100;        
    		height = 50;        
    		mDrawable = new ShapeDrawable(new OvalShape()); 	//�w�qmDrawable����O�Ӿ�ϧ�  
    		mDrawable.getPaint().setColor(0xff74AC23); 			//�w�qmDrawable�����C��O���
    		//mDrawable.setBounds(x, y, x + width, y + height);	//�w�qmDrawable���󪺹ϧνd��A���W���O(10,10)�B��=300�M��=50�C
    	}    
    	protected void onDraw(Canvas canvas) {        
    		mDrawable.setBounds(x, y, x + width, y + height);	//�w�qmDrawable���󪺹ϧνd��A���W���O(10,10)�B��=300�M��=50�C
    		width=width+1;
    		mDrawable.draw(canvas);    							//�b�e���W�yømDrawable����C
    		invalidate();    		
    	}
    }
}