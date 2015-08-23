package com.resoneuronance.stadic.util;

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
import android.widget.Toast;

import com.google.gson.Gson;
import com.resoneuronance.campus.web.bo.domain.Student;
import com.resoneuronance.campus.web.domain.StudentRegID;
import com.resoneuronance.campus.web.util.Constants;

/*Utility class for server operations*/

public class CoreServerUtils {

	private static String GET_COLLEGES_URL = "http://192.168.1.104:8080/CampusWebApp/getAllColleges";
	private static String SHARE_REG_ID_URL = "http://192.168.1.104:8080/CampusWebApp/shareStudentRegId?regId={regId}";
	
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
	
	public static void shareRegId(Activity context, Student student) {
		if(student == null) {
			return;
		}
		String regId = GCMUtil.registerRegId(context);
		if(regId !=null) {
			Map<String, Object> uriVariables = new HashMap<String, Object>();
			StudentRegID studentRegId = new StudentRegID();
			studentRegId.setRegId(regId);
			studentRegId.setStudentId(student.getId());
			uriVariables.put(Constants.REG_ID, new Gson().toJson(studentRegId));
			ResponseEntity<String> responseEntity = postServerCall(SHARE_REG_ID_URL,uriVariables);
			if(Constants.RESPONSE_OK.equals(responseEntity.getBody())) {
				Log.d(AndroidConstants.TAG, "Shared Reg ID!!");
			}
		}
		
	}
	
}
