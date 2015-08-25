package com.resoneuronance.stadic.activity.student;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.domain.TeacherName;

public class StudentTeacherActivity extends Activity {

	private ListView listview;
	StudentTeacherAdapter dataAdapter = null;

	ImageView btadd,btdel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_teacher_opttionsactivity);

		initialise();

		displayListView();

		btadd.setOnClickListener(new OnClickListener() 
		{


			@Override
			public void onClick(View arg0) {

				Intent i=new Intent(StudentTeacherActivity.this,StudentAddTeacherActivity.class);
				startActivity(i);

			}
		});


		btdel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent i=new Intent(StudentTeacherActivity.this,StudentDeleteTeacherActivity.class);
				startActivity(i);

			}
		});



	}


	private void initialise() {
		listview = (ListView)findViewById(R.id.student_teachers_optionsactivity_listView);


		btadd=(ImageView) findViewById(R.id.student_teachers_optionsactivity_add_imagebutton);
		btdel=(ImageView) findViewById(R.id.student_teachers_optionsactivity_delete_imagebutton);

	}


	private void displayListView() 
	{

		//Array list of countries
		ArrayList<TeacherName> teacherList = new ArrayList<TeacherName>();

		TeacherName teachernm = new TeacherName("Rajesh Mangale",false);
		teacherList.add(teachernm);
		teachernm = new TeacherName("Rohit",false);
		teacherList.add(teachernm);
		teachernm = new TeacherName("Mangale",false);
		teacherList.add(teachernm);
		teachernm = new TeacherName("Rajesh",false);
		teacherList.add(teachernm);
		teachernm = new TeacherName("rohit",false);
		teacherList.add(teachernm);
		teachernm = new TeacherName("rW",false);
		teacherList.add(teachernm);


		//create an ArrayAdaptar from the String Array
		dataAdapter = new StudentTeacherAdapter(this,
				R.layout.activity_student_teacher_adapter, teacherList);
		ListView listView = (ListView) findViewById(R.id.student_teachers_optionsactivity_listView);
		// Assign adapter to ListView

		listView.setTextFilterEnabled(true);
		listView.setAdapter(dataAdapter);

	}


	private class StudentTeacherAdapter extends ArrayAdapter<TeacherName> 
	{

		private ArrayList<TeacherName> teacherList;

		public StudentTeacherAdapter(Context context, int textViewResourceId, 
				ArrayList<TeacherName> teacherList) 
		{
			super(context, textViewResourceId, teacherList);
			this.teacherList = new ArrayList<TeacherName>();
			this.teacherList.addAll(teacherList);
		}

		private class ViewHolder {
			TextView name;

		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder = null;

			if (convertView == null) {
				LayoutInflater vi = (LayoutInflater)getSystemService(
						Context.LAYOUT_INFLATER_SERVICE);
				convertView = vi.inflate(R.layout.activity_student_teacher_adapter, null);

				holder = new ViewHolder();
				holder.name = (TextView) convertView.findViewById(R.id.student_teacher_adapter_textView);
				convertView.setTag(holder);

			} 
			else {
				holder = (ViewHolder) convertView.getTag();
			}

			TeacherName teacher = teacherList.get(position);
			holder.name.setText(teacher.getName());

			return convertView;

		}

	}

}
