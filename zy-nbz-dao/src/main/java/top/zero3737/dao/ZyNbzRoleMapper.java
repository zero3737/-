package top.zero3737.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.zero3737.entity.ZyNbzRole;
import top.zero3737.entity.ZyNbzRoleExample;

public interface ZyNbzRoleMapper {
    long countByExample(ZyNbzRoleExample example);

    int deleteByExample(ZyNbzRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZyNbzRole record);

    int insertSelective(ZyNbzRole record);

    List<ZyNbzRole> selectByExample(ZyNbzRoleExample example);

    ZyNbzRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZyNbzRole record, @Param("example") ZyNbzRoleExample example);

    int updateByExample(@Param("record") ZyNbzRole record, @Param("example") ZyNbzRoleExample example);

    int updateByPrimaryKeySelective(ZyNbzRole record);

    int updateByPrimaryKey(ZyNbzRole record);
}