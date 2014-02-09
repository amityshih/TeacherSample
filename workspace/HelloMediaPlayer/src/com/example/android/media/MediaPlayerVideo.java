package com.example.android.media;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;
import android.widget.Toast;

public class MediaPlayerVideo extends Activity implements
        OnPreparedListener, OnVideoSizeChangedListener, SurfaceHolder.Callback {
    private int mVideoWidth;
    private int mVideoHeight;
    private MediaPlayer mMediaPlayer;
    private SurfaceView mPreview;
    private SurfaceHolder holder;
    private String path;
    private TextView mTextView;
    private Bundle extras;
    private static final String MEDIA = "media";
    private static final int LOCAL_VIDEO = 4;
    private static final int STREAM_VIDEO = 5;
    private static final int RESOURCES_VIDEO = 6;
    private boolean mIsVideoSizeKnown = false;
    private boolean mIsVideoReadyToBePlayed = false;
    //MediaPlayerVideo�{��
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mediaplayer01);
        mTextView = (TextView) findViewById(R.id.TextView01);
        mPreview = (SurfaceView) findViewById(R.id.surface);
        holder = mPreview.getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        extras = getIntent().getExtras();
    }
    //������T
    private void playVideo(Integer Media) {
        doCleanUp();
        try {
            switch (Media) {
                case LOCAL_VIDEO:
                	//�]�w���T�ɮ׸��|
                	path = "/sdcard/navy.3gp";//�o�O���եΪ����T�ɮ�
                    if (path == "") {
                        //ĵ�iUser�|���إߵ��T�ɮ�
                        Toast.makeText(MediaPlayerVideo.this, "�|���إߵ��T�ɮ�",Toast.LENGTH_LONG).show();
                    }
                    mTextView.setText("LOCAL_VIDEO-������T��...");
                    break;

                case STREAM_VIDEO:
                	//ĵ�iUser�|���إߵ��T�ɮ� ��URL.
                	path = "http://www.uenocity.com/media-android/navy.3gp";//�o�O���եΪ����T�ɮת�RUL
                    if (path == "") {
                        //ĵ�iUser�|���إߵ��T�ɮ� ��URL.
                        Toast.makeText(MediaPlayerVideo.this,"Please edit MediaPlayerDemo_Video Activity and set the path variable to your media file URL.",Toast.LENGTH_LONG).show();
                    }
                    mTextView.setText("STREAM_VIDEO-������T��...");
                    break;

                case RESOURCES_VIDEO:
                    //���a���T�ɮ׭n��b/res/raw�ؿ����B����resid��MediaPlayer.create()
                	mMediaPlayer = MediaPlayer.create(this, R.raw.navy);//����create()�ɡA�|�I�sprepare()  	
                	mMediaPlayer.setDisplay(holder);
                	mMediaPlayer.prepare();
                	mMediaPlayer.setOnPreparedListener(this);
                	mMediaPlayer.setOnVideoSizeChangedListener(this);
                    mMediaPlayer.start();
                	mTextView.setText("RESOURCES_VIDEO-������T��...");
                	break;
            }

            //��@MedialPlayer�B�]�w��ť�\��
            if (Media == LOCAL_VIDEO || Media == STREAM_VIDEO) {
            	mMediaPlayer = new MediaPlayer();
            	mMediaPlayer.setDataSource(path);
            	mMediaPlayer.setDisplay(holder);
            	mMediaPlayer.prepare();
            	mMediaPlayer.setOnPreparedListener(this);
            	mMediaPlayer.setOnVideoSizeChangedListener(this);
            }
        } catch (Exception e) {

        }
    }

    //onVideoSizeChanged
    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
        Toast.makeText(MediaPlayerVideo.this, "onVideoSizeChanged called",Toast.LENGTH_LONG).show();
        if (width == 0 || height == 0) {
            return;
        }
        mIsVideoSizeKnown = true;
        mVideoWidth = width;
        mVideoHeight = height;    
        if (mIsVideoReadyToBePlayed && mIsVideoSizeKnown) {
            startVideoPlayback();
        }
    }

    //onPrepared
    public void onPrepared(MediaPlayer mediaplayer) {
        Toast.makeText(MediaPlayerVideo.this, "onPrepared called",Toast.LENGTH_LONG).show();
        mIsVideoReadyToBePlayed = true;
        if (mIsVideoReadyToBePlayed && mIsVideoSizeKnown) {
            startVideoPlayback();
        }     
    }

    //�I�splayVideo()�A������T
    public void surfaceCreated(SurfaceHolder holder) {
        playVideo(extras.getInt(MEDIA));
    }
    //onPause
    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaPlayer();
        doCleanUp();
    }
    
    //����MediaPlayerVideo�{���B����MediaPlayer
    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMediaPlayer();
        doCleanUp();
    }
    
    //releaseMediaPlayer
    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
    
    //doCleanUp
    private void doCleanUp() {
        mVideoWidth = 0;
        mVideoHeight = 0;
        mIsVideoReadyToBePlayed = false;
        mIsVideoSizeKnown = false;
    }
    
    //startVideoPlayback
    private void startVideoPlayback() {
        Toast.makeText(MediaPlayerVideo.this, "startVideoPlayback()",Toast.LENGTH_LONG).show();
        holder.setFixedSize(mVideoWidth, mVideoHeight);
        mMediaPlayer.start();
    }
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

}
