package application;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.apache.commons.mail.EmailException;

import models.Email;

public class ConsoleApplication {

	public static void main(String[] args) throws MessagingException, IOException, EmailException
	{
		List<String> receivers = new ArrayList<String>();
		receivers.add("sburghouts@gmail.com");
		
		List<Email> emailList = new ArrayList<Email>();
		for(int i = 0; i < 100; i++)
		{
			emailList.add(new Email("testmail", "mail01@localhost", receivers, "dit is een testmail", "Steef Burghouts"));
		}
		
		MailSender.sendMail(emailList);

		Message[] messages = mailReceiver.receiveMail("mail01@localhost", "mail01");
		

		

		
	}	
		
}
