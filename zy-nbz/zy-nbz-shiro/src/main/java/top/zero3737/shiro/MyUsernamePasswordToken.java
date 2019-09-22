package top.zero3737.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class MyUsernamePasswordToken extends UsernamePasswordToken {

	private static final long serialVersionUID = 1486701433612712741L;

	private String loginType;

	public MyUsernamePasswordToken(final String username, final String password, final String loginType) {
		
		super(username, password);
		this.setLoginType(loginType);
		
	}

	public String getLoginType() {
		
		return loginType;
		
	}

	public void setLoginType(String loginType) {
		
		this.loginType = loginType;
		
	}

}
