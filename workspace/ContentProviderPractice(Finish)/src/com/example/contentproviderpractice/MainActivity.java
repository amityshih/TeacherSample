package com.example.contentproviderpractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.Contacts.People.Phones;

import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	String[] phoneInfo_Name,phoneInfo_Number ;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ContentResolver cr = getContentResolver();
        // Query聯絡人資料，並將結果儲存在Cursor中
        Cursor c = cr.query(Contacts.Phones.CONTENT_URI, null, null, null, null);
        phoneInfo_Name = new String[c.getCount()];
        phoneInfo_Number = new String[c.getCount()];
        // 先看抓取之 cusor 是否有資料
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Map<String, Object> item;        
        if (c.moveToFirst()) {
            int nameColumn = c.getColumnIndex(Phones.NAME); 
            int phoneColumn = c.getColumnIndex(Phones.NUMBER);
            int index = 0;
            do {
            	item = new HashMap<String, Object>();
        		phoneInfo_Name[index] = c.getString(nameColumn);
                phoneInfo_Number[index] = c.getString(phoneColumn);
                item.put("column00", phoneInfo_Name[index]);
                item.put("column01", phoneInfo_Number[index]);
                data.add(item);
                index++;
            } while (c.moveToNext());
        }
        ListView mListView01 = new ListView(this);
    	SimpleAdapter adapter = new SimpleAdapter(this, data,
		R.layout.activity_main, new String[] {"column00", "column01"}, new int[] {
				R.id.TextView01, R.id.TextView02 });
    	mListView01.setAdapter(adapter);
    	setContentView(mListView01);   
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
