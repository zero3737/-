package top.zero3737.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EMail {

    //发件人地址
    private String senderAddress;
	//收件人地址
    private String recipientAddress;
    //发件人账户名
    private String senderAccount;
    //发件人账户密码
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
		
        // 1.连接邮件服务器的参数配置
        Properties props = new Properties();
        // 设置用户的认证方式
        props.setProperty("mail.smtp.auth", "true");
        // 设置传输协议
        props.setProperty("mail.transport.protocol", "smtp");
        // 设置发件人的SMTP服务器地址
        props.setProperty("mail.smtp.host", "smtp.qq.com");
        
        // 2.创建定义整个应用程序所需的环境信息的 Session 对象
        Session session = Session.getInstance(props);
        
        // 3.创建一个默认的 MimeMessage 对象
        MimeMessage message = new MimeMessage(session);
        // 设置发件人
        message.setFrom(new InternetAddress(senderAddress));
        // 设置收件人
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientAddress));
        // 设置标题
        message.setSubject(title);
        // 设置实际消息
        message.setText(content);
        
        // 4.根据session对象获取邮件传输对象Transport
        Transport transport = session.getTransport();
        // 设置发件人的账户名和密码
        transport.connect(senderAccount, senderPassword);
        // 发送邮件，并发送到所有收件人地址，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message, message.getAllRecipients());
        
        // 5.关闭邮件连接
        transport.close();
		
	}
	
}
