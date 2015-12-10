package utilities;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import basics.User;

public class SendEmail {

	public static void sendMail(User _myNewUser){
		String from = "fjpasamontesmoreno@gmail.com";
		String to = _myNewUser.getEmail();
		String host = "localhost";
		
		//System props
		Properties props = System.getProperties();
		
		//Setup mail server
		props.setProperty("mail.smtp.host", host);
		
		Session mySession = Session.getDefaultInstance(props);
		
		try{
			//E-mail fields
			MimeMessage mail = new MimeMessage(mySession);
			mail.setFrom(new InternetAddress(from));
			mail.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mail.setSubject("New user created");
			mail.setContent(_myNewUser.getId() + " " + _myNewUser.getName() + " " + _myNewUser.getEmail() + "\n","text/html");
			
			
			//Sending e-mail
			Transport.send(mail);
			System.out.println("\nMessage sent succesfully.\n");
		}
		catch(MessagingException e){
			System.out.println("E-mail not sent: " + e);
		}
	}
}
