
package com.resoneuronance.stadic.main;

import javax.xml.datatype.Duration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.resoneuronance.campus.web.util.Constants;
import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.student.LoginAsynctask;
import com.resoneuronance.stadic.student.MainStudentProfile;
import com.resoneuronance.stadic.student.StudentServerUtils;

public class StudentloginTab extends Activity implements OnClickListener 
{

	/*private String[] mcollege = {"PES Modern College of Engineering","Fergusson College","AISSMS","Modern Edication Society'sCollege Of Engineering","Modern Edication Society'sCusrow Wadia Institute Of Technology","Modern Edication Society's Ness Wadia College Of Commerce","Raisonoi College of Engineering"
			,"P.V.G's College Of Engineering And Technology ","Pimpri Chinchwad Edication Trust's College Of Engineering"
			,"Sinhagad Technical Education Society's College Of  Architecture","Sinhagad Technical Education Society's College Of  Pharmacy "
			,"Sinhagad Technical Education Society's College Of  Engineering","Sinhagad Technical Education Society's Sinhgad College Of Science"
			,"Sinhagad Technical Education Society's Smt. Kashibai Nawale Women's College Of Engineering","Symbiosis Society's College Of Arts And Commerce,","Army Institute Of Technology College Of Engineering"
			,"College of Engineering Pune"};*/

	private AutoCompleteTextView collegename;

	String abc;
	private Button btStudentSubmit;
	private EditText etStudentUserName,etStudentPassword;

	private AutoCompleteTextView avCollegeName;


	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_studentlogintab);

		initialise();

		AutoCompleteTextviewMethod();

		btStudentSubmit.setOnClickListener(this);
	}


	private void initialise() {

		collegename = (AutoCompleteTextView)findViewById(R.id.collgename_autocomplete);

		etStudentUserName=(EditText) findViewById(R.id.editTextStudentUsername);
		etStudentPassword=(EditText) findViewById(R.id.editTextStudentPassword);
		avCollegeName = (AutoCompleteTextView) findViewById(R.id.collgename_autocomplete);

		btStudentSubmit=(Button) findViewById(R.id.buttonStudentSubmit);



	}


	private void AutoCompleteTextviewMethod() {

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,CoreServerUtils.colleges);

		collegename.setThreshold(1);
		collegename.setAdapter(adapter);

	}


	@Override
	public void onClick(View view) {

		switch (view.getId()) {
		case R.id.buttonStudentSubmit:
			CoreServerUtils.shareRegId(this);
			new LoginAsynctask(this).execute(etStudentUserName.getText().toString(),etStudentPassword.getText().toString(),avCollegeName.getText().toString());
			break;
		}
	}

}

