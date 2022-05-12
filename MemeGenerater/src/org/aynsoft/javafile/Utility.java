package org.aynsoft.javafile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

public class Utility {

	public static Bitmap scaleImage(String path, float width, Context c) {
	
			Options options = new Options();
			options.inJustDecodeBounds = true;
			BitmapFactory.decodeFile(path,options);		

			options.inSampleSize = calculateInSampleSize(options, (int) width,
					(int) width);
		
			options.inJustDecodeBounds = false;
			return BitmapFactory.decodeFile(path,options);
		
		// bitmap.recycle();
		
	}

	public static int calculateInSampleSize(BitmapFactory.Options options,
			int reqWidth, int reqHeight) {
		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {

			final int halfHeight = height / 2;
			final int halfWidth = width / 2;

			// Calculate the largest inSampleSize value that is a power of 2 and
			// keeps both
			// height and width larger than the requested height and width.
			while ((halfHeight / inSampleSize) > reqHeight
					&& (halfWidth / inSampleSize) > reqWidth) {
				inSampleSize *= 2;
			}
		}

		return inSampleSize;
	}
}