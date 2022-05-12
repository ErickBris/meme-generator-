package org.aynsoft.views;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class PaintStyle {

	private Paint mTextPaint;
	private Paint mTextPaintOutline;
	public static int FONT_SIZE=45;
	//modify by mir
	private Typeface font_typeface;
	public PaintStyle(Typeface font_style) {
		this.font_typeface = font_style;
	}
	public Paint getFillPaint(){
		   mTextPaint = new Paint();
		   mTextPaint.setTypeface(font_typeface);
	       mTextPaint.setAntiAlias(true);
	       mTextPaint.setTextSize(FONT_SIZE);
	       mTextPaint.setColor(Color.WHITE);
	       mTextPaint.setStyle(Paint.Style.FILL);
	    return mTextPaint;   
	}
	
	public  Paint getStrokPaint() {      
	       mTextPaintOutline = new Paint();
	       mTextPaintOutline.setTypeface(font_typeface);
	       mTextPaintOutline.setAntiAlias(true);
	       mTextPaintOutline.setTextSize(FONT_SIZE);
	       mTextPaintOutline.setColor(Color.BLACK);
	       mTextPaintOutline.setStyle(Paint.Style.STROKE);
	       mTextPaintOutline.setStrokeWidth(4);
	      return mTextPaintOutline;
	}
}
