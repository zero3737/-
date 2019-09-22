package top.zero3737.shiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import top.zero3737.dao.ZyNbzAdminRoleMapper;
import top.zero3737.entity.ZyNbzAdminRole;
import top.zero3737.entity.ZyNbzAdminRoleExample;

public class MyRealm extends AuthorizingRealm {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ZyNbzAdminRoleMapper zyNbzAdminRoleMapper;

	@Override
	// 登录方法
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		SimpleAuthenticationInfo simpleAuthenticationInfo = null;
		// 获取用户名
		String principal = (String) token.getPrincipal();
		if (token instanceof MyUsernamePasswordToken) {

			MyUsernamePasswordToken _token = (MyUsernamePasswordToken) token;
			// 管理员登录
			if (_token.getLoginType() == UserType.ADMIN) {

				String sql = "SELECT adminname, password FROM zy_nbz_admin WHERE adminname = ?;";
				Map<String, Object> queryForMap = jdbcTemplate.queryForMap(sql, principal);
				simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, queryForMap.get("password"), getName());

			}

		} else {
			
			// 用户登录
			String sql = "SELECT username, password FROM zy_nbz_user WHERE username = ?;";
			Map<String, Object> queryForMap = jdbcTemplate.queryForMap(sql, principal);
			simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, queryForMap.get("password"), getName());	
			
		}

		return simpleAuthenticationInfo;

	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		ArrayList<String> arrayList = new ArrayList<String>();
		// 要返回的封装对象
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 获取用户
		String primaryPrincipal = (String) principals.getPrimaryPrincipal();
		
		// 根据用户查询角色
		ZyNbzAdminRoleExample zyNbzAdminRoleExample = new ZyNbzAdminRoleExample();
		zyNbzAdminRoleExample.createCriteria().andAdminnameEqualTo(primaryPrincipal);
		List<ZyNbzAdminRole> selectByExample = zyNbzAdminRoleMapper.selectByExample(zyNbzAdminRoleExample);
		for (ZyNbzAdminRole zyNbzAdminRole : selectByExample) {
			
			arrayList.add(zyNbzAdminRole.getRole());
			
		}
		// 用户角色
		simpleAuthorizationInfo.addRoles(arrayList);
		// 用户权限
		// simpleAuthorizationInfo.addStringPermissions(permissions);
		
		// 把封装对象返回给 Shiro 自动处理
		return simpleAuthorizationInfo;

	}

}
