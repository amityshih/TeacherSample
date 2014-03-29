package com.SelectionWidgetsGallery;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class SelectionWidgetsGallery extends Activity {
	TextView mySelection;
	Gallery myGallery;
	
	ImageView myImage;
	int[] myImageIds = { R.drawable.image1, R.drawable.image2,
			R.drawable.image3, R.drawable.image4 };
	@Override
	public void onCreate(Bundle icicle) { 
		super.onCreate(icicle);
		setContentView(R.layout.main);
		myImage = (ImageView)findViewById(R.id.myImage);
		mySelection = (TextView) findViewById(R.id.mySelection);
		
		// Bind the gallery defined in the main.xml
		// Apply a new (customized) ImageAdapter to it.
		myGallery = (Gallery) findViewById(R.id.myGallery);
		
		myGallery.setAdapter(new ImageAdapter(this));
		
		myGallery.setOnItemSelectedListener(new OnItemSelectedListener() {
		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		mySelection.setText(" selected option: " + arg2 );
		myImage.setImageResource(myImageIds[arg2]);
		
		}
		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
		mySelection.setText("Nothing selected");
			}
		});
	}// onCreate
	public class ImageAdapter extends BaseAdapter {
		/** The parent context */
		private Context myContext;
		int[] myImageIds = { R.drawable.image1, R.drawable.image2,
				R.drawable.image3, R.drawable.image4 };
		// Put some images to project-folder: /res/drawable/
		// format: jpg, gif, png, bmp, ...
		
		/** Simple Constructor saving the 'parent' context. */

		public ImageAdapter(Context c) {
		this.myContext = c;
	}
	// inherited abstract methods - must be implemented
	//Returns count of images, and individual IDs
	public int getCount() {
		return this.myImageIds.length;
	}
	public Object getItem(int position) {
		return position;

	}
	public long getItemId(int position) {
		return position;
	}
	// Returns a new ImageView to be displayed,
	public View getView(int position, View convertView, ViewGroup parent) {
	// Get a View to display image data
	ImageView i = new ImageView(this.myContext);
	
	i.setImageResource(this.myImageIds[position]);
	// Image should be scaled to the screen¡¦s CENTER
	i.setScaleType(ImageView.ScaleType.CENTER);
		// Set the Width & Height of the individual images
	i.setLayoutParams(new Gallery.LayoutParams(95, 70));
		return i;
	}
}// ImageAdapter
}// AndDemoUI
