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
	//PopupActivity�D�{��
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//5��ĵ�ܤ��ʹ�ܵ����ƥ󪺿��W��
		CharSequence[] list = {
			"PopupWindow",
			"Dialog",
			"AlertDialog",
			"ProgressDialog",
			"Toast",
		};
		//�N5�ӿ��W�٦w�m�bListView01
		ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, list);
		ListView listView = (ListView)findViewById(R.id.ListView01);
		listView.setAdapter(adapter);
		//���U���W��(position)�A���������case�B�z
		listView.setOnItemClickListener(new OnItemClickListener() {		
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Button button = new Button(PopupActivity.this);
				switch (position) {
				//PopupWindowĵ�ܤ��ʹ�ܵ���
				case 0:
					button.setText("���U�N�i�H����PopupWindow");
					final PopupWindow popupWindow = new PopupWindow(PopupActivity.this);
					popupWindow.setContentView(button);
					popupWindow.setFocusable(true);
					popupWindow.setWidth(200);
					popupWindow.setHeight(100);
					popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
					//���U��ܵ�������PopupWindow����
					button.setOnClickListener(new OnClickListener() {				
						public void onClick(View v) {
							popupWindow.dismiss();
						}	
					});
					break;
				//Dialogĵ�ܤ��ʹ�ܵ���	
				case 1:
					button.setText("����Dialog");
					final Dialog dialog = new Dialog(PopupActivity.this);
					dialog.setTitle("�o�̥i�H�Ψ����Dialog�H��!");
					dialog.setContentView(button);
					dialog.show();
					//���U��ܵ����W�����s������Dialog����
					button.setOnClickListener(new OnClickListener() {	
						public void onClick(View v) {
							dialog.dismiss();
						}
					});
					break;					
				//AlterDialogĵ�ܤ��ʹ�ܵ���	
				case 2:
					Builder builder = new Builder(PopupActivity.this);
					builder.setTitle("AlertDialog");
					builder.setMessage("�o�̥i�H�Ψ����Alert�H���A�n��[�^�W��]��~�|����");
					builder.show();
					break;
				//ProgreeDialogĵ�ܤ��ʹ�ܵ���	
				case 3:
					final ProgressDialog progressDialog = ProgressDialog.show(PopupActivity.this, "�B�z��...", "�е��@�|�A�B�z�����|�۰ʵ���...");
					final Handler handler = new Handler();
					//�إ߳B�z�{��callback
					final Runnable callback = new Runnable() {			
						public void run() {
							progressDialog.dismiss();
						}	
					};
					//�إߤ@��Thread��Run�A��B�z�i�ק����ɡA����callback�{��������ProgreeDialog����
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
				//Toastĵ�ܤ��ʹ�ܵ���	
				case 4:
					Toast.makeText(PopupActivity.this, "�o�̥i�H�Ψ����Toast�H���A�u�ɶ��X�{��A�۰�����", Toast.LENGTH_SHORT).show();
					break;
				}
			}			
		});		
	}
}
