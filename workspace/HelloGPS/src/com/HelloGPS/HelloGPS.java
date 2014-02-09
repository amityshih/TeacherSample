package com.HelloGPS;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class HelloGPS extends MapActivity implements LocationListener {
	static final int INITIAL_ZOOM_LEVEL = 13; 
	static final int INITIAL_LATITUDE = 25040255;
	static final int INITIAL_LONGITUDE = 121512377;
	MapController mc;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //現在位置有變化時，登錄呼叫的方法
        LocationManager mLocationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE); //實作LocationManager物件mLocationListener
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this); //設定自GPS_PROVIDER獲得GPS定位資訊，交給LocationListener介面，名稱是mLocationListener
        //設定MapView可以縮放
        MapView mapView = (MapView)findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        //設定Zoom大小和地圖的中心點
        mc = mapView.getController();
        mc.setZoom(INITIAL_ZOOM_LEVEL);
        mc.setCenter(new GeoPoint(INITIAL_LATITUDE,INITIAL_LONGITUDE)); //設定新的經緯度
    }
    @Override
	protected boolean isRouteDisplayed() {
		return false;
	}
    //中心點位置有變化時，重新顯示地圖
	public void onLocationChanged(Location location) { //從location取得新的經度和緯度
		GeoPoint gp = 
			new GeoPoint((int)(location.getLatitude()*1E6),
				         (int)(location.getLongitude()*1E6));
		mc.animateTo(gp);
	}
	public void onProviderDisabled(String provider) {
		// TODO 
	}
	public void onProviderEnabled(String provider) {
		// TODO　
	}
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO 
	}
}
