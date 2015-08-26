package com.resoneuronance.stadic.activity.student;

import java.util.ArrayList;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.drawable;
import com.resoneuronance.stadic.R.id;
import com.resoneuronance.stadic.R.layout;
import com.resoneuronance.stadic.adapter.student.StudentDepartmentNotificationListAdapter;
import com.resoneuronance.stadic.task.ImageDownloadAsynctask;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class StudentDepartmentNotificationsListActivity extends Activity {

	private ListView ListviewDepartmentNotification ;	
	private ArrayList<String> objArrayListName = new ArrayList<String>();
	private ArrayList<Integer> objArrayListImage = new ArrayList<Integer>();
	private ArrayList<String> objArrayListNotifyNo = new ArrayList<String>();
	private String downloadUrl = "http://pngimg.com/upload/star_PNG1599.png";
	private String Filename1="STADIC1.png";



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_department_notification_list);

		objArrayListName.add("Defaulter List");
		objArrayListName.add("Time Table");
		objArrayListName.add("Exam Dates ");
		objArrayListName.add("Seminar Details");

		objArrayListImage.add(R.drawable.notebook88);
		objArrayListImage.add(R.drawable.notebook88);
		objArrayListImage.add(R.drawable.notebook88);
		objArrayListImage.add(R.drawable.notebook88);


		objArrayListNotifyNo.add("1");
		objArrayListNotifyNo.add("1");
		objArrayListNotifyNo.add("2");
		objArrayListNotifyNo.add("1");

		ListviewDepartmentNotification = (ListView)findViewById(R.id.studentdepartment_notification_list_listView);
		StudentDepartmentNotificationListAdapter Adapter = new StudentDepartmentNotificationListAdapter(this, objArrayListName,objArrayListImage,objArrayListNotifyNo);
		ListviewDepartmentNotification.setAdapter(Adapter);

		ListviewDepartmentNotification.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long id) {
				
				switch (position) {
				case 1:
					new ImageDownloadAsynctask(StudentDepartmentNotificationsListActivity.this).execute(downloadUrl,Filename1);
					
					break;

				}
				
			}
		});
	}

}
