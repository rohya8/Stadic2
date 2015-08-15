package com.resoneuronance.stadic.main;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.admin.AdminProfile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdminLoginTab extends Activity implements OnClickListener {

	private Button BtAdminSubmit;
	private EditText EtAdminUserName,EtAdminPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adminlogintab);

		initialise();
		
		String abc;
		//TODO : Changes to be made to fetch colleges

		//TODO : Changes to be made to fetch colleges
		
		BtAdminSubmit.setOnClickListener(this);

	}

	private void initialise() {

		EtAdminUserName=(EditText) findViewById(R.id.editTextAdminUsername);
		EtAdminPassword=(EditText) findViewById(R.id.editTextAdminPassword);


		BtAdminSubmit=(Button) findViewById(R.id.buttonAdminSubmit);

	}

	@Override
	public void onClick(View view) {
		Intent intent=null;

		switch (view.getId()) {
		case R.id.buttonAdminSubmit:
			intent=new Intent(AdminLoginTab.this,AdminProfile.class);
			startActivity(intent);
			break;


		}


	}

}
