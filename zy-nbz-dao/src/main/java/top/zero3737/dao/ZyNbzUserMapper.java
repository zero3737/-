package top.zero3737.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.zero3737.entity.ZyNbzUser;
import top.zero3737.entity.ZyNbzUserExample;

public interface ZyNbzUserMapper {
    long countByExample(ZyNbzUserExample example);

    int deleteByExample(ZyNbzUserExample example);

    int deleteByPrimaryKey(String username);

    int insert(ZyNbzUser record);

    int insertSelective(ZyNbzUser record);

    List<ZyNbzUser> selectByExample(ZyNbzUserExample example);

    ZyNbzUser selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") ZyNbzUser record, @Param("example") ZyNbzUserExample example);

    int updateByExample(@Param("record") ZyNbzUser record, @Param("example") ZyNbzUserExample example);

    int updateByPrimaryKeySelective(ZyNbzUser record);

    int updateByPrimaryKey(ZyNbzUser record);
}