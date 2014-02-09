package com.LocationGPS;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LocationGPS extends Activity {
	private LocationManager mLocationManager;
	//LocationGPS�D�{���A��@�@��LocationManager����mLocationManager
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener);
    	TextView mTextView08 = (TextView)findViewById(R.id.TextView08);  	
    	mTextView08.setText("Location-GPS");
    }
    //�bResume���q�]�wmLocationListener�����A�i�H��o�a�z��m����s���
    @Override    
    protected void onResume() {        
    	if (mLocationManager != null) {            
    		mLocationManager.requestLocationUpdates(                
    				LocationManager.GPS_PROVIDER,                
    				0,                
    				0,                
    				mLocationListener);        
    		}                
    	super.onResume();    
    	} 
    //�bPause���q����mLocationListener�����A���A��o�a�z��m����s���
    @Override    
    protected void onPause() {        
    	if (mLocationManager != null) {            
    		mLocationManager.removeUpdates(mLocationListener);        
    		}                
    	super.onPause();    
    	}
    //��@mLocationListener����
    public LocationListener mLocationListener = new LocationListener() 
    { 
    	//GPS��m��T�Q��s
    	public void onLocationChanged(Location location) {        
    		TextView mTextView01 = (TextView)findViewById(R.id.TextView01);
    		TextView mTextView02 = (TextView)findViewById(R.id.TextView02);
    		TextView mTextView03 = (TextView)findViewById(R.id.TextView03);
    		TextView mTextView04 = (TextView)findViewById(R.id.TextView04);
    		TextView mTextView05 = (TextView)findViewById(R.id.TextView05);
    		TextView mTextView06 = (TextView)findViewById(R.id.TextView06);
    		TextView mTextView07 = (TextView)findViewById(R.id.TextView07);
    		mTextView01.setText("�n��-Latitude�G  " + String.valueOf(location.getLatitude()));
    		mTextView02.setText("�g��-Longitude�G  " + String.valueOf(location.getLongitude()));
    		mTextView03.setText("��T��-Accuracy�G  " + String.valueOf(location.getAccuracy()));
    		mTextView04.setText("�а�-Latitude�G  " + String.valueOf(location.getAltitude()));
    		mTextView05.setText("�ɶ�-Time�G  " + String.valueOf(location.getTime()));
    		mTextView06.setText("�t��-Speed�G  " + String.valueOf(location.getSpeed()));
    		mTextView07.setText("���-Bearing�G  " + String.valueOf(location.getBearing()));   
    		}
    	public void onProviderDisabled(String provider) {    
    	
    	}     
    	public void onProviderEnabled(String provider) {    
    	
    	}  
    	//GPS��m��T�����A�Q��s
    	public void onStatusChanged(String provider, int status, Bundle extras) {        
    		switch (status) {        
    			case LocationProvider.AVAILABLE:            
    				Log.v("Status", "AVAILABLE");            
    				break;        
    			case LocationProvider.OUT_OF_SERVICE:            
    				Log.v("Status", "OUT_OF_SERVICE");            
    				break;        
    			case LocationProvider.TEMPORARILY_UNAVAILABLE:            
    				Log.v("Status", "TEMPORARILY_UNAVAILABLE");            
    				break;        
    				}    
    		}
    };
}