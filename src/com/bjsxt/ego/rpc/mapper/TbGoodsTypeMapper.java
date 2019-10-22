package com.bjsxt.ego.rpc.mapper;

import com.bjsxt.goods.pojo.TbGoodsType;
import com.bjsxt.goods.pojo.TbGoodsTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGoodsTypeMapper {
    int countByExample(TbGoodsTypeExample example);

    int deleteByExample(TbGoodsTypeExample example);

    int deleteByPrimaryKey(Integer typeid);

    int insert(TbGoodsType record);

    int insertSelective(TbGoodsType record);

    List<TbGoodsType> selectByExample(TbGoodsTypeExample example);

    TbGoodsType selectByPrimaryKey(Integer typeid);

    int updateByExampleSelective(@Param("record") TbGoodsType record, @Param("example") TbGoodsTypeExample example);

    int updateByExample(@Param("record") TbGoodsType record, @Param("example") TbGoodsTypeExample example);

    int updateByPrimaryKeySelective(TbGoodsType record);

    int updateByPrimaryKey(TbGoodsType record);
}