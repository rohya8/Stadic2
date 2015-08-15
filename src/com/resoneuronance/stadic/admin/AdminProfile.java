package com.resoneuronance.stadic.admin;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.student.StudentProfile;
import com.resoneuronance.stadic.student.StudentProfileAdapter;
import com.resoneuronance.stadic.student.notification.TeacherNotify;

public class AdminProfile extends Activity {

	private ListView listview;

	ArrayList<String> objArrayListName = new ArrayList<String>();
	ArrayList<Integer> objArrayListImage = new ArrayList<Integer>();
	ArrayList<String> objArrayListNotify_no = new ArrayList<String>();



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_profile);

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
					//Intent i = new Intent(StudentProfile.this,TeacherNotify.class);
					//startActivity(i);

				}

				if(position==1)
				{
					//Intent i = new Intent(StudentProfile.this,Departmentnotify.class);
					//startActivity(i);

				}

			}
		});



	}



	private void listview_data() {

		objArrayListName.add("Curricular Activities");
		objArrayListName.add("Co-Curricular Activities");

		objArrayListImage.add(R.drawable.userprofile128);
		objArrayListImage.add(R.drawable.house128);

		objArrayListNotify_no.add("12");
		objArrayListNotify_no.add("10");


		AdminProfileAdapter Adapter = new AdminProfileAdapter(this, objArrayListName,objArrayListImage,objArrayListNotify_no);
		listview.setAdapter(Adapter);

	}



	private void initialise() {

		listview = (ListView)findViewById(R.id.admin_profile_listview);
	}

}
