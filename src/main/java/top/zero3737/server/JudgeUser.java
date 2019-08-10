package top.zero3737.server;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.alibaba.fastjson.JSON;
import top.zero3737.dao.UserInterface;
import top.zero3737.javabean.CodeLogin;
import top.zero3737.javabean.User;

public class JudgeUser {

	public String judgeUser(String username, String password) {
		
		CodeLogin codeLogin = new CodeLogin();
		String jsonstr = null;
		
		try {
			
			UserInterface mapper = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("conf.xml")).openSession().getMapper(UserInterface.class);
			User queryUser = mapper.queryUser(username);
			if(queryUser.getPassWord().equals(password)) {
				
				jsonstr = JSON.toJSONString(codeLogin.setCode("0").setMsg("������ȷ"));
				
			} else {
				
				jsonstr = JSON.toJSONString(codeLogin.setCode("1").setMsg("�������"));
				
			}
			
		} catch (Exception e) {
			
			jsonstr = JSON.toJSONString(codeLogin.setCode("2").setMsg("�Ҳ����û�"));
			
		}
		
		return jsonstr;
		
	}
	
}
