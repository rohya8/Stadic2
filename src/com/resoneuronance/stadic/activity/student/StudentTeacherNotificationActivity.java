package com.resoneuronance.stadic.activity.student;

import java.util.ArrayList;

import org.apache.commons.collections.CollectionUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.resoneuronance.campus.web.bo.domain.Student;
import com.resoneuronance.campus.web.bo.domain.StudentTeacher;
import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.adapter.student.StudentTeacherNotificationAdapter;
import com.resoneuronance.stadic.util.StudentUtils;

public class StudentTeacherNotificationActivity extends Activity {


	private ListView listview;
	private Student student;
	private ArrayList<String> objArrayListName = new ArrayList<String>();
	private ArrayList<Integer> objArrayListImage = new ArrayList<Integer>();
	private ArrayList<String> objArrayListNotify_no = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_teacher_notification);

		initialise();

		listview_data();


	}

	private void initialise() {

		listview = (ListView)findViewById(R.id.student_teacher_notification_listview);
	}

	private void listview_data(){

		student = StudentUtils.getCurrentStudent(this);
		for(StudentTeacher teacher: student.getTeachers()) {
			objArrayListName.add(teacher.getName());
			objArrayListImage.add(R.drawable.male1);
			objArrayListNotify_no.add(String.valueOf(teacher.getNotifications().size()));
		}


		StudentTeacherNotificationAdapter Adapter = new StudentTeacherNotificationAdapter(this, objArrayListName,objArrayListImage,objArrayListNotify_no);
		listview.setAdapter(Adapter);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,long id) {
				Intent intent=new Intent(StudentTeacherNotificationActivity.this,StudentTeacherNotificationsListActivity.class);
				if(CollectionUtils.isNotEmpty(student.getTeachers())) {
					StudentTeacher teacher = student.getTeachers().get(position);
					if(teacher != null) {
						StudentUtils.storeCurrentTeacherId(getApplicationContext(),teacher.getId());
					}
				}
				startActivity(intent);

			}
		});
	}
}




