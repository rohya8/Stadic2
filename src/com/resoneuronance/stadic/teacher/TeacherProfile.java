package com.resoneuronance.stadic.teacher;

import java.util.ArrayList;
import java.util.List;

import com.resoneuronance.stadic.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TeacherProfile extends Activity {

	private Spinner spinneryear,spinnerdept,spinnertype;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_profile);

		initialise();

		spinnerdata();
	}

	private void spinnerdata() {

		List<String> spyear=new ArrayList<String>();
		spyear.add(" F.E ");
		spyear.add(" S.E ");
		spyear.add(" T.E ");
		spyear.add(" B.E ");

		setspinnerdata(spinneryear,spyear);

		List<String> spdept=new ArrayList<String>();
		spdept.add(" Civil ");
		spdept.add(" Computer ");
		spdept.add(" Mechanical ");
		spdept.add(" Electronics ");

		setspinnerdata(spinnerdept,spdept);		

		List<String> sptype=new ArrayList<String>();
		sptype.add(" Notes ");
		sptype.add(" Assignment ");
		sptype.add(" Other ");

		setspinnerdata(spinnertype,sptype);

	}

	private void setspinnerdata(Spinner spinner, List<String> list) {

		ArrayAdapter <String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,list);
		spinner.setAdapter(adapter);	

	}

	private void initialise() {

		spinneryear=(Spinner) findViewById(R.id.spinnergroup_year);
		spinnerdept=(Spinner) findViewById(R.id.spinnergroup_dept);
		spinnertype=(Spinner) findViewById(R.id.spinnergroup_type);

	}

}
