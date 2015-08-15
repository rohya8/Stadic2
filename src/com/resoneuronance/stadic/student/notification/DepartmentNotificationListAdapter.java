package com.resoneuronance.stadic.student.notification;

import java.util.ArrayList;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.id;
import com.resoneuronance.stadic.R.layout;
import com.resoneuronance.stadic.student.notification.TeacherNotificationListAdapter.ViewHolder;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DepartmentNotificationListAdapter extends BaseAdapter {

	private ArrayList<String> Name,NotifyNo;
	private ArrayList<Integer> Image;
	private Activity context;
	private LayoutInflater inflater;


	public DepartmentNotificationListAdapter(
			DepartmentNotificationList departmentNotificationList,
			ArrayList<String> objArrayListName,
			ArrayList<Integer> objArrayListImage,
			ArrayList<String> objArrayListNotifyNo) {

		this.Name = objArrayListName;
		this.context=departmentNotificationList;
		Image=objArrayListImage;
		NotifyNo = objArrayListNotifyNo;
		inflater = LayoutInflater.from(context);

	}

	@Override
	public int getCount() {
		return Name.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
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
			view = inflater.inflate(R.layout.activity_department_notification_list_adapter, null);
			holder.NameTv = (TextView)view.findViewById(R.id.departmentnotificationlist_adapter_textView);
			holder.Iv=(ImageView)view.findViewById(R.id.departmentnotificationlist_adapter_imageView);
			holder.NotifyNoTv=(TextView)view.findViewById(R.id.departmentnotificationlist_adapter_notification_no_textView);
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
