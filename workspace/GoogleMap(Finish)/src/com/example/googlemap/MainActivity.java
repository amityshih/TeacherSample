package com.example.googlemap;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity implements LocationListener{  
private static final String MAP_URL = "file:///android_asset/map_v3.html";
private WebView webView;
private Location mostRecentLocation = null;


private void getLocation() {//���o�˸m��GPS��m���
    LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
    Criteria criteria = new Criteria();
    criteria.setAccuracy(Criteria.ACCURACY_FINE);
    
    String provider = locationManager.getBestProvider(criteria,true);
    //In order to make sure the device is getting the location, request updates.
    Log.d("BMI", "find Views");
    locationManager.requestLocationUpdates(provider, 1, 0, this);
    mostRecentLocation = locationManager.getLastKnownLocation(provider);
  }

 @Override
 /** Called when the activity is first created. */
 public void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_main);
   setupWebView();
   getLocation();
 }
 /** Sets up the WebView object and loads the URL of the page **/
 private void setupWebView(){
   webView = (WebView) findViewById(R.id.webview01);
   webView.getSettings().setJavaScriptEnabled(true);//�ҥ�Webview��JavaScript�\��
   webView.setWebViewClient(new WebViewClient());
   webView.loadUrl(MAP_URL);    
 }
@Override
public void onLocationChanged(Location location) {
 
	        //�N�e�����ܩw���I����m�A�I�s�bgooglemaps.html����centerAt�禡
	        final String centerURL = "javascript:centerAt(" +
	        	location.getLatitude() + "," +
	          	location.getLongitude()+ ")";
	        	webView.loadUrl(centerURL);
	        
	        final String markURL = "javascript:mark(" +
	        	location.getLatitude() + "," +
	        	location.getLongitude()+ ")";
		    	webView.loadUrl(markURL);	
}
@Override
public void onProviderDisabled(String provider) {
 // TODO Auto-generated method stub
 
}

@Override
public void onProviderEnabled(String provider) {
 // TODO Auto-generated method stub
 
}

@Override
public void onStatusChanged(String provider, int status, Bundle extras) {
 // TODO Auto-generated method stub
 
}
}
