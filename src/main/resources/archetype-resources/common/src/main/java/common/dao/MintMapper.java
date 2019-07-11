package ${package}.common.dao;

import ${package}.common.model.po.auto.Mint;
import ${package}.common.model.po.auto.MintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MintMapper {
    long countByExample(MintExample example);

    int deleteByExample(MintExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mint record);

    int insertSelective(Mint record);

    List<Mint> selectByExample(MintExample example);

    Mint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mint record, @Param("example") MintExample example);

    int updateByExample(@Param("record") Mint record, @Param("example") MintExample example);

    int updateByPrimaryKeySelective(Mint record);

    int updateByPrimaryKey(Mint record);
}
