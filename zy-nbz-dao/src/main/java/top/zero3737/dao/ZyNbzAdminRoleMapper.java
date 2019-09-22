package top.zero3737.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.zero3737.entity.ZyNbzAdminRole;
import top.zero3737.entity.ZyNbzAdminRoleExample;

public interface ZyNbzAdminRoleMapper {
    long countByExample(ZyNbzAdminRoleExample example);

    int deleteByExample(ZyNbzAdminRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyNbzAdminRole record);

    int insertSelective(ZyNbzAdminRole record);

    List<ZyNbzAdminRole> selectByExample(ZyNbzAdminRoleExample example);

    ZyNbzAdminRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyNbzAdminRole record, @Param("example") ZyNbzAdminRoleExample example);

    int updateByExample(@Param("record") ZyNbzAdminRole record, @Param("example") ZyNbzAdminRoleExample example);

    int updateByPrimaryKeySelective(ZyNbzAdminRole record);

    int updateByPrimaryKey(ZyNbzAdminRole record);
}