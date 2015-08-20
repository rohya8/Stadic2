package com.resoneuronance.stadic.student;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.resoneuronance.campus.web.bo.domain.Student;
import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.department.DepartmentNotify;
import com.resoneuronance.stadic.student.notification.TeacherNotify;

public class StudentProfile extends Activity{


	private ListView listview;
	private Student student;
	ArrayList<String> objArrayListName = new ArrayList<String>();
	ArrayList<Integer> objArrayListImage = new ArrayList<Integer>();
	ArrayList<String> objArrayListNotify_no = new ArrayList<String>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_profile);

		initialise();

		listview_data();

		listview.setOnItemClickListener(new OnItemClickListener() 
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) 

			{
				if(position==0)
				{
					Intent i = new Intent(StudentProfile.this,TeacherNotify.class);
					startActivity(i);
				}

				if(position==1)
				{
					Intent i = new Intent(StudentProfile.this,DepartmentNotify.class);
					startActivity(i);
				}

			}
		});



	}


	private void listview_data() {

		objArrayListName.add("Teacher");
		objArrayListName.add("Department");

		objArrayListImage.add(R.drawable.userprofile128);
		objArrayListImage.add(R.drawable.house128);

		student = StudentServerUtils.getCurrentStudent(this);
		objArrayListNotify_no.add(String.valueOf(student.getTeacherNotificationsCount()));
		objArrayListNotify_no.add(String.valueOf(student.getDepartmentNotificationsCount()));

		StudentProfileAdapter Adapter = new StudentProfileAdapter(this, objArrayListName,objArrayListImage,objArrayListNotify_no);
		listview.setAdapter(Adapter);

	}


	private void initialise() {

		listview = (ListView)findViewById(R.id.student_profile_listview);

	}


}