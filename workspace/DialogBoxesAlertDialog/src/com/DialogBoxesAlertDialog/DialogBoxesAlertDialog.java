package com.DialogBoxesAlertDialog;

import com.DialogBoxesAlertDialog.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DialogBoxesAlertDialog extends Activity {
	Button btnGo;
	EditText txtMsg;
	String msg;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txtMsg =  (EditText)findViewById(R.id.txtMsg);
        
        btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				AlertDialog diaBox = makeAndShowDialogBox();
								
			    diaBox.show();
			    
			    //WARNING: (in general...)
			    //after showing a dialog you should have NO more 
			    //code. Let the buttons of the dialog box handle
			    //the rest of the logic. For instance, in this 
			    //example a modal dialog box is displayed (once shown
			    //you can not do anything to the parent until the
			    //child is closed) however the code in the parent 
			    //continues to execute after the show() method is 
			    //called.
			    Log.d("test","lalalala");
				txtMsg.setText("I am here!");
			}
        	
        });
    }//onCreate
    



	private AlertDialog makeAndShowDialogBox(){
    	
        AlertDialog myQuittingDialogBox = 

        	new AlertDialog.Builder(this) 
        	//set message, title, and icon
        	.setTitle("Terminator") 
        	.setMessage("Are you sure that you want to quit?") 
        	.setIcon(R.drawable.ic_menu_end_conversation)
        	
        	//set three option buttons
        	.setPositiveButton("Yes", new DialogInterface.OnClickListener() { 
        		public void onClick(DialogInterface dialog, int whichButton) { 
            	 //whatever should be done when answering "YES" goes here
        		 msg = "YES " + Integer.toString(whichButton);
        		 txtMsg.setText(msg);
        		}              
        	})//setPositiveButton
        	
        	.setNeutralButton("Cancel",	new DialogInterface.OnClickListener() {
        		public void onClick(DialogInterface dialog, int whichButton) {
               	 //whatever should be done when answering "CANCEL" goes here
        		 msg = "CANCEL " + Integer.toString(whichButton);
        		 txtMsg.setText(msg);
        		}//OnClick
        	})//setNeutralButton

        	.setNegativeButton("NO", new DialogInterface.OnClickListener() { 
        		public void onClick(DialogInterface dialog, int whichButton) { 
            	 //whatever should be done when answering "NO" goes here
        		 msg = "NO " + Integer.toString(whichButton);	
        		 txtMsg.setText(msg);
             } 
        	})//setNegativeButton
        	
        	.create();
        	
        	return myQuittingDialogBox;
    }
    
}//AndSelectionWidgets