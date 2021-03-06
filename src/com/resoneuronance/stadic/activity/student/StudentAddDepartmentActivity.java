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

public class StudentAddDepartmentActivity extends Activity {

	AddDepartmentAdapter dataAdapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_add_department);
		displayListView();

		checkButtonClick();

	}

	private void displayListView() 
	{

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

		dataAdapter = new AddDepartmentAdapter(this,
				R.layout.activity_add_student_teacher_adapter, departmentList);
		ListView listView = (ListView) findViewById(R.id.student_add_department_listView);

		listView.setTextFilterEnabled(true);
		listView.setAdapter(dataAdapter);



		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// When clicked, show a toast with the TextView text
				DepartmentName department = (DepartmentName) parent.getItemAtPosition(position);

			}
		});

	}

	private class AddDepartmentAdapter extends ArrayAdapter<DepartmentName> 
	{

		private ArrayList<DepartmentName> departmentList;

		public AddDepartmentAdapter(Context context, int textViewResourceId, 
				ArrayList<DepartmentName> departmentList) 
		{
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
						DepartmentName teacher = (DepartmentName) cb.getTag();  
						teacher.setSelected(cb.isChecked());

					}  
				});  
			} 
			else {
				holder = (ViewHolder) convertView.getTag();
			}

			DepartmentName teacher = departmentList.get(position);
			holder.code.setText(teacher.getName());
			holder.name.setChecked(teacher.isSelected());
			holder.name.setTag(teacher);

			return convertView;

		}

	}

	private void checkButtonClick() {


		Button myButton = (Button) findViewById(R.id.student_add_department_button);
		myButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				StringBuffer responseText = new StringBuffer();
				responseText.append("following selected...\n");

				ArrayList<DepartmentName> teacherList = dataAdapter.departmentList;
				for(int i=0;i<teacherList.size();i++){
					DepartmentName teacher = teacherList.get(i);
					if(teacher.isSelected()){
						responseText.append("\n" + teacher.getName());
					}
				}

				Toast.makeText(getApplicationContext(),
						responseText, Toast.LENGTH_SHORT).show();

			}
		});

	}

}

