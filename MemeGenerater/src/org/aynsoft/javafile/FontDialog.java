package org.aynsoft.javafile;

import org.aynsoft.meme.maker.CreateMemeActivity;
import org.aynsoft.views.HandleMemeWriteBounds;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;

public class FontDialog {
	private Activity activity;
	private AlertDialog dialog;
	private AlertDialog.Builder builder;
	private final CharSequence[] items = { "MarckScript", "Delicious",
			"Blacker","spooky_night","The Beach", "CreamPuf" };

	public FontDialog(Activity activity) {
		this.activity = activity;
		builder = new AlertDialog.Builder(activity);

	}

	public void showDialog() {
		builder.setTitle("Select Font");
		builder.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				if (item == 0) {
					CreateMemeActivity.font_style = Typeface.createFromAsset(
							activity.getAssets(),
							"fonts/MarckScript-Regular.ttf");

					setFontStyle();
					dialog.dismiss();
				} else if (item == 1) {
					CreateMemeActivity.font_style = Typeface.createFromAsset(
							activity.getAssets(), "fonts/delicious_heavy.otf");

					setFontStyle();
					dialog.dismiss();
				} else if (item == 2) {
					CreateMemeActivity.font_style = Typeface.createFromAsset(
							activity.getAssets(), "fonts/blackr.ttf");

					setFontStyle();
					dialog.dismiss();
				} else if (item == 3) {
					CreateMemeActivity.font_style = Typeface.createFromAsset(
							activity.getAssets(), "fonts/spooky_night.ttf");

					setFontStyle();
					dialog.dismiss();
				} else if (item == 4) {
					CreateMemeActivity.font_style = Typeface.createFromAsset(
							activity.getAssets(), "fonts/the_beach.otf");

					setFontStyle();
					dialog.dismiss();
				}else{
					CreateMemeActivity.font_style = Typeface.createFromAsset(
							activity.getAssets(), "fonts/creampuf.ttf");

					setFontStyle();
					dialog.dismiss();
				}
			}
		});
		dialog = builder.create();
		dialog.show();
	}

	private void setFontStyle() {
		CreateMemeActivity.handleMemeWriteBounds = new HandleMemeWriteBounds(
				CreateMemeActivity.meme_image, CreateMemeActivity.font_style);
		CreateMemeActivity.ALTERED_BITMAP = CreateMemeActivity.handleMemeWriteBounds
				.generateImage(CreateMemeActivity.TOP_TEXT,
						CreateMemeActivity.BOTTOM_TEXT);
		CreateMemeActivity.meme_generated_img
				.setImageBitmap(CreateMemeActivity.ALTERED_BITMAP);
	}

	public interface onSettingPropertyChangeListener {
		public void onSettingChanged(int fontSize, Typeface tf);
	}

}
