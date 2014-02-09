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
        //�{�b��m���ܤƮɡA�n���I�s����k
        LocationManager mLocationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE); //��@LocationManager����mLocationListener
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this); //�]�w��GPS_PROVIDER��oGPS�w���T�A�浹LocationListener�����A�W�٬OmLocationListener
        //�]�wMapView�i�H�Y��
        MapView mapView = (MapView)findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        //�]�wZoom�j�p�M�a�Ϫ������I
        mc = mapView.getController();
        mc.setZoom(INITIAL_ZOOM_LEVEL);
        mc.setCenter(new GeoPoint(INITIAL_LATITUDE,INITIAL_LONGITUDE)); //�]�w�s���g�n��
    }
    @Override
	protected boolean isRouteDisplayed() {
		return false;
	}
    //�����I��m���ܤƮɡA���s��ܦa��
	public void onLocationChanged(Location location) { //�qlocation���o�s���g�שM�n��
		GeoPoint gp = 
			new GeoPoint((int)(location.getLatitude()*1E6),
				         (int)(location.getLongitude()*1E6));
		mc.animateTo(gp);
	}
	public void onProviderDisabled(String provider) {
		// TODO 
	}
	public void onProviderEnabled(String provider) {
		// TODO�@
	}
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO 
	}
}
