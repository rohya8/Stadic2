package com.resoneuronance.stadic.student.notification;

import java.util.ArrayList;

import com.resoneuronance.campus.web.bo.domain.Student;
import com.resoneuronance.campus.web.bo.domain.StudentTeacher;
import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.student.StudentServerUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class TeacherNotify extends Activity {


	private ListView listview;
	private Student student;
	ArrayList<String> objArrayListName = new ArrayList<String>();
	ArrayList<Integer> objArrayListImage = new ArrayList<Integer>();
	ArrayList<String> objArrayListNotify_no = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_notify);

		initialise();

		listview_data();


	}

	private void initialise() {

		listview = (ListView)findViewById(R.id.teacher_notify_list_listview);
	}

	private void listview_data(){
		
		student = StudentServerUtils.getCurrentStudent(this);
		for(StudentTeacher teacher: student.getTeachers()) {
			objArrayListName.add(teacher.getName());
			objArrayListImage.add(R.drawable.male1);
			objArrayListNotify_no.add(String.valueOf(teacher.getNotifications().size()));
		}
		
		/*objArrayListName.add("Rajesh Mangale");
		objArrayListName.add("Rohit Wadke");
		objArrayListName.add("Rajesh Mangale");
		objArrayListName.add("Rohit Wadke");
		objArrayListName.add("Rajesh Mangale");
		objArrayListName.add("Rohit Wadke");

		objArrayListImage.add(R.drawable.male1);
		objArrayListImage.add(R.drawable.male1);
		objArrayListImage.add(R.drawable.male1);
		objArrayListImage.add(R.drawable.male1);
		objArrayListImage.add(R.drawable.male1);
		objArrayListImage.add(R.drawable.male1);



		objArrayListNotify_no.add("12");
		objArrayListNotify_no.add("10");
		objArrayListNotify_no.add("12");
		objArrayListNotify_no.add("10");
		objArrayListNotify_no.add("12");
		objArrayListNotify_no.add("10");*/



		TeacherNotifyAdapter Adapter = new TeacherNotifyAdapter(this, objArrayListName,objArrayListImage,objArrayListNotify_no);
		listview.setAdapter(Adapter);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long id) {
				Intent intent=new Intent(TeacherNotify.this,TeacherNotificationList.class);
				startActivity(intent);

			}
		});
	}
}




