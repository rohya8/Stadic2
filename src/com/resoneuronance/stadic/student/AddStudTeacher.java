package com.resoneuronance.stadic.student;

import java.util.ArrayList;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.id;
import com.resoneuronance.stadic.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class AddStudTeacher extends Activity {

	private ListView listview;

	ArrayList<String> objArrayListName = new ArrayList<String>();

	ArrayList<String> objArrayListNotify_no = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_stud_teacher);

		initialise();

		listview_data();

	}

	private void listview_data() {
		objArrayListName.add("Rajesh Mangale");
		objArrayListName.add("Rohit Wadke");
		objArrayListName.add("Rajesh Mangale");
		objArrayListName.add("Rohit Wadke");
		objArrayListName.add("Rajesh Mangale");
		objArrayListName.add("Rohit Wadke");

		AddStudTeacher_customclass Adapter = new AddStudTeacher_customclass(this, objArrayListName);
		listview.setAdapter(Adapter);
	}

	private void initialise() {
		listview = (ListView)findViewById(R.id.addstudent_teacher_list_listview);



	}
}
