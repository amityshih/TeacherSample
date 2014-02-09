package com.HelloDrawable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HelloDrawable extends Activity {
    //HelloDrawable�D�{��
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final ImageView mImageView = (ImageView)findViewById(R.id.ImageView01);
        ImageButton mImageButton01 = (ImageButton)findViewById(R.id.ImageButton01);
        ImageButton mImageButton02 = (ImageButton)findViewById(R.id.ImageButton02);
        ImageButton mImageButton03 = (ImageButton)findViewById(R.id.ImageButton03);
        //���UImageButton01�A�b�Ϲ�������W���navy_101�Ӥ�
        mImageButton01.setOnClickListener(new ImageButton.OnClickListener() {
			public void onClick(View arg0) {
				mImageView.setImageResource(R.drawable.navy_101);				
				}				
    		});
        //���UImageButton02�A�b�Ϲ�������W���navy_102�Ӥ�
        mImageButton02.setOnClickListener(new ImageButton.OnClickListener() {
			public void onClick(View arg0) {
				mImageView.setImageResource(R.drawable.navy_102);				
			}				
		});
        //���UImageButton03�A�b�Ϲ�������W���navy_103�Ӥ�
        mImageButton03.setOnClickListener(new ImageButton.OnClickListener() {
			public void onClick(View arg0) {
				mImageView.setImageResource(R.drawable.navy_103);				
			}				
		});
    }
}