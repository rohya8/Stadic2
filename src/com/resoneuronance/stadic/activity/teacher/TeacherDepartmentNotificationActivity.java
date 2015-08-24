package com.resoneuronance.stadic.activity.teacher;

import java.util.ArrayList;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.layout;
import com.resoneuronance.stadic.activity.student.StudentDepartmentNotificationActivity;
import com.resoneuronance.stadic.activity.student.StudentDepartmentNotificationsListActivity;
import com.resoneuronance.stadic.adapter.student.StudentDepartmentNotificationAdapter;
import com.resoneuronance.stadic.adapter.teacher.TeacherDepartmentNotificationAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class TeacherDepartmentNotificationActivity extends Activity {

	private ListView listview;

	ArrayList<String> objArrayListName = new ArrayList<String>();
	private ArrayList<Integer> objArrayListImage = new ArrayList<Integer>();
	ArrayList<String> objArrayListNotify_no = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_department_notification);

		initialise();


		objArrayListName.add("Computer");
		objArrayListName.add("Information Technology");
		objArrayListName.add("Electrical");
		objArrayListName.add("Mechanical");
		objArrayListName.add("ENTC");
		objArrayListName.add("Civil");
		objArrayListName.add("Instrumentaion");
		objArrayListName.add("Chemical");


		objArrayListImage.add(R.drawable.banking1);
		objArrayListImage.add(R.drawable.banking2);
		objArrayListImage.add(R.drawable.banking3);
		objArrayListImage.add(R.drawable.banking1);
		objArrayListImage.add(R.drawable.banking2);
		objArrayListImage.add(R.drawable.banking3);
		objArrayListImage.add(R.drawable.banking2);
		objArrayListImage.add(R.drawable.banking1);



		objArrayListNotify_no.add("1");
		objArrayListNotify_no.add("2");
		objArrayListNotify_no.add("3");
		objArrayListNotify_no.add("2");
		objArrayListNotify_no.add("2");
		objArrayListNotify_no.add("2");
		objArrayListNotify_no.add("2");
		objArrayListNotify_no.add("2");


		TeacherDepartmentNotificationAdapter Adapter = new TeacherDepartmentNotificationAdapter(this, objArrayListName,objArrayListImage,objArrayListNotify_no);
		listview.setAdapter(Adapter);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long id) {
				Intent intent=new Intent(TeacherDepartmentNotificationActivity.this,StudentDepartmentNotificationsListActivity.class);
				startActivity(intent);				
			}
		});

	}




	private void initialise() {
		listview = (ListView)findViewById(R.id.teacherdepartment_notification_list_listview);
	}



}
