package application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.BodyTerm;
import javax.mail.search.FlagTerm;

public class mailReceiver {

	
	public static Message[] receiveMail(String Clientusername, String Clientpassword) throws IOException
	{

		String host = "imap.gmail.com";
		String username = Clientusername;
		String password = Clientpassword;
		 
		// Create empty properties
		Properties props = new Properties();
		 
		// Get session
		Session session = Session.getDefaultInstance(props, null);
		Message messages[] = null; 
		// Get the store
		Store store;
		try {
			store = session.getStore("imaps");
			store.connect(host, username, password);
			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);
			 
			// Get directory
			FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
			//messages = folder.search(new BodyTerm("kleuren"));
			messages = folder.search(ft);
			
			for(Message message : messages)
			{
				System.out.println(message.getSubject());
				//getAttachments(message);
			}
			folder.close(false);
			store.close();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messages;
		
		 
		// Get folder
		
	}
	
	public static List<File> getAttachments(Message message) throws IOException, MessagingException
	{
		List<File> attachments = null;    
		Multipart multipart = (Multipart) message.getContent();
		    // System.out.println(multipart.getCount());

		    for (int i = 0; i < multipart.getCount(); i++) {
		        BodyPart bodyPart = multipart.getBodyPart(i);
		        if(!Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition())) {
		          continue; // dealing with attachments only
		        } 
		        InputStream is = bodyPart.getInputStream();
		        File f = new File("/tmp/" + bodyPart.getFileName());
		        FileOutputStream fos = new FileOutputStream(f);
		        byte[] buf = new byte[4096];
		        int bytesRead;
		        while((bytesRead = is.read(buf))!=-1) {
		            fos.write(buf, 0, bytesRead);
		        }
		        fos.close();
		        System.out.println(f.getName());
		        attachments.add(f);
		    }
		    return attachments;
	}
}

