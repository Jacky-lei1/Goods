package com.bjsxt.service;

import com.bjsxt.goods.pojo.TbGoodsType;

import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-10-21 13:47
 */
public interface GoodsTypeService {
    /**
     * 查询所有的商品类型
     */
    List<TbGoodsType> selectAllGoodsType();

}
