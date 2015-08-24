package com.resoneuronance.stadic.activity.student;

import java.util.ArrayList;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.id;
import com.resoneuronance.stadic.R.layout;
import com.resoneuronance.stadic.adapter.student.StudentDepartmentNotificationAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class StudentDepartmentNotificationActivity extends Activity {

	private ListView listview;

	ArrayList<String> objArrayListName = new ArrayList<String>();

	ArrayList<String> objArrayListNotify_no = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_department_notification);


		initialise();


		objArrayListName.add("Computer");
		objArrayListName.add("Information Technology");
		objArrayListName.add("Electrical");
		objArrayListName.add("Mechanical");
		objArrayListName.add("ENTC");
		objArrayListName.add("Civil");
		objArrayListName.add("Instrumentaion");
		objArrayListName.add("Chemical");


		objArrayListNotify_no.add("1");
		objArrayListNotify_no.add("2");
		objArrayListNotify_no.add("3");
		objArrayListNotify_no.add("2");
		objArrayListNotify_no.add("2");
		objArrayListNotify_no.add("2");
		objArrayListNotify_no.add("2");
		objArrayListNotify_no.add("2");


		StudentDepartmentNotificationAdapter Adapter = new StudentDepartmentNotificationAdapter(this, objArrayListName,objArrayListNotify_no);
		listview.setAdapter(Adapter);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long id) {
				Intent intent=new Intent(StudentDepartmentNotificationActivity.this,StudentDepartmentNotificationsListActivity.class);
				startActivity(intent);				
			}
		});


	}


	private void initialise() {
		// TODO Auto-generated method stub
		listview = (ListView)findViewById(R.id.studentdepartment_notification_list_listview);
	}



}
