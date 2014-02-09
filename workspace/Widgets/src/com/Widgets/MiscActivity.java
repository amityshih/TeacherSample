package com.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MiscActivity extends Activity implements RatingBar.OnRatingBarChangeListener  {
//RatingBar.OnRatingBarChangeListener  SeekBar.OnSeekBarChangeListener 
	//MiscActivity�D�{��
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.misc_activity);
		
		TextView mTextView01 = (TextView)findViewById(R.id.TextView01);
		TextView mTextView02 = (TextView)findViewById(R.id.TextView02);
		RatingBar mRatingBar01 = (RatingBar)findViewById(R.id.RatingBar01);
		SeekBar mSeekBar01 = (SeekBar)findViewById(R.id.SeekBar01);
		//��Rating Bar��ܫG�ת���l��
		mTextView01.setText("��Rating Bar���:\n�G�׬O=" + mRatingBar01.getProgress());
		//��Seek Bar��ܭ��q����l��
		mTextView02.setText("��Seek Bar���:\n���q�O=" + mSeekBar01.getProgress());
		//RatingBar.OnRatingBarChangeListener�bActivity�v�w�q implements
		mRatingBar01.setOnRatingBarChangeListener(this);
		//SeekBar.OnSeekBarChangeListener�S���bActivity�w�q�A�o�̧���W��mSeekBar01����ť�\��
		mSeekBar01.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			//Seek Bar���ܤƮɡA����o����ܭ��q���j�p
			public void onProgressChanged(SeekBar mSeekBar01, int progress, boolean fromTouch) {
				final TextView mTextView02 = (TextView)findViewById(R.id.TextView02);
				mTextView02.setText("��Seek Bar���:\n���q�O=" + mSeekBar01.getProgress());
			}
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
		});		
	}
	//Rating Bar���ܤƮɡA����o����ܫG�ת��j�p
	public void onRatingChanged(RatingBar mRatingBar01, float rating, boolean fromTouch) {
		final TextView mTextView01 = (TextView)findViewById(R.id.TextView01);
		mTextView01.setText("��Rating Bar���:\n�G�׬O=" + mRatingBar01.getProgress());
	}
}

