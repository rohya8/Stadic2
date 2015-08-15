package com.resoneuronance.stadic.student;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.department.DepartmentNotify;
import com.resoneuronance.stadic.student.notification.AddStudDepartment;
import com.resoneuronance.stadic.student.notification.AddStudTeacher;
import com.resoneuronance.stadic.student.notification.TeacherNotify;

public class StudentProfile extends Activity implements OnClickListener {


	private ListView listview;
	private Button BtAddTeacher,BtAddDept;

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

		BtAddDept.setOnClickListener(this);
		BtAddTeacher.setOnClickListener(this);

	}


	private void listview_data() {

		objArrayListName.add("Teacher");
		objArrayListName.add("Department");

		objArrayListImage.add(R.drawable.userprofile128);
		objArrayListImage.add(R.drawable.house128);

		objArrayListNotify_no.add("12");
		objArrayListNotify_no.add("10");


		StudentProfileAdapter Adapter = new StudentProfileAdapter(this, objArrayListName,objArrayListImage,objArrayListNotify_no);
		listview.setAdapter(Adapter);

	}


	private void initialise() {

		listview = (ListView)findViewById(R.id.student_profile_listview);
		BtAddTeacher=(Button) findViewById(R.id.student_profile_Addteachr_button);
		BtAddDept=(Button) findViewById(R.id.student_profile_Adddeparment_button);

	}


	@Override
	public void onClick(View view) {

		switch(view.getId())
		{
		case R.id.student_profile_Adddeparment_button:
			Intent i = new Intent(StudentProfile.this,AddStudDepartment.class);
			startActivity(i);
			break;

		case R.id.student_profile_Addteachr_button:
			Intent i1 = new Intent(StudentProfile.this,AddStudTeacher.class);
			startActivity(i1);

			break;

		}
	}
}