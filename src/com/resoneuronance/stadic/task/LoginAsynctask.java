package com.resoneuronance.stadic.task;

import com.google.gson.Gson;
import com.resoneuronance.campus.web.bo.domain.Student;
import com.resoneuronance.campus.web.util.Constants;
import com.resoneuronance.stadic.activity.student.StudentLoginTabActivity;
import com.resoneuronance.stadic.activity.student.StudentMainActivity;
import com.resoneuronance.stadic.util.CoreServerUtils;
import com.resoneuronance.stadic.util.GCMUtil;
import com.resoneuronance.stadic.util.StudentServerUtils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;


public class LoginAsynctask extends AsyncTask<String, String, String> {

	Activity mlogin;
	ProgressDialog progressdialog;
	private String username,password,response=null;
	private String collegeName;


	public LoginAsynctask(Activity mainActivity) {

		mlogin=mainActivity;
		progressdialog=new ProgressDialog(mlogin);

	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();

		progressdialog.setMessage("Please Wait...");
		progressdialog.setCancelable(false);
		progressdialog.show();
	}

	@Override
	protected String doInBackground(String... args) {
		username=args[0];
		password=args[1];
		collegeName = args[2];
		String result = StudentServerUtils.studentLogin(username, password, collegeName);
		if(!Constants.RESPONSE_INVALID.equals(result)) {
			CoreServerUtils.shareRegId(mlogin,new Gson().fromJson(result, Student.class));
			
		}
		return result;
	}


	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		progressdialog.dismiss();
		if(!result.equalsIgnoreCase(Constants.RESPONSE_INVALID)){
			Toast.makeText(mlogin, "Login Successfull !!!", Toast.LENGTH_LONG).show();
			StudentServerUtils.storeCurrentStudent(mlogin, result);
			Intent i=new Intent(mlogin,StudentMainActivity.class);
			mlogin.startActivity(i);

		}
		else
		{
			Toast.makeText(mlogin, "Invalid Credentials", Toast.LENGTH_LONG).show();
		}
	}

}
