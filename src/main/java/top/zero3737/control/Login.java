package top.zero3737.control;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import top.zero3737.javabean.CodeLogin;
import top.zero3737.server.JudgeUser;

public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public Login() {
    	
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = new String(request.getParameter("username").getBytes("iso-8859-1"), "utf-8");
		String password = new String(request.getParameter("password").getBytes("iso-8859-1"), "utf-8");
		CodeLogin codeLogin = new JudgeUser().judgeUser(username, password);
		String jsonstr = JSON.toJSONString(codeLogin);
		
		response.setContentType("text/json;charset=UTF-8");
		if(codeLogin.getCode().equals("0")) {
			
			Cookie cookie = new Cookie("UUID", UUID.randomUUID().toString());
			cookie.setMaxAge(60 * 30);
			cookie.setPath("/");
			response.addCookie(cookie);
			response.addHeader("CONTEXTPATH", "/nbw/_nbz/login-success.html"); 
			
		}
		response.getWriter().write(jsonstr);
		
	}

}
