package com.MenuSubMenu;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MenuSubMenu extends Activity {

	TextView text0;
	EditText text1;
	RadioButton radio1;
	RadioButton radio2;
	ListView    list1;
	ArrayList<String> arrOptions;
	ArrayAdapter<String> adaOptions;

	final int PICK1 = Menu.FIRST;
	final int PICK2 = Menu.FIRST + 1;
	final int PICK3 = Menu.FIRST + 2;
	final int PICK4 = Menu.FIRST + 3;

	    @Override
	    public void onCreate(Bundle savedInstanceState) { 
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);

	        text0 = (TextView)findViewById(R.id.text0);
	        text1 = (EditText)findViewById(R.id.text1);
	        radio1 =(RadioButton)findViewById(R.id.radio1);
	        radio2 =(RadioButton)findViewById(R.id.radio2);
	        list1 = (ListView)findViewById(R.id.list1);        
	        
	        //show history of all selected options
	        arrOptions = new ArrayList<String>();
	        adaOptions = new ArrayAdapter<String>(
	        				this, 
					R.layout.main1,
	        				arrOptions);
	        list1.setAdapter(adaOptions);

	        //long-press menu for list and textbox
	        registerForContextMenu(list1);
	        registerForContextMenu(text1);

	    }//onCreate
	    
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {

	    super.onCreateOptionsMenu(menu);
	    MenuItem item1 = menu.add(0, PICK1, Menu.NONE, "Option UNO");
	    MenuItem item2 = menu.add(0, PICK2, Menu.NONE, "Option DOS");
	    MenuItem item3 = menu.add(0, PICK3, Menu.NONE, "Option TRES");
	    MenuItem item4 = menu.add(0, PICK4, Menu.NONE, "Option CUATRO");
	    //set icons 
	    item1.setIcon(R.drawable.uno);
	    item2.setIcon(R.drawable.dos);
	    item3.setIcon(R.drawable.tres);
	    item4.setIcon(R.drawable.cuatro);

	    //shortcuts using device’s keyboard-keypad
	    item1.setShortcut('1', 'u');
	    item2.setShortcut('2', 'd');
	    item3.setShortcut('3', 't');
	    item4.setShortcut('4', 'c');
	    
	    // adding a sub-menu as fifth entry of this menu
	    SubMenu mySubMenu5 =  menu.addSubMenu(0, 0, Menu.NONE, "Sub-Menu-CINCO");
	    mySubMenu5.setHeaderIcon(R.drawable.cinco);
	    mySubMenu5.setIcon(R.drawable.cinco);
	    
	    return true;

	    }//onCreateOptionsMenu
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	    try {
	        	super.onOptionsItemSelected(item);
	        	//title to display is taken from current menu item
	        	String msg= item.getTitle().toString();
	        	//add selection to historical array and show in listview
	        	arrOptions.add(msg);
	        	adaOptions.notifyDataSetChanged();
	        
	        	//values in the green TextView box include:
	        	msg += "\n" + "radio1:  " + Boolean.toString(radio1.isChecked());
	        	msg += "\n" + "radio2:  " + Boolean.toString(radio2.isChecked());
	        	msg += "\n" + "Text:    " + text1.getText();
	        	text0.setText("Menu: " + msg);    
	        }
	        catch (Exception e) {
	           	text0.setText(e.getMessage());
	        }
	        return false;
	    }//onOptionsItemSelected
	  //this is a floating context menu that appears when user 
	  //clicks down for a while (about 2 sec) on the textbox or list

	  @Override
	  public void onCreateContextMenu(ContextMenu menu, View v,
	  			      ContextMenuInfo menuInfo) {
	  super.onCreateContextMenu(menu, v, menuInfo);

	  //add a couple of options to the context menu
	  menu.setHeaderTitle("Select Special Action");
	  menu.add(0, PICK1, Menu.NONE, "Option-1 UNO special");
	  menu.add(0, PICK2, Menu.NONE, "Option-2 DOS special");

	  }//onCreateContextMenu
	// selecting options from the context menu
	  @Override
	  public boolean onContextItemSelected(MenuItem item) {
	  super.onContextItemSelected(item);

	  String msg = item.getTitle().toString();
	  text0.setText(msg);
	  arrOptions.add(msg);
	  adaOptions.notifyDataSetChanged();
	  return false;

	  }//onContextItemSelected
}