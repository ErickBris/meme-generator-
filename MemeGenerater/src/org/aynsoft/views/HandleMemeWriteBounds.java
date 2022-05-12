package org.aynsoft.views;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;


public class HandleMemeWriteBounds {

	int width;
	int FONT_SIZE=PaintStyle.FONT_SIZE;
	int TOP_TEXT_LENGHT,BOTTOM_TEXT_LENGHT;
	Paint mTextPaint,mTextPaintOutline;
	Bitmap meme_image;
	public HandleMemeWriteBounds(Bitmap bitmap, Typeface font_style) {
		PaintStyle paintStyle=new PaintStyle(font_style);
		mTextPaint=paintStyle.getFillPaint();
		mTextPaintOutline=paintStyle.getStrokPaint();
		this.meme_image=bitmap;
	}	
	

	public Bitmap generateImage(String topText,String bottomText){
		TOP_TEXT_LENGHT=topText.length();
		BOTTOM_TEXT_LENGHT=bottomText.length();
		
		Bitmap alteredBitmap = Bitmap.createBitmap(meme_image.getWidth(), meme_image.getHeight
				(), meme_image.getConfig());
				Canvas canvas = new Canvas(alteredBitmap);				
				canvas.drawBitmap(meme_image, 0, 0, new Paint());
				/*Top Text
				canvas.drawText(topText, xBound(mTextPaintOutline.measureText(topText)), 
						FONT_SIZE+3, mTextPaintOutline);
				canvas.drawText(topText, xBound(mTextPaint.measureText(topText)),
						FONT_SIZE+3, mTextPaint);	
				//Top Text*/
				writeOnTop(topText, mTextPaintOutline, canvas);
				writeOnTop(topText, mTextPaint, canvas);
				
				
				//Bottom Text
				writeOnBottom(bottomText, mTextPaintOutline, canvas);
				writeOnBottom(bottomText, mTextPaint, canvas);
				/*canvas.drawText(bottomText, xBound(mTextPaintOutline.measureText(bottomText)), 
						yBound(), mTextPaintOutline);
				canvas.drawText(bottomText, xBound(mTextPaint.measureText(bottomText)), 
						yBound(), mTextPaint);
				*/
		return alteredBitmap;		
	}
	public void writeOnTop(String text,Paint paint,Canvas canvas){
		int MARGIN=3;
		String WHOLE_TEXT=text;
		List<String> lines=new ArrayList<String>();
		while(!WHOLE_TEXT.isEmpty()){
			int length=paint.breakText(WHOLE_TEXT, true,(float) canvas.getWidth()-MARGIN,
					null);
			lines.add(WHOLE_TEXT.substring(0, length));
			WHOLE_TEXT=WHOLE_TEXT.substring(length);
		}
		
		Rect bounds = new Rect();
	    int yoff = 3;
	    for(String line:lines){
	        canvas.drawText(line, xBound(paint.measureText(line)), FONT_SIZE + yoff, paint);
	        paint.getTextBounds(line, 0, line.length(), bounds);
	        yoff=bounds.height()+yoff+10;
	       
	    }
	}
	
	public void writeOnBottom(String text,Paint paint,Canvas canvas){
		int MARGIN=3;
		String WHOLE_TEXT=text;
		List<String> lines=new ArrayList<String>();
		while(!WHOLE_TEXT.isEmpty()){
			int length=paint.breakText(WHOLE_TEXT, true,(float) canvas.getWidth()-MARGIN,
					null);
			lines.add(WHOLE_TEXT.substring(0, length));
			WHOLE_TEXT=WHOLE_TEXT.substring(length);
		}
		
		Rect bounds = new Rect();
	    int yoff = canvas.getHeight()-10;
	    int ySet=1;
	    for(String line: lines){
	    	float yCordinate= yoff-((lines.size()-ySet)*FONT_SIZE);
	    	 canvas.drawText(line, xBound(paint.measureText(line)),yCordinate, paint);
		        paint.getTextBounds(line, 0, line.length(), bounds);
		       // Log.i("ycordinate",""+yCordinate);
		        ySet++;
	    }
	}
	
	public int xBound(float str_width){		
		int width=meme_image.getWidth();
		float xbounds=(width-str_width)/2;
		//Log.i("textlenght", ""+str_width);
		//Log.i("xBounds",""+xbounds);
		return (int)xbounds;
		
	}
	
	public int yBound(){
		int height=meme_image.getHeight();		
		return (height-6);
	}
		
}
