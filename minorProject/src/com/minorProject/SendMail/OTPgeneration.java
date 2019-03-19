package com.minorProject.SendMail;

import java.util.Random;

public class OTPgeneration {
	
	  
	  public static char[] sendOTP(int length) {
	     
	      String number = "0123456789";
	      Random r = new Random();
	      char[] otp = new char[length];
	      for(int i =0; i<length; i++) {
	    	     otp[i] = number.charAt(r.nextInt(number.length()));
	      }
	      return otp;
}

	        	   
	        	   
	        	   
	        	  
	        	   
	      
}
