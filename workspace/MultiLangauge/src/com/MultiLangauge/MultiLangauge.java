package com.MultiLangauge;

import java.text.DecimalFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//aBMI is for British system
public class MultiLangauge extends Activity {
    private static final String TAG = "aBmi";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViews();
        setListensers();
    }

    private Button button_calc;
    private EditText field_feet;
    private EditText field_inch;
    private EditText field_weight;
    private TextView view_result;
    private TextView view_suggest;

    private void findViews() {
        Log.d(TAG, "find Views");
        button_calc = (Button) findViewById(R.id.submit);
        field_feet = (EditText) findViewById(R.id.feet);
        field_inch = (EditText) findViewById(R.id.inch);
        field_weight = (EditText) findViewById(R.id.weight);
        view_result = (TextView) findViewById(R.id.result);
        view_suggest = (TextView) findViewById(R.id.suggest);
    }

    //Listen for button clicks
    private void setListensers() {
        Log.d(TAG, "set Listensers");
        button_calc.setOnClickListener(calcUsBMI);
    }

    private Button.OnClickListener calcUsBMI = new Button.OnClickListener() {
        public void onClick(View v) {
            DecimalFormat nf = new DecimalFormat("0.00");
            try {
                double height = (Double.parseDouble(field_feet.getText().toString())*12+Double.parseDouble(field_inch.getText().toString()))*2.54/100;
                double weight = Double.parseDouble(field_weight.getText().toString())*0.45359;
                double BMI = weight / (height * height);
                //Present result
                 view_result.setText(getText(R.string.bmi_result) + nf.format(BMI));

                //Give health advice
                if(BMI > 27) {
                    view_suggest.setText(R.string.advice_fat);
                } else if(BMI > 25) {
                     view_suggest.setText(R.string.advice_heavy);
                } else if(BMI < 20) {
                     view_suggest.setText(R.string.advice_light);
                } else {
                     view_suggest.setText(R.string.advice_average);
                }
            } catch(Exception obj) {
                Toast.makeText(MultiLangauge.this, getString(R.string.input_error), Toast.LENGTH_SHORT).show();
            }
        }
    };

    protected static final int MENU_ABOUT = Menu.FIRST;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        Log.d(TAG, "open Menu");
        menu.add(0, MENU_ABOUT, 0, R.string.about_label);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        Log.d(TAG, "select Menu Item");
        switch(item.getItemId()) {
            case MENU_ABOUT:
                openOptionsDialog();
                break;
        }
        return true;
    }

    private void openOptionsDialog() {
        Log.d(TAG, "open Dialog");
        new AlertDialog.Builder(this)
            .setTitle(R.string.about_title)//.setView(view)
            .setMessage(R.string.about_msg)
            .setPositiveButton(R.string.ok_label,
                new DialogInterface.OnClickListener(){
                    public void onClick(
                        DialogInterface dialoginterface, int i){
                        }
             })
             .show();
    }
}