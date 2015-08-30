package com.resoneuronance.stadic.adapter.student;

import java.util.ArrayList;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.id;
import com.resoneuronance.stadic.R.layout;
import com.resoneuronance.stadic.activity.student.StudentTeacherNotificationsListActivity;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentTeacherNotificationListAdapter extends BaseAdapter {

	private ArrayList<String> Name,NotifyNo;
	private ArrayList<Integer> Image;
	private Activity context;
	private LayoutInflater inflater;

	public ArrayList<String> getName() {
		return Name;
	}

	public void setName(ArrayList<String> name) {
		Name = name;
	}

	public ArrayList<String> getNotifyNo() {
		return NotifyNo;
	}

	public void setNotifyNo(ArrayList<String> notifyNo) {
		NotifyNo = notifyNo;
	}

	public ArrayList<Integer> getImage() {
		return Image;
	}

	public void setImage(ArrayList<Integer> image) {
		Image = image;
	}

	public LayoutInflater getInflater() {
		return inflater;
	}

	public void setInflater(LayoutInflater inflater) {
		this.inflater = inflater;
	}

	public StudentTeacherNotificationListAdapter(
			StudentTeacherNotificationsListActivity teacherNotificationList,
			ArrayList<String> objArrayListName,
			ArrayList<Integer> objArrayListImage,
			ArrayList<String> objArrayListNotifyNo) {

		this.Name = objArrayListName;
		this.context=teacherNotificationList;
		Image=objArrayListImage;
		NotifyNo = objArrayListNotifyNo;
		inflater = LayoutInflater.from(context);

	}

	@Override
	public int getCount() {
		return Name.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}
	public class ViewHolder
	{
		TextView NameTv,NotifyNoTv;
		ImageView Iv;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 

	{

		ViewHolder holder;
		View view = convertView;

		if(view == null)
		{
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.activity_student_teacher_notification_list_adapter, null);
			holder.NameTv = (TextView)view.findViewById(R.id.studentteachernotificationlist_adapter_textView);
			holder.Iv=(ImageView)view.findViewById(R.id.studentteachernotificationlist_adapter_imageView);
			holder.NotifyNoTv=(TextView)view.findViewById(R.id.studentteachernotificationlist_adapter_notification_no_textView);
			view.setTag(holder);
		}
		else
			holder = (ViewHolder)view.getTag();

		holder.NameTv.setText(Name.get(position));
		holder.Iv.setImageResource(Image.get(position));
		holder.NotifyNoTv.setText(NotifyNo.get(position));
		return view;

	}

}
