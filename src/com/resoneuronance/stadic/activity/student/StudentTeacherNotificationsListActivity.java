package com.resoneuronance.stadic.activity.student;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.resoneuronance.campus.web.domain.Notification;
import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.adapter.student.StudentTeacherNotificationListAdapter;
import com.resoneuronance.stadic.task.ImageDownloadAsynctask;
import com.resoneuronance.stadic.util.StudentServerUtils;
import com.resoneuronance.stadic.util.StudentUtils;

public class StudentTeacherNotificationsListActivity extends Activity {

	private ListView listviewTeacherNotification ;	
	private ArrayList<String> objArrayListName = new ArrayList<String>();
	private ArrayList<Integer> objArrayListImage = new ArrayList<Integer>();
	private ArrayList<String> objArrayListNotifyNo = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_teacher_notification_list);
		
		for(Notification notification : StudentUtils.getTeacherNotifications(this)) {
			objArrayListName.add(notification.getNotification());
			objArrayListImage.add(R.drawable.notebook88);
			objArrayListNotifyNo.add(String.valueOf(notification.getId()));
		}

		listviewTeacherNotification = (ListView)findViewById(R.id.student_teacher_notification_list_listView);
		StudentTeacherNotificationListAdapter Adapter = new StudentTeacherNotificationListAdapter(this, objArrayListName,objArrayListImage,objArrayListNotifyNo);
		listviewTeacherNotification.setAdapter(Adapter);
		
		listviewTeacherNotification.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,long id) {
				Log.d("TAG", "Clicked on ID :" + position + ":" + objArrayListNotifyNo.get(position));
				new ImageDownloadAsynctask(StudentTeacherNotificationsListActivity.this).execute(StudentServerUtils.prepareDownloadUrl(objArrayListNotifyNo.get(position)),objArrayListNotifyNo.get(position));
			}
		});
		
	}

}
