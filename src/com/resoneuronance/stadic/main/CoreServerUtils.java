package com.resoneuronance.stadic.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import android.app.Activity;
import android.util.Log;

import com.google.gson.Gson;

/*Utility class for server operations*/

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
		Map<String, Object> uriVariables = new HashMap<String, Object>();
		ResponseEntity<String> responseEntity = postServerCall(GET_COLLEGES_URL,uriVariables);
		collegeNames = new Gson().fromJson(responseEntity.getBody(), List.class);
		return collegeNames;
	}

	public static ResponseEntity<String> postServerCall(String url,Map<String, Object> uriVariables) {
		HttpHeaders requestHeaders = new HttpHeaders();
		//requestHeaders.setContentType(new MediaType("text", "xml"));
		HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,String.class,uriVariables);
		Log.d("Colleges Received ..", responseEntity.getBody());
		return responseEntity;
	}
	
	public static void shareRegId(Activity context) {
		GCMUtil.registerGCM(context);
	}
	
}
