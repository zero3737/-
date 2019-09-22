package top.zero3737.userservice;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import top.zero3737.dao.ZyNbzAdminMapper;
import top.zero3737.dao.ZyNbzAdminRoleMapper;
import top.zero3737.dao.ZyNbzRoleMapper;
import top.zero3737.dao.ZyNbzUserMapper;
import top.zero3737.entity.ZyNbzAdmin;
import top.zero3737.entity.ZyNbzAdminRole;
import top.zero3737.entity.ZyNbzRole;
import top.zero3737.entity.ZyNbzUser;

@Service
public class UserService {
	
	@Autowired
	private ZyNbzUserMapper zyNbzUserMapper;
	@Autowired
	private ZyNbzAdminMapper zyNbzAdminMapper;
	@Autowired
	private ZyNbzAdminRoleMapper zyNbzAdminRoleMapper;
	@Autowired
	private ZyNbzRoleMapper zyNbzRoleMapper;
	
	public Map<String, Object> addAdmin(String username, String password, String eMail) {
		
		ZyNbzAdmin zyNbzAdmin = new ZyNbzAdmin();
		Map<String, Object> map = new HashedMap();
		
		try {
			
			ZyNbzAdmin selectByPrimaryKey = zyNbzAdminMapper.selectByPrimaryKey(username);
			if(selectByPrimaryKey == null) {
				
				zyNbzAdmin.setCreateTime(new Date());
				zyNbzAdmin.seteMail(eMail);
				zyNbzAdmin.setAdminname(username);;
				zyNbzAdmin.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
				zyNbzAdminMapper.insert(zyNbzAdmin);
				map.put("code", "1");
				map.put("msg", "成功");
				
			} else {
				
				map.put("code", "0");
				map.put("msg", "用户名已存在");
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			map.put("code", "-1");
			map.put("msg", "添加用户发生异常");
			
		}
		
		return map;
		
	}
	
	public Map<String, Object> addUser(String username, String password, String eMail) {
		
		ZyNbzUser zyNbzUser = new ZyNbzUser();
		Map<String, Object> map = new HashedMap();
		
		try {
			
			ZyNbzUser selectByPrimaryKey = zyNbzUserMapper.selectByPrimaryKey(username);
			if(selectByPrimaryKey == null) {
				
				zyNbzUser.setCreateTime(new Date());
				zyNbzUser.seteMail(eMail);
				zyNbzUser.setUsername(username);
				zyNbzUser.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
				zyNbzUserMapper.insert(zyNbzUser);
				map.put("code", "1");
				map.put("msg", "成功");
				
			} else {
				
				map.put("code", "0");
				map.put("msg", "用户名已存在");
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			map.put("code", "-1");
			map.put("msg", "添加用户发生异常");
			
		}
		
		return map;
		
	}
	
	public Map<String, Object> addAdminRole(String username, Integer roleId) {
		
		ZyNbzAdminRole zyNbzAdminRole = new ZyNbzAdminRole();
		Map<String, Object> map = new HashedMap();
		
		try {
			
			ZyNbzRole selectByPrimaryKey = zyNbzRoleMapper.selectByPrimaryKey(roleId);
			zyNbzAdminRole.setId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
			zyNbzAdminRole.setCreateTime(new Date());
			zyNbzAdminRole.setAdminname(username);
			zyNbzAdminRole.setRole(selectByPrimaryKey.getRole());
			zyNbzAdminRoleMapper.insert(zyNbzAdminRole);
			map.put("code", "1");
			map.put("msg", "成功");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			map.put("code", "0");
			map.put("msg", "添加用户发生异常");
			
		}
		
		return map;
		
	}

}
