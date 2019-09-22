package top.zero3737.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EMailController {
	
	@RequestMapping("/sendemail")
	public String sendEMail(String title, String content) {
		
		
		
		return null;
		
	}
	
}
