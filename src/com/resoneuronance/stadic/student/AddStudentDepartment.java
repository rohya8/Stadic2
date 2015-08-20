package com.resoneuronance.stadic.student;

import java.util.ArrayList;

import com.resoneuronance.stadic.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class AddStudentDepartment extends Activity {

	private ListView listview;

	ArrayList<String> objArrayListName = new ArrayList<String>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_student_department);

		initialise();

		listview_data();


	}

	private void listview_data() {
		objArrayListName.add("Computer");
		objArrayListName.add("Information Technology");
		objArrayListName.add("Electrical");
		objArrayListName.add("Mechanical");
		objArrayListName.add("ENTC");
		objArrayListName.add("Civil");
		objArrayListName.add("Instrumentaion");
		objArrayListName.add("Chemical");



		AddStudentDepartmentAdapter Adapter = new AddStudentDepartmentAdapter(this, objArrayListName);
		listview.setAdapter(Adapter);
	}

	private void initialise() {
		listview = (ListView)findViewById(R.id.addstudent_department_list_listview);

	}
}
