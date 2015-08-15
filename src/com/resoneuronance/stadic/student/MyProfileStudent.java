package com.resoneuronance.stadic.student;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.id;
import com.resoneuronance.stadic.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MyProfileStudent extends Activity implements OnClickListener {

	private Button BtEditProfile,BtSaveProfile;
	private EditText EtEmail,EtPhone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_profile_student);


		intialise();

		BtEditProfile.setOnClickListener(this);
		BtSaveProfile.setOnClickListener(this);
	}

	private void intialise() {
		BtEditProfile=(Button) findViewById(R.id.mystudent_profile_edit_button);
		BtSaveProfile=(Button) findViewById(R.id.mystudent_profile_save_button);
		EtEmail=(EditText) findViewById(R.id.mystudent_profile_emailid_et);
		EtPhone=(EditText) findViewById(R.id.mystudent_profile_phoneno_et);

	}

	@Override
	public void onClick(View vw) {

		switch(vw.getId())
		{
		case R.id.mystudent_profile_edit_button:
			BtSaveProfile.setVisibility(View.VISIBLE);
			BtEditProfile.setVisibility(View.GONE);
			EtPhone.setEnabled(true);
			EtEmail.setEnabled(true);


			EtEmail.setFocusableInTouchMode(true);
			EtPhone.setFocusableInTouchMode(true);
			break;

		case R.id.mystudent_profile_save_button:
			BtEditProfile.setVisibility(View.VISIBLE);
			BtSaveProfile.setVisibility(View.GONE);
			EtPhone.setEnabled(false);
			EtEmail.setEnabled(false);


			break;

		}
	}
}
