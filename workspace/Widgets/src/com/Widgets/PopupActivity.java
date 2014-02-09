package com.Widgets;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class PopupActivity extends Activity {
	//PopupActivity主程式
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//5個警示互動對話視窗事件的選單名稱
		CharSequence[] list = {
			"PopupWindow",
			"Dialog",
			"AlertDialog",
			"ProgressDialog",
			"Toast",
		};
		//將5個選單名稱安置在ListView01
		ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, list);
		ListView listView = (ListView)findViewById(R.id.ListView01);
		listView.setAdapter(adapter);
		//按下選單名稱(position)，跳到相關的case處理
		listView.setOnItemClickListener(new OnItemClickListener() {		
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Button button = new Button(PopupActivity.this);
				switch (position) {
				//PopupWindow警示互動對話視窗
				case 0:
					button.setText("按下就可以關閉PopupWindow");
					final PopupWindow popupWindow = new PopupWindow(PopupActivity.this);
					popupWindow.setContentView(button);
					popupWindow.setFocusable(true);
					popupWindow.setWidth(200);
					popupWindow.setHeight(100);
					popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
					//按下對話視窗關閉PopupWindow視窗
					button.setOnClickListener(new OnClickListener() {				
						public void onClick(View v) {
							popupWindow.dismiss();
						}	
					});
					break;
				//Dialog警示互動對話視窗	
				case 1:
					button.setText("關閉Dialog");
					final Dialog dialog = new Dialog(PopupActivity.this);
					dialog.setTitle("這裡可以用來顯示Dialog信息!");
					dialog.setContentView(button);
					dialog.show();
					//按下對話視窗上的按鈕來關閉Dialog視窗
					button.setOnClickListener(new OnClickListener() {	
						public void onClick(View v) {
							dialog.dismiss();
						}
					});
					break;					
				//AlterDialog警示互動對話視窗	
				case 2:
					Builder builder = new Builder(PopupActivity.this);
					builder.setTitle("AlertDialog");
					builder.setMessage("這裡可以用來顯示Alert信息，要按[回上頁]鍵才會關閉");
					builder.show();
					break;
				//ProgreeDialog警示互動對話視窗	
				case 3:
					final ProgressDialog progressDialog = ProgressDialog.show(PopupActivity.this, "處理中...", "請等一會，處理完畢會自動結束...");
					final Handler handler = new Handler();
					//建立處理程式callback
					final Runnable callback = new Runnable() {			
						public void run() {
							progressDialog.dismiss();
						}	
					};
					//建立一個Thread來Run，當處理進度完畢時，執行callback程式來關閉ProgreeDialog視窗
					Thread thread = new Thread() {				
						@Override
						public void run() {
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							handler.post(callback);
						}		
					};
					thread.start();
					break;
				//Toast警示互動對話視窗	
				case 4:
					Toast.makeText(PopupActivity.this, "這裡可以用來顯示Toast信息，短時間出現後，自動關閉", Toast.LENGTH_SHORT).show();
					break;
				}
			}			
		});		
	}
}
