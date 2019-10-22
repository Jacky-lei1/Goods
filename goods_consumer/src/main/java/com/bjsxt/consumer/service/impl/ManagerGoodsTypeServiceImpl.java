package com.bjsxt.consumer.service.impl;

import com.bjsxt.consumer.service.ManagerGoodsTypeService;
import com.bjsxt.goods.pojo.TbGoodsType;
import com.bjsxt.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-10-21 14:04
 */
@Service
public class ManagerGoodsTypeServiceImpl implements ManagerGoodsTypeService {

    /**
     * 查询所有商品的类型
     *
     */
    @Autowired(required = false)
    private GoodsTypeService goodsTypeServiceProxy;


    @Override
    public List<TbGoodsType> findAllGoodsTypeService() {
        return goodsTypeServiceProxy.selectAllGoodsType();
    }
}
