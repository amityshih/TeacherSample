package com.example.android.media;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MediaPlayerAudio extends Activity {
    private static final String TAG = "MediaPlayerDemo";
    private MediaPlayer mMediaPlayer;
    private static final String MEDIA = "media";
    private static final int LOCAL_AUDIO = 1;
    private static final int STREAM_AUDIO = 2;
    private static final int RESOURCES_AUDIO = 3;
    private String path;
    private TextView mTextView;
    //MediaPlayerAudio
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mediaplayer02);
        mTextView = (TextView) findViewById(R.id.TextView01);
        Bundle extras = getIntent().getExtras();
        playAudio(extras.getInt(MEDIA));
    }
    //播放音樂
    private void playAudio(Integer media) {
        try {
            switch (media) {
                case LOCAL_AUDIO:
                	//設定音訊檔案路徑
                    path = "/sdcard/song01.mp3";//這是測試用的音訊檔案
                	//path = "";
                    if (path == "") {
                        //警告User尚未建立音訊檔案 
                        Toast.makeText(MediaPlayerAudio.this,"尚未建立音訊檔案",Toast.LENGTH_LONG).show();
                    }
                    mMediaPlayer = new MediaPlayer();
                    mMediaPlayer.setDataSource(path);
                    mMediaPlayer.prepare();
                    mMediaPlayer.start();
                    mTextView.setText("LOCAL_AUDIO-播放音樂中...");
                    break;
                case STREAM_AUDIO:
                	//設定音訊檔案路徑的URL
                	path = "http://www.uenocity.com/media-android/song11.mp3";
                    //path = "";
                    if (path == "") {
                        //警告User尚未建立音訊檔案 的URL.
                        Toast.makeText(MediaPlayerAudio.this,"Please edit MediaPlayerDemo_Video Activity and set the path variable to your media file URL.",Toast.LENGTH_LONG).show();
                    }
                    mMediaPlayer = new MediaPlayer();
                    mMediaPlayer.setDataSource(path);
                    mMediaPlayer.prepare();
                    mMediaPlayer.start();
                    mTextView.setText("STREAM_AUDIO-播放音樂中...");
                    break;
                case RESOURCES_AUDIO:
                    //本地音訊檔案要放在/res/raw目錄內且提供resid給MediaPlayer.create()
                	mMediaPlayer = MediaPlayer.create(this, R.raw.song21);
                    mMediaPlayer.start();
                    mTextView.setText("RESOURCES_AUDIO-播放音樂中...");
                    break;
            }
        } catch (Exception e) {
            Log.e(TAG, "error: " + e.getMessage(), e);
        }
    }
    //關閉MediaPlayerAudio程式且釋放MediaPlayer
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
