package top.zero3737.util;

import org.junit.Test;

public class EMailTest {

	@Test
	public void testSendEMail() {
		
		EMail eMail = new EMail();
		
		eMail.setSenderAccount("2654092834@qq.com");
		eMail.setSenderPassword("cbivrvijsebyecbg");
		
		eMail.setSenderAddress("2654092834@qq.com");
		eMail.setRecipientAddress("2654092834@qq.com");
		try {
			
			eMail.sendEMail("ÄãºÃ", "ÄãºÃ");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

}
