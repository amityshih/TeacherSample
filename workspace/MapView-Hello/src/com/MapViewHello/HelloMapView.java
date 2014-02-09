// Tutorial1: Hello, Map View
// Draw a simple MapView and Overlay. Code adapted from: 
// http://developer.android.com/guide/tutorials/views/hello-mapview.html 
package com.MapViewHello;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class HelloMapView extends MapActivity {
	List<Overlay> mapOverlays;
	Drawable drawable;
	HelloItemizedOverlay itemizedOverlay;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    	MapView   mapView; 
		mapView = (MapView) findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);
		
		mapOverlays = mapView.getOverlays();
		drawable = this.getResources().getDrawable(R.drawable.ic_launcher_android);
		itemizedOverlay = new HelloItemizedOverlay(drawable);
		
		//Android goes to Taipei main station
		GeoPoint point = new GeoPoint(25047308,121517284);
		OverlayItem overlayitem = new OverlayItem(point, "", "");
		
		itemizedOverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedOverlay);
		
    }

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}