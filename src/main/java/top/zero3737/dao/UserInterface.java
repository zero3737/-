package top.zero3737.dao;

import org.apache.ibatis.annotations.Param;
import top.zero3737.javabean.User;

public interface UserInterface {

	public User queryUser(@Param("username") String username);
	
}

