package com.resoneuronance.stadic.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;


import android.R;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageDownloadAsynctask extends AsyncTask<String, Void, Bitmap> {

	private Context mcont;
	private ImageView ImageDownload;
	ProgressDialog mProgressDialog;
	Bitmap bitmap;
	private static int flag=0;
	private String Filenameee;

	public ImageDownloadAsynctask(Context context) {
		mcont=context;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();

		mProgressDialog = new ProgressDialog(mcont);
		mProgressDialog.setTitle("Download Image ");
		mProgressDialog.setMessage("Loading...");
		mProgressDialog.setCancelable(false);
		mProgressDialog.show();
	}

	public void showImage() {

		Dialog dialog = new Dialog(mcont);
		dialog.setContentView(com.resoneuronance.stadic.R.layout.maindialog);
		dialog.setTitle("Assignment");
		dialog.setCancelable(true);
		//there are a lot of settings for dialog

		//set up image view
		ImageView img = (ImageView) dialog.findViewById(com.resoneuronance.stadic.R.id.ImageView01);
		img.setImageBitmap(bitmap);
		dialog.show();
	}


	@Override
	protected void onPostExecute(Bitmap result) {


		if(flag==1){

			ImageDownload.setImageBitmap(result);

			//storeImage(result);
			saveToInternalSorage(result);
			showImage();
			mProgressDialog.dismiss();
		}
		else if(flag==2)
		{

			showImage();
			mProgressDialog.dismiss();

		}
		else if(flag==0){
			mProgressDialog.dismiss();
			Toast.makeText(mcont, "Image Does Not exist or Network Error ", Toast.LENGTH_SHORT).show();

		}


	}

	@Override
	protected Bitmap doInBackground(String... arg0) {

		flag=0;
		Filenameee=arg0[1];
		ContextWrapper cw = new ContextWrapper(mcont);
		// path to /data/data/yourapp/app_data/imageDir
		File directory = cw.getDir("data", Context.MODE_PRIVATE);
		File mypath=new File(directory,Filenameee);
		if(!mypath.exists())
		{
			flag=1;			
			try {

				InputStream input = new java.net.URL(arg0[0]).openStream();
				bitmap = BitmapFactory.decodeStream(input);


			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		else
		{
			flag=2;
			bitmap=getImageBitmap(Filenameee);
		}
		return bitmap;	
	}

	private String saveToInternalSorage(Bitmap bitmapImage){

		if(bitmapImage!=null)
		{
			FileOutputStream fos = null;

			ContextWrapper cw = new ContextWrapper(mcont);
			// path to /data/data/yourapp/app_data/imageDir
			File directory = cw.getDir("data", Context.MODE_PRIVATE);

			if (!directory.exists()) {
				try {
					directory.createNewFile();
					directory.mkdir();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			// Create imageDir
			File mypath=new File(directory,Filenameee);

			if(!mypath.exists())
			{

				try {           

					fos = new FileOutputStream(mypath);
					Toast.makeText(mcont, ""+mypath,Toast.LENGTH_LONG ).show();
					bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			/*		
			 * For TEXT FILE
			 * 
		OutputStreamWriter out;
		try {
		    ContextWrapper cw = new ContextWrapper(this);
		    File path = cw.getDir("myfolder", Context.MODE_PRIVATE);
		    if (!path.exists()) {
		        path.createNewFile();
		        path.mkdir();
		    }
		    File mypath=new File(path,"myfile.txt");
		    if (!mypath.exists()) {
		        out = new OutputStreamWriter(openFileOutput( mypath.getAbsolutePath() , MODE_PRIVATE));
		        out.write("test");
		        out.close();
		    }
		}
			 */

			return directory.getAbsolutePath();
		}
		else
			return null;

	}

	public Bitmap getImageBitmap(String name){

		try {
			ContextWrapper cw = new ContextWrapper(mcont);
			// path to /data/data/yourapp/app_data/imageDir
			File directory = cw.getDir("data", Context.MODE_PRIVATE);
			File mypath=new File(directory,name);

			bitmap = BitmapFactory.decodeStream(new FileInputStream(mypath));

		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		return bitmap;

	}





}