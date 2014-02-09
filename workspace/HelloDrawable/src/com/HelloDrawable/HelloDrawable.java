package com.HelloDrawable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HelloDrawable extends Activity {
    //HelloDrawable主程式
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final ImageView mImageView = (ImageView)findViewById(R.id.ImageView01);
        ImageButton mImageButton01 = (ImageButton)findViewById(R.id.ImageButton01);
        ImageButton mImageButton02 = (ImageButton)findViewById(R.id.ImageButton02);
        ImageButton mImageButton03 = (ImageButton)findViewById(R.id.ImageButton03);
        //按下ImageButton01，在圖像顯示欄位上顯示navy_101照片
        mImageButton01.setOnClickListener(new ImageButton.OnClickListener() {
			public void onClick(View arg0) {
				mImageView.setImageResource(R.drawable.navy_101);				
				}				
    		});
        //按下ImageButton02，在圖像顯示欄位上顯示navy_102照片
        mImageButton02.setOnClickListener(new ImageButton.OnClickListener() {
			public void onClick(View arg0) {
				mImageView.setImageResource(R.drawable.navy_102);				
			}				
		});
        //按下ImageButton03，在圖像顯示欄位上顯示navy_103照片
        mImageButton03.setOnClickListener(new ImageButton.OnClickListener() {
			public void onClick(View arg0) {
				mImageView.setImageResource(R.drawable.navy_103);				
			}				
		});
    }
}