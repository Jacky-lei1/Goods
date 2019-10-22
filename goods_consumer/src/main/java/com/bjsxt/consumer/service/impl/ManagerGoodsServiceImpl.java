package com.bjsxt.consumer.service.impl;

import com.bjsxt.consumer.service.ManagerGoodsService;
import com.bjsxt.goods.pojo.TbGoods;
import com.bjsxt.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-10-21 15:50
 */
@Service
public class ManagerGoodsServiceImpl implements ManagerGoodsService {

    @Autowired(required = false)
    private GoodsService goodsServiceProxy;

    @Override
    public List<TbGoods> findAllGoods() {
        List<TbGoods> tbGoods = goodsServiceProxy.selectAllGoods();
        return tbGoods;
    }

    @Override
    public void insertGoods(TbGoods tbGoods) {
        goodsServiceProxy.addGoods(tbGoods);
        return;
    }

    @Override
    public List<TbGoods> findGoods(TbGoods tbGoods) {
        return goodsServiceProxy.selectGoods(tbGoods);
    }
}
