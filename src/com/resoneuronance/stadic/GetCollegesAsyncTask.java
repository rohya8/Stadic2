package com.resoneuronance.stadic;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.resoneuronance.stadic.main.CoreServerUtils;
import com.resoneuronance.stadic.student.MainStudentProfile;

public class GetCollegesAsyncTask extends AsyncTask<Void, Void, String> {

	Activity currentActivity;
	Class nextActivityClass;
	
	public GetCollegesAsyncTask(Activity activity,Class nextActivity) {
		this.currentActivity = activity;
		this.nextActivityClass = nextActivity;
	}
	
	protected String doInBackground(Void[] params) {
		CoreServerUtils.getAllColleges();
		return "Got Colleges!";
	};

	protected void onPostExecute(String result) {
		Toast.makeText(currentActivity, result, Toast.LENGTH_LONG).show();
		Intent i=new Intent(currentActivity,nextActivityClass);
		currentActivity.startActivity(i);
	};

}
