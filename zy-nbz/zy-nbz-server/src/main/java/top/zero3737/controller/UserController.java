package top.zero3737.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import top.zero3737.config.Config;
import top.zero3737.shiro.MyUsernamePasswordToken;
import top.zero3737.shiro.UserType;
import top.zero3737.userservice.UserService;
import top.zero3737.util.GetMap;

@Controller
public class UserController {

	@Autowired
	private Config config;
	@Autowired
	private UserService userService;
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = { "/loginuser", "/loginadmin" })
	@ResponseBody
	public String loginUser(String username, String password, String verifycode) {

		String attribute = (String) request.getSession().getAttribute("verifyCode");

		if (!request.getServletPath().equals("/loginadmin")) {

			if (!verifycode.equals(attribute)) {

				return JSON.toJSONString(new GetMap().getFail("验证码错误"));

			}

		}

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = null;
		Map<String, Object> map = new HashedMap();
		// 状态 0 为默认值
		Integer state = 0;

		if (request.getServletPath().equals("/loginuser")) {

			usernamePasswordToken = new UsernamePasswordToken(username,
					DigestUtils.md5DigestAsHex(password.getBytes()));

		} else if (request.getServletPath().equals("/loginadmin")) {

			usernamePasswordToken = new MyUsernamePasswordToken(username,
					DigestUtils.md5DigestAsHex(password.getBytes()), UserType.ADMIN);
			state = 1;

		}
		try {

			subject.login(usernamePasswordToken);
			if (subject.isAuthenticated()) {

				if (state == 0) {

					map.put("url", config.LOCALSERVER + config.PROJECTNAME + config.SUCCESS_URL);
					map.put("code", "1");

				} else if (state == 1) {

					map.put("url", config.LOCALSERVER + config.PROJECTNAME + config.ADMIN_URL);
					map.put("code", "1");

				}

			}

		} catch (Exception e) {

			map.put("code", "0");
			map.put("msg", "用户名或密码错误");

		}

		return JSON.toJSONString(map);

	}

	@RequestMapping(value = { "/logoutuser", "/logoutadmin" })
	@ResponseBody
	public String logoutUser() {

		Subject subject = SecurityUtils.getSubject();
		Map<String, Object> map = new HashedMap();

		try {

			subject.logout();
			if (request.getServletPath().equals("/logoutuser")) {

				map.put("url", config.REMOTESERVER);
				map.put("code", "1");
				map.put("msg", "成功");

			} else if (request.getServletPath().equals("/logoutadmin")) {

				map.put("url", config.REMOTESERVER + config.LOGINADMIN);
				map.put("code", "1");
				map.put("msg", "成功");

			}

		} catch (Exception e) {

			map.put("code", "0");
			map.put("msg", "退出异常");

		}

		return JSON.toJSONString(map);

	}

	@RequestMapping(value = { "/adduser", "/addadmin" })
	@ResponseBody
	public String addUser(String username, String password, String eMail) {

		Map<String, Object> map = null;

		if (request.getServletPath().equals("/adduser")) {

			map = userService.addUser(username, password, eMail);

		} else if (request.getServletPath().equals("/addadmin")) {

			map = userService.addAdmin(username, password, eMail);

		}

		return JSON.toJSONString(map);

	}

	@RequestMapping("/addadminrole")
	@ResponseBody
	public String addAdminRole(String username, Integer roleId) {

		return JSON.toJSONString(userService.addAdminRole(username, roleId));

	}

}
