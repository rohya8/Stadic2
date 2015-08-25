package com.resoneuronance.stadic.activity.student;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.id;
import com.resoneuronance.stadic.R.layout;
import com.resoneuronance.stadic.domain.TeacherName;

public class StudentDeleteTeacherActivity extends Activity {

	Button myButton ;
	DeleteTeacherAdapter dataAdapter = null;
	ListView listView=null;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_delete_teacher);

		listView = (ListView) findViewById(R.id.student_delete_teacher_listView);

			displayListView();

			DeleteButtonClick();



			listView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// When clicked, show a toast with the TextView text
					TeacherName teacher = (TeacherName) parent.getItemAtPosition(position);

				}
			});



	}


	private void DeleteButtonClick() {

		myButton = (Button) findViewById(R.id.student_delete_teacher_button);
		myButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				StringBuffer responseText = new StringBuffer();

				responseText.append("following deleted...\n");

				ArrayList<TeacherName> teacherList = dataAdapter.teacherList;
				for(int i=0;i<teacherList.size();i++){
					TeacherName teacher = teacherList.get(i);
					System.out.println(" data "+teacher.getName()+" selected " + teacher.isSelected());
					if(teacher.isSelected()){
						teacherList.remove(i);
						responseText.append("\n" + teacher.getName());

					}
				}

				Toast.makeText(getApplicationContext(),
						responseText, Toast.LENGTH_SHORT).show();

				redisplayListView(teacherList);
			}


		});

	}


	private void redisplayListView(ArrayList<TeacherName> teacherList) {


		dataAdapter = new DeleteTeacherAdapter(this,
				R.layout.activity_add_student_teacher_adapter, teacherList);
		ListView listView = (ListView) findViewById(R.id.student_delete_teacher_listView);

		listView.setAdapter(dataAdapter);

	}




	private void displayListView() {

		//Array list of countries
		ArrayList<TeacherName> teacherList = new ArrayList<TeacherName>();
		TeacherName teachernm = new TeacherName("Rajesh Mangale",false);
		teacherList.add(teachernm);
		teachernm = new TeacherName("Rohit",false);
		teacherList.add(teachernm);
		teachernm = new TeacherName("Mangale",false);
		teacherList.add(teachernm);
		teachernm = new TeacherName("Rajesh",false);
		teacherList.add(teachernm);
		teachernm = new TeacherName("rohit",false);
		teacherList.add(teachernm);
		teachernm = new TeacherName("rW",false);
		teacherList.add(teachernm);


		//create an ArrayAdaptar from the String Array
		dataAdapter = new DeleteTeacherAdapter(this,
				R.layout.activity_add_student_teacher_adapter, teacherList);

		// Assign adapter to ListView

		listView.setAdapter(dataAdapter);




	}

	private class DeleteTeacherAdapter extends ArrayAdapter<TeacherName> {

		private ArrayList<TeacherName> teacherList;

		public DeleteTeacherAdapter(Context context, int textViewResourceId, 
				ArrayList<TeacherName> teacherList) {
			super(context, textViewResourceId, teacherList);
			this.teacherList = new ArrayList<TeacherName>();
			this.teacherList.addAll(teacherList);
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
						TeacherName teacher = (TeacherName) cb.getTag();  
						teacher.setSelected(cb.isChecked());

					}  
				});  
			} 
			else {
				holder = (ViewHolder) convertView.getTag();
			}

			TeacherName teacher = teacherList.get(position);
			holder.code.setText(teacher.getName());
			holder.name.setChecked(teacher.isSelected());
			holder.name.setTag(teacher);

			return convertView;



		}

	}

}
