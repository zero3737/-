package top.zero3737.control;

import java.io.IOException;

import javax.servlet.ServletException;
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
		String jsonstr = null;
		
		response.getWriter().write(jsonstr = new JudgeUser().judgeUser(username, password));
		if(JSON.parseObject(jsonstr, CodeLogin.class).getCode().equals("0")) {
			
			System.out.println("Ìí¼Ócookies£¡");
			
		}
		
	}

}
