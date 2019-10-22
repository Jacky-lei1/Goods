package com.bjsxt.service;

import com.bjsxt.goods.pojo.TbGoods;

import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-10-21 15:37
 */
public interface GoodsService {

    public List<TbGoods> selectAllGoods();

    public void addGoods(TbGoods tbGoods);

    public List<TbGoods> selectGoods(TbGoods tbGoods);
}
