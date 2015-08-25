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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.domain.DepartmentName;

public class StudentDepartmentActivity extends Activity {

	private ListView listview;
	StudentDepartmentAdapter dataAdapter = null;

	ImageView btadd,btdel;


	ArrayList<String> objArrayListName = new ArrayList<String>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_department_optionsactivity);

		initialise();

		displayListView();

		btadd.setOnClickListener(new OnClickListener() 
		{


			@Override
			public void onClick(View arg0) {

				Intent i=new Intent(StudentDepartmentActivity.this,StudentAddDepartmentActivity.class);
				startActivity(i);

			}
		});


		btdel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent i=new Intent(StudentDepartmentActivity.this,StudentDeleteDepartmentActivity.class);
				startActivity(i);

			}
		});


	}


	private void initialise() {
		listview = (ListView)findViewById(R.id.student_department_optionsactivity_listView);
		btadd=(ImageView) findViewById(R.id.student_department_optionsactivity_add_imagebutton);
		btdel=(ImageView) findViewById(R.id.student_department_optionsactivity_delete_imagebutton);


	}

	private void displayListView() 
	{

		//Array list of countries
		ArrayList<DepartmentName> departmentList = new ArrayList<DepartmentName>();

		DepartmentName departmentnm = new DepartmentName("Computer",false);
		departmentList.add(departmentnm);
		departmentnm = new DepartmentName("Information Technology",false);
		departmentList.add(departmentnm);
		departmentnm = new DepartmentName("Electrical",false);
		departmentList.add(departmentnm);
		departmentnm = new DepartmentName("ENTC",false);
		departmentList.add(departmentnm);
		departmentnm = new DepartmentName("Instrumentaion",false);
		departmentList.add(departmentnm);
		departmentnm = new DepartmentName("Chemical",false);
		departmentList.add(departmentnm);


		//create an ArrayAdaptar from the String Array
		dataAdapter = new StudentDepartmentAdapter(this,
				R.layout.activity_student_teacher_adapter, departmentList);
		listview = (ListView) findViewById(R.id.student_department_optionsactivity_listView);
		// Assign adapter to ListView

		listview.setTextFilterEnabled(true);
		listview.setAdapter(dataAdapter);



	}


	private class StudentDepartmentAdapter extends ArrayAdapter<DepartmentName> 
	{

		private ArrayList<DepartmentName> departmentList;



		public StudentDepartmentAdapter(Context context, int textViewResourceId, 
				ArrayList<DepartmentName> departmentList) 
		{
			super(context, textViewResourceId, departmentList);
			this.departmentList = new ArrayList<DepartmentName>();
			this.departmentList.addAll(departmentList);
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

			DepartmentName department = departmentList.get(position);
			holder.name.setText(department.getName());

			return convertView;

		}

	}



}
