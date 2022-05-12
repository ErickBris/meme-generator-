package org.aynsoft.javafile;

import android.graphics.Typeface;

public class TypefaceOptions {

	Typeface tfHelvatica,tfArial;
	Typeface currentTypeface;
	public Typeface getCurrentTypeface() {
		return currentTypeface;
	}
	
	public void setCurrentTypeface(Typeface currentTypeface) {
		this.currentTypeface = currentTypeface;
	}
	public TypefaceOptions() {
		
	}	
}
