package com.resoneuronance.stadic.activity.student;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.resoneuronance.campus.web.domain.Notification;
import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.adapter.student.StudentTeacherNotificationListAdapter;
import com.resoneuronance.stadic.util.StudentUtils;

public class StudentTeacherNotificationsListActivity extends Activity {

	private ListView ListviewTeacherNotification ;	
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
			objArrayListNotifyNo.add("1");
		}

		ListviewTeacherNotification = (ListView)findViewById(R.id.student_teacher_notification_list_listView);
		StudentTeacherNotificationListAdapter Adapter = new StudentTeacherNotificationListAdapter(this, objArrayListName,objArrayListImage,objArrayListNotifyNo);
		ListviewTeacherNotification.setAdapter(Adapter);
	}

}
