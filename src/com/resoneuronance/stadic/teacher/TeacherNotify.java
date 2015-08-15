package com.resoneuronance.stadic.teacher;

import java.util.ArrayList;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.drawable;
import com.resoneuronance.stadic.R.id;
import com.resoneuronance.stadic.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class TeacherNotify extends Activity {


	private ListView listview;

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
		objArrayListName.add("Rajesh Mangale");
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
		objArrayListNotify_no.add("10");



		Teacher_Notify_customclass Adapter = new Teacher_Notify_customclass(this, objArrayListName,objArrayListImage,objArrayListNotify_no);
		listview.setAdapter(Adapter);


	}
}




