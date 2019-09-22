package top.zero3737.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class Config {

	@Value("${shiro.remoteServer}")
	public String REMOTESERVER;
	@Value("${shiro.localServer}")
	public String LOCALSERVER;
	@Value("${shiro.projectName}")
	public String PROJECTNAME;
	@Value("${shiro.loginAdmin}")
	public String LOGINADMIN;
	@Value("${shiro.successUrl}")
	public String SUCCESS_URL;
	@Value("${shiro.successAdminUrl}")
	public String ADMIN_URL;
	
}
