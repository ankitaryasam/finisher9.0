package com.app.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class InternationalizationTest {
	
	public static void main(String[] args) {
		//internationalization code
		
		Locale locale = null;
		
		locale = new Locale(args[0], args[1]);
		
		
		ResourceBundle bundle = 
	    ResourceBundle.getBundle("com/app/test/App", locale);
		
		System.out.println(
				bundle.getString("loginBtn") + " " +
		        bundle.getString("regBtn") + " " + 
			    bundle.getString("buyBtn")
				
				
				);
	}

}
