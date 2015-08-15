package com.resoneuronance.stadic.student;

import java.util.ArrayList;

import com.resoneuronance.stadic.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class AddStudDepartment extends Activity {

	private ListView listview;

	ArrayList<String> objArrayListName = new ArrayList<String>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_stud_department);

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



		AddStud_Department_customclass Adapter = new AddStud_Department_customclass(this, objArrayListName);
		listview.setAdapter(Adapter);
	}

	private void initialise() {
		listview = (ListView)findViewById(R.id.addstudent_department_list_listview);

	}
}
