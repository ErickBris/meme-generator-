package org.aynsoft.javafile;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class StartUpDialog {

	Activity act;
	AlertDialog dialog;
	AlertDialog.Builder builder;
	private static final String DIALOG_MASSAGE="Take picture from ? ";
	public StartUpDialog(Activity a) {
		this.act=a;
		builder=new AlertDialog.Builder(a);
	}
	public void showDialog(){
		builder.setMessage(DIALOG_MASSAGE);
		builder.setTitle("Alert");
		builder.setPositiveButton("Camera",new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
			}
		});
		builder.setNegativeButton("Gallery", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
			}
		});
		
	}
}
