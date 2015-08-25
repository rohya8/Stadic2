package com.resoneuronance.stadic.activity.student;


import java.util.ArrayList;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.id;
import com.resoneuronance.stadic.R.layout;
import com.resoneuronance.stadic.domain.DepartmentName;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class StudentDeleteDepartmentActivity extends Activity {

	Button myButton ;
	DeleteDepartmentAdapter dataAdapter = null;
	ListView listView=null;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_delete_department);

		listView = (ListView) findViewById(R.id.student_delete_department_listView);

		displayListView();

		DeleteButtonClick();



		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// When clicked, show a toast with the TextView text
				DepartmentName department = (DepartmentName) parent.getItemAtPosition(position);

			}
		});



	}


	private void DeleteButtonClick() {

		myButton = (Button) findViewById(R.id.student_delete_department_button);
		myButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				StringBuffer responseText = new StringBuffer();

				responseText.append("following deleted...\n");

				ArrayList<DepartmentName> departmentList = dataAdapter.departmentList;
				for(int i=0;i<departmentList.size();i++){
					DepartmentName department = departmentList.get(i);
					System.out.println(" data "+department.getName()+" selected " + department.isSelected());
					if(department.isSelected()){
						departmentList.remove(i);
						responseText.append("\n" + department.getName());

					}
				}

				Toast.makeText(getApplicationContext(),
						responseText, Toast.LENGTH_SHORT).show();

				redisplayListView(departmentList);
			}


		});

	}


	private void redisplayListView(ArrayList<DepartmentName> departmentList) {


		dataAdapter = new DeleteDepartmentAdapter(this,
				R.layout.activity_add_student_teacher_adapter, departmentList);
		ListView listView = (ListView) findViewById(R.id.student_delete_department_listView);

		listView.setAdapter(dataAdapter);

	}




	private void displayListView() {

		//Array list of countries
		ArrayList<DepartmentName> departmentList = new ArrayList<DepartmentName>();
		DepartmentName departmentnm = new DepartmentName("Computer",false);
		departmentList.add(departmentnm);
		departmentnm = new DepartmentName("Information Technology",false);
		departmentList.add(departmentnm);
		departmentnm = new DepartmentName("Electrical",false);
		departmentList.add(departmentnm);
		departmentnm = new DepartmentName("ENTC",false);
		departmentList.add(departmentnm);
		departmentnm = new DepartmentName("Instrumentaion",false);
		departmentList.add(departmentnm);
		departmentnm = new DepartmentName("Chemical",false);
		departmentList.add(departmentnm);


		//create an ArrayAdaptar from the String Array
		dataAdapter = new DeleteDepartmentAdapter(this,
				R.layout.activity_add_student_teacher_adapter, departmentList);

		// Assign adapter to ListView

		listView.setAdapter(dataAdapter);




	}

	private class DeleteDepartmentAdapter extends ArrayAdapter<DepartmentName> {

		private ArrayList<DepartmentName> departmentList;

		public DeleteDepartmentAdapter(Context context, int textViewResourceId, 
				ArrayList<DepartmentName> departmentList) {
			super(context, textViewResourceId, departmentList);
			this.departmentList = new ArrayList<DepartmentName>();
			this.departmentList.addAll(departmentList);
		}

		private class ViewHolder {
			TextView code;
			CheckBox name;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder = null;

			if (convertView == null) {
				LayoutInflater vi = (LayoutInflater)getSystemService(
						Context.LAYOUT_INFLATER_SERVICE);
				convertView = vi.inflate(R.layout.activity_add_student_teacher_adapter, null);

				holder = new ViewHolder();
				holder.code = (TextView) convertView.findViewById(R.id.addstudent_teacher_adapter_textView);
				holder.name = (CheckBox) convertView.findViewById(R.id.addstudent_teacher_adapter_checkbox);
				convertView.setTag(holder);

				holder.name.setOnClickListener( new View.OnClickListener() {  
					public void onClick(View v) {  
						CheckBox cb = (CheckBox) v ;  
						DepartmentName department = (DepartmentName) cb.getTag();  
						department.setSelected(cb.isChecked());

					}  
				});  
			} 
			else {
				holder = (ViewHolder) convertView.getTag();
			}

			DepartmentName department = departmentList.get(position);
			holder.code.setText(department.getName());
			holder.name.setChecked(department.isSelected());
			holder.name.setTag(department);

			return convertView;



		}

	}

}
