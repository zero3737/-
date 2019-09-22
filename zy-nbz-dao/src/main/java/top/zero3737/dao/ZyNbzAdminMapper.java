package top.zero3737.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.zero3737.entity.ZyNbzAdmin;
import top.zero3737.entity.ZyNbzAdminExample;

public interface ZyNbzAdminMapper {
    long countByExample(ZyNbzAdminExample example);

    int deleteByExample(ZyNbzAdminExample example);

    int deleteByPrimaryKey(String adminname);

    int insert(ZyNbzAdmin record);

    int insertSelective(ZyNbzAdmin record);

    List<ZyNbzAdmin> selectByExample(ZyNbzAdminExample example);

    ZyNbzAdmin selectByPrimaryKey(String adminname);

    int updateByExampleSelective(@Param("record") ZyNbzAdmin record, @Param("example") ZyNbzAdminExample example);

    int updateByExample(@Param("record") ZyNbzAdmin record, @Param("example") ZyNbzAdminExample example);

    int updateByPrimaryKeySelective(ZyNbzAdmin record);

    int updateByPrimaryKey(ZyNbzAdmin record);
}