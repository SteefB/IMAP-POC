package models;

import java.util.List;

public class Email {

	private String subject;
	
	public String sender;
	
	private List<String> receivers;
	
	private String message;
	
	private List<String> attachments;
	
	private String senderName;

	public Email(String subject, String sender, List<String> receivers, String message, String senderName)
	{
		this.subject = subject;
		this.sender = sender;
		this.receivers = receivers;
		this.message = message;
		this.senderName = senderName;
	}
	
	public String getSenderName()
	{
		return this.senderName;
	}
	
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public List<String> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<String> receivers) {
		this.receivers = receivers;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<String> attachments) {
		this.attachments = attachments;
	}
	
	
}
