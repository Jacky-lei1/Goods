package com.bjsxt.consumer.service;

import com.bjsxt.goods.pojo.TbGoods;

import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-10-21 15:49
 */
public interface ManagerGoodsService {
    public List<TbGoods> findAllGoods();
    public void insertGoods(TbGoods tbGoods);
    public List<TbGoods> findGoods(TbGoods tbGoods);
}
