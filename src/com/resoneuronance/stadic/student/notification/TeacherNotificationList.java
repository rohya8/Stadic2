package com.resoneuronance.stadic.student.notification;

import java.util.ArrayList;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.drawable;
import com.resoneuronance.stadic.R.id;
import com.resoneuronance.stadic.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class TeacherNotificationList extends Activity {

	private ListView ListviewTeacherNotification ;	
	private ArrayList<String> objArrayListName = new ArrayList<String>();
	private ArrayList<Integer> objArrayListImage = new ArrayList<Integer>();
	private ArrayList<String> objArrayListNotifyNo = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_notification_list);

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

		ListviewTeacherNotification = (ListView)findViewById(R.id.teacher_notification_list_listView);
		TeacherNotificationListAdapter Adapter = new TeacherNotificationListAdapter(this, objArrayListName,objArrayListImage,objArrayListNotifyNo);
		ListviewTeacherNotification.setAdapter(Adapter);
	}

}
