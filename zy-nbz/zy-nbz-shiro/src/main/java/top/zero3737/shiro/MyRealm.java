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
	// ��¼����
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		SimpleAuthenticationInfo simpleAuthenticationInfo = null;
		// ��ȡ�û���
		String principal = (String) token.getPrincipal();
		if (token instanceof MyUsernamePasswordToken) {

			MyUsernamePasswordToken _token = (MyUsernamePasswordToken) token;
			// ����Ա��¼
			if (_token.getLoginType() == UserType.ADMIN) {

				String sql = "SELECT adminname, password FROM zy_nbz_admin WHERE adminname = ?;";
				Map<String, Object> queryForMap = jdbcTemplate.queryForMap(sql, principal);
				simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, queryForMap.get("password"), getName());

			}

		} else {
			
			// �û���¼
			String sql = "SELECT username, password FROM zy_nbz_user WHERE username = ?;";
			Map<String, Object> queryForMap = jdbcTemplate.queryForMap(sql, principal);
			simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, queryForMap.get("password"), getName());	
			
		}

		return simpleAuthenticationInfo;

	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		ArrayList<String> arrayList = new ArrayList<String>();
		// Ҫ���صķ�װ����
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// ��ȡ�û�
		String primaryPrincipal = (String) principals.getPrimaryPrincipal();
		
		// �����û���ѯ��ɫ
		ZyNbzAdminRoleExample zyNbzAdminRoleExample = new ZyNbzAdminRoleExample();
		zyNbzAdminRoleExample.createCriteria().andAdminnameEqualTo(primaryPrincipal);
		List<ZyNbzAdminRole> selectByExample = zyNbzAdminRoleMapper.selectByExample(zyNbzAdminRoleExample);
		for (ZyNbzAdminRole zyNbzAdminRole : selectByExample) {
			
			arrayList.add(zyNbzAdminRole.getRole());
			
		}
		// �û���ɫ
		simpleAuthorizationInfo.addRoles(arrayList);
		// �û�Ȩ��
		// simpleAuthorizationInfo.addStringPermissions(permissions);
		
		// �ѷ�װ���󷵻ظ� Shiro �Զ�����
		return simpleAuthorizationInfo;

	}

}
