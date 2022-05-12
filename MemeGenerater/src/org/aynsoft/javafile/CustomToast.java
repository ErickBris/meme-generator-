package org.aynsoft.javafile;

import org.aynsoft.meme.maker.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToast {

	public static void makeText(Context c,String msg){
		LayoutInflater inflater=LayoutInflater.from(c);
		View v=inflater.inflate(R.layout.custom_toast, null,false);
		TextView custom_txt_tag=(TextView)v.findViewById(R.id.txt_custom_toast);
		
		custom_txt_tag.setText(msg);		
		Toast toast=new Toast(c);
		toast.setView(v);
		toast.setGravity(Gravity.CENTER,0, 0);
		toast.setDuration(20000);
		toast.show();
	}
	public static  void showSavedDialog(final Activity act,String msg){
		AlertDialog.Builder builder=new Builder(act);
		builder.setTitle("Saved");
		builder.setMessage(msg);
		builder.setPositiveButton("OK", new OnClickListener() {			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//act.finish();
			}
		});
		AlertDialog dialog=builder.create();
		dialog.show();
	}
	
}
