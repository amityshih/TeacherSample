package com.ActivityLifeCycle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityLifeCycle extends Activity {

	public static final String MYPREFSID = "MyPrefs001";
	public static final int actMode = Activity.MODE_PRIVATE;
	EditText txtMsg;
	Button btnFinish;
	TextView txtToDo;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		txtMsg = (EditText) findViewById(R.id.txtMsg);

		//updateFromSavedState_IfNeeded();

		txtToDo = (TextView) findViewById(R.id.txtToDo);

		String msg = "Instructions:                	                 \n "
				+ "0. New instance (onCreate, onStart, onResume)   \n "
				+ "1. Back Arrow   (onPause, onStop, onDestroy)    \n "
				+ "2. Finish       (onPause, onStop, onDestroy)    \n "
				+ "3. Home		 (onPause, onStop)	 \n "
				+ "4. After 3> App Tab> re-execute current app     \n "
				+ "  (onRestart, onStart, onResume)		 \n "
				+ "5. Run DDMS> Receive a phone call or SMS	 \n "
				+ "  (onRestart, onStart, onResume)		 \n "
				+ "6. Enter some data - repeat steps 1-5   	 \n ";

		txtToDo.setText(msg);

		btnFinish = (Button) findViewById(R.id.btnFinish);

		btnFinish.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		Toast.makeText(getBaseContext(), "onCreate ...", Toast.LENGTH_LONG)
				.show();
	}//onCreate
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		clearMyPrefs();
		Toast.makeText(getBaseContext(), "onDestroy ...", Toast.LENGTH_LONG)
				.show();
	}

	@Override
	protected void onPause() {
		super.onPause();
		saveDataFromCurrentState();
		Toast.makeText(getBaseContext(), "onPause ...", Toast.LENGTH_LONG)
				.show();

	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Toast.makeText(getBaseContext(), "onRestart ...", Toast.LENGTH_LONG)
				.show();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Toast.makeText(getBaseContext(), "onResume...", Toast.LENGTH_LONG)
				.show();
	}

	@Override
	protected void onStart() {
		super.onStart();
		Toast.makeText(getBaseContext(), "onStart ...", Toast.LENGTH_LONG)
				.show();
	}

	@Override
	protected void onStop() {
		super.onStop();
		Toast.makeText(getBaseContext(), "onStop ...", Toast.LENGTH_LONG)
				.show();
	}

	protected void updateFromSavedState_IfNeeded() {
		SharedPreferences myPrefs = getSharedPreferences(MYPREFSID, actMode);
		if ((myPrefs != null) && (myPrefs.contains("txtMsg"))) {
			String myData = myPrefs.getString("txtMsg", "");
			txtMsg.setText(myData);
		}
	}// UpdateFromSavedState_IfNeeded

	protected void saveDataFromCurrentState() {
		SharedPreferences myPrefs = getSharedPreferences(MYPREFSID, actMode);
		SharedPreferences.Editor myEditor = myPrefs.edit();
		myEditor.putString("txtMsg", txtMsg.getText().toString());
		myEditor.commit();
	}// saveDataFromCurrentState

	protected void clearMyPrefs() {
		SharedPreferences myPrefs = getSharedPreferences(MYPREFSID, actMode);
		SharedPreferences.Editor myEditor = myPrefs.edit();
		myEditor.clear();
		myEditor.commit();
	}

	/*
	 * protected void onRestoreInstanceState(Bundle savedInstanceState) This
	 * method is called after onStart() when the activity is being
	 * re-initialized from a previously saved state. The default implementation
	 * of this method performs a restore of any view state that had previously
	 * been frozen by onSaveInstanceState(Bundle).
	 */
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		Toast.makeText(getBaseContext(), "onRestoreInstanceState ...BUNDLING",
				Toast.LENGTH_LONG).show();
	}

	/*
	 * protected void onSaveInstanceState(Bundle outState)
	 * 
	 * Called to retrieve per-instance state from an activity before being
	 * killed so that the state can be restored in onCreate(Bundle) or
	 * onRestoreInstanceState(Bundle) (the Bundle populated by this method will
	 * be passed to both). This method is called before an activity may be
	 * killed so that when it comes back some time in the future it can restore
	 * its state. For example, if activity B is launched in front of activity A,
	 * and at some point activity A is killed to reclaim resources, activity A
	 * will have a chance to save the current state of its user interface via
	 * this method so that when the user returns to activity A, the state of the
	 * user interface can be restored via: onCreate(Bundle) or
	 * onRestoreInstanceState(Bundle).
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Toast.makeText(getBaseContext(), "onSaveInstanceState ...BUNDLING",
				Toast.LENGTH_LONG).show();
	} // onSaveInstanceState
	
}//LyfeCicleDemo