package top.zero3737.server;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.zero3737.dao.UserInterface;
import top.zero3737.javabean.CodeLogin;
import top.zero3737.javabean.User;

public class JudgeUser {

	public CodeLogin judgeUser(String username, String password) {
		
		CodeLogin codeLogin = new CodeLogin();
		
		try {
			
			UserInterface mapper = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("conf.xml")).openSession().getMapper(UserInterface.class);
			User queryUser = mapper.queryUser(username);
			if(queryUser.getPassWord().equals(password)) {
				
				codeLogin.setCode("0").setMsg("������ȷ");

				
			} else {
				
				codeLogin.setCode("1").setMsg("�������");
				
			}
			
		} catch (Exception e) {
			
			codeLogin.setCode("2").setMsg("�û�������");
			
		}
		
		return codeLogin;
		
	}
	
}
