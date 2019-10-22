package com.bjsxt.service.impl;

import com.bjsxt.goods.pojo.TbGoodsExample;
import com.bjsxt.goods.pojo.TbGoodsType;
import com.bjsxt.goods.pojo.TbGoodsTypeExample;
import com.bjsxt.mapper.TbGoodsTypeMapper;
import com.bjsxt.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 查询商品的所有类型
 * @author lvyelanshan
 * @create 2019-10-21 13:51
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
   private TbGoodsTypeMapper tbGoodsTypeMapper;

    @Override
    public List<TbGoodsType> selectAllGoodsType() {
        TbGoodsTypeExample tbGoodsTypeExample = new TbGoodsTypeExample();
        List<TbGoodsType> tbGoodsTypes = tbGoodsTypeMapper.selectByExample(tbGoodsTypeExample);
        System.out.println("服务发布者查询所有商品类型的数据："+tbGoodsTypes);
        return tbGoodsTypes;
    }
}
