package com.resoneuronance.stadic.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class CoreServerUtils {

	private static String GET_COLLEGES_URL = "http://192.168.1.104:8080/CampusWebApp/getAllColleges";
	public static String[] colleges = {""};
	
	public static String[] getAllColleges() {
		List<String> collegeNames = retrieveCollegeNames();
		if(CollectionUtils.isEmpty(collegeNames)) {
			return colleges;
		}
		colleges = new String[collegeNames.size()];
		colleges = collegeNames.toArray(colleges);
		return colleges;
	}
	
	private static List<String> retrieveCollegeNames() {
		List<String> collegeNames = new ArrayList<String>();
		HttpHeaders requestHeaders = new HttpHeaders();
		// requestHeaders.setContentType(new MediaType("text", "xml"));
		HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		ResponseEntity<String> responseEntity = restTemplate.exchange(GET_COLLEGES_URL, HttpMethod.POST, requestEntity,
				String.class);
		Log.d("Colleges Received ..", responseEntity.getBody());
		collegeNames = new Gson().fromJson(responseEntity.getBody(), List.class);
		return collegeNames;
	}
	
	public static AsyncTask<Void,Void,String> shareRegIdTask() {
		return new AsyncTask<Void, Void, String>() {
			protected String doInBackground(Void[] params) {
				CoreServerUtils.getAllColleges();
				return "Got Colleges!";
			};

			protected void onPostExecute(String result) {
				//Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
			};
		};
	}
	
}
