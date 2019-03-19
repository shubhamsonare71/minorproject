package com.minorProject.SendMail;

import java.util.Properties;

import javax.mail.Message;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.mail.PasswordAuthentication;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sendMail extends HttpServlet {
	    
        private static String Otp;
        public static String Mail(String toMail) {
		    System.out.println("mail has to be send");
		    System.out.println(toMail);
        	String password = "nokia5130";
	
		try{
	        Properties property = new Properties();
	        property.setProperty("mail.smtp.host", "smtp.gmail.com");
	        property.setProperty("mail.smtp.starttls.enable", "true");
	        //property.setProperty("mail.smpt.port", "25");
	        property.setProperty("mail.smtp.user", "shubham.sonare.71@gmail.com");
	        property.setProperty("mail.smtp.auth", "true");

	        System.out.println("Mail Check 1");
	        
	        
	        Session session = Session.getDefaultInstance(property, 
	        	    new javax.mail.Authenticator(){
	        	        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
	        	            return new PasswordAuthentication(
	        	                "shubham.sonare.71@gmail.com", password);// Specify the Username and the PassWord
	        	        }
	        	});

	        
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("shubham.sonare.71@gmail.com"));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));

	        System.out.println("Mail Check 2");
            char[] a = OTPgeneration.sendOTP(4);
            Otp = new String(a);
            System.out.println(Otp);
            
              
	        message.setSubject("This is an OTP for password change");
	        
			message.setText("we are send you an OTP for Email ID verification plz insert this OTP for further process" + Otp );

	        System.out.println("Mail Check 3");

	        Transport transport = session.getTransport("smtps");
	        transport.connect("smtp.gmail.com",465,"shubham.sonare.71@gmail.com",password);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();

	        System.out.println("Mail Sent");
	    }catch(Exception ex){
	        System.out.println("Mail fail");
	        ex.printStackTrace();
	        System.out.println(ex);
	        
	    }
		return Otp;

	}
}
