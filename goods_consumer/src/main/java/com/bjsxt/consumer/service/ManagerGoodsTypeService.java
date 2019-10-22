package com.bjsxt.consumer.service;

import com.bjsxt.goods.pojo.TbGoodsType;

import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-10-21 14:02
 */
public interface ManagerGoodsTypeService {
    /**
     * 查询所有的商品类型
     */
    public List<TbGoodsType> findAllGoodsTypeService();
}
