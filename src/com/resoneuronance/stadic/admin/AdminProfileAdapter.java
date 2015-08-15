package com.resoneuronance.stadic.admin;

import java.util.ArrayList;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.id;
import com.resoneuronance.stadic.R.layout;
import com.resoneuronance.stadic.student.StudentProfileAdapter.ViewHolder;

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

public class AdminProfileAdapter extends BaseAdapter {

	private ArrayList<String> name,notifyno;
	private ArrayList<Integer> image;
	Activity context;
	LayoutInflater inflater;


	public AdminProfileAdapter(AdminProfile adminProfile,
			ArrayList<String> objArrayListName,
			ArrayList<Integer> objArrayListImage,
			ArrayList<String> objArrayListNotify_no) {

		this.name = objArrayListName;
		this.context=adminProfile;
		image=objArrayListImage;
		notifyno = objArrayListNotify_no;
		inflater = LayoutInflater.from(context);



	}

	@Override
	public int getCount() {

		return name.size();
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
		TextView NameTv,NotifyNotv;
		ImageView iv;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 

	{

		ViewHolder holder;
		View view = convertView;

		if(view == null)
		{
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.activity_admin_profile_adapter, null);
			holder.NameTv = (TextView)view.findViewById(R.id.admin_profile_adapter_textView);
			holder.iv=(ImageView)view.findViewById(R.id.admin_profile_adapter_imageView);
			holder.NotifyNotv=(TextView)view.findViewById(R.id.admin_profile_adapter_notification_no_textView);
			view.setTag(holder);
		}
		else
			holder = (ViewHolder)view.getTag();

		holder.NameTv.setText(name.get(position));
		holder.iv.setImageResource(image.get(position));
		holder.NotifyNotv.setText(notifyno.get(position));

		return view;
	}

}
