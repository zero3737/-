package top.zero3737.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EMail {

    //�����˵�ַ
    private String senderAddress;
	//�ռ��˵�ַ
    private String recipientAddress;
    //�������˻���
    private String senderAccount;
    //�������˻�����
    private String senderPassword;
    
    public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

	public String getSenderAccount() {
		return senderAccount;
	}

	public void setSenderAccount(String senderAccount) {
		this.senderAccount = senderAccount;
	}

	public String getSenderPassword() {
		return senderPassword;
	}

	public void setSenderPassword(String senderPassword) {
		this.senderPassword = senderPassword;
	}
	
	public void sendEMail(String title, String content) throws Exception {
		
        // 1.�����ʼ��������Ĳ�������
        Properties props = new Properties();
        // �����û�����֤��ʽ
        props.setProperty("mail.smtp.auth", "true");
        // ���ô���Э��
        props.setProperty("mail.transport.protocol", "smtp");
        // ���÷����˵�SMTP��������ַ
        props.setProperty("mail.smtp.host", "smtp.qq.com");
        
        // 2.������������Ӧ�ó�������Ļ�����Ϣ�� Session ����
        Session session = Session.getInstance(props);
        
        // 3.����һ��Ĭ�ϵ� MimeMessage ����
        MimeMessage message = new MimeMessage(session);
        // ���÷�����
        message.setFrom(new InternetAddress(senderAddress));
        // �����ռ���
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientAddress));
        // ���ñ���
        message.setSubject(title);
        // ����ʵ����Ϣ
        message.setText(content);
        
        // 4.����session�����ȡ�ʼ��������Transport
        Transport transport = session.getTransport();
        // ���÷����˵��˻���������
        transport.connect(senderAccount, senderPassword);
        // �����ʼ��������͵������ռ��˵�ַ��message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
        transport.sendMessage(message, message.getAllRecipients());
        
        // 5.�ر��ʼ�����
        transport.close();
		
	}
	
}
