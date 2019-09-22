package top.zero3737.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.zero3737.entity.ZyNbzCms;
import top.zero3737.entity.ZyNbzCmsExample;

public interface ZyNbzCmsMapper {
    long countByExample(ZyNbzCmsExample example);

    int deleteByExample(ZyNbzCmsExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyNbzCms record);

    int insertSelective(ZyNbzCms record);

    List<ZyNbzCms> selectByExample(ZyNbzCmsExample example);

    ZyNbzCms selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyNbzCms record, @Param("example") ZyNbzCmsExample example);

    int updateByExample(@Param("record") ZyNbzCms record, @Param("example") ZyNbzCmsExample example);

    int updateByPrimaryKeySelective(ZyNbzCms record);

    int updateByPrimaryKey(ZyNbzCms record);
}