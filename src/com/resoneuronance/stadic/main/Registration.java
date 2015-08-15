package com.resoneuronance.stadic.main;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.admin.AdminProfile;

public class Registration extends Activity  implements OnItemSelectedListener{

	private Spinner SpinnerYear;
	private TextView TvLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		initialise();
		spinnerdata();


		TvLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent=new Intent(Registration.this,LoginMain.class);
				startActivity(intent);

			}
		});
	}

	private void spinnerdata() {

		List<String> spcollegename=new ArrayList<String>();
		spcollegename.add(" College Name ");
		spcollegename.add(" Modern College Of Engineering ");
		spcollegename.add(" P.V.G  ");
		spcollegename.add(" FC ");
		spcollegename.add(" College Of Engineering ");
		spcollegename.add(" Modern College Of Engineering ");
		spcollegename.add(" P.V.G  ");
		spcollegename.add(" FC ");
		spcollegename.add(" College Of Engineering ");


		//setspinnerdata(SpinnerYear,spcollegename);

		ArrayAdapter <String> adapter1= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,spcollegename);
		//adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		SpinnerYear.setAdapter(adapter1);	

	}


	private void initialise() {

		SpinnerYear=(Spinner) findViewById(R.id.registration_spinnergroup_collegenm);

		TvLogin=(TextView) findViewById(R.id.registeration_login_tv);
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}



}
