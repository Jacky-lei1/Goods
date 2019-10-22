package com.bjsxt.service.impl;

import com.bjsxt.goods.pojo.TbGoods;
import com.bjsxt.goods.pojo.TbGoodsExample;
import com.bjsxt.mapper.TbGoodsMapper;
import com.bjsxt.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-10-21 15:38
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private TbGoodsMapper tbGoodsMapper;

    /**
     * 查询所有商品信息
     * @return
     */
    @Override
    public List<TbGoods> selectAllGoods() {
        TbGoodsExample tbGoodsExample = new TbGoodsExample();

        List<TbGoods> tbGoods = tbGoodsMapper.selectByExample(tbGoodsExample);
        System.out.println("服务提供者查询所有商品的数据："+tbGoods);

        return tbGoods;
    }

    /**
     * 商品信息的添加
     * @param tbGoods
     */

    @Override
    public void addGoods(TbGoods tbGoods) {
        tbGoodsMapper.insert(tbGoods);
        return;
    }

    /**
     * 商品信息模糊查询
     * @param tbGoods
     * @return
     */
    @Override
    public List<TbGoods> selectGoods(TbGoods tbGoods) {

        TbGoodsExample tbGoodsExample = new TbGoodsExample();
        TbGoodsExample.Criteria criteria = tbGoodsExample.createCriteria();
        //根据提交的参数中是否有类型ID来决定是否需要加上这个类型ID的条件
        if (tbGoods.getTypeid() != null && tbGoods.getTypeid() != 0) {
            criteria.andTypeidEqualTo(tbGoods.getTypeid());
        }
        if(tbGoods.getName() != null){
            //模糊查询的条件
            criteria.andNameLike("%"+tbGoods.getName()+"%");
        }
        return tbGoodsMapper.selectByExample(tbGoodsExample);
    }
}
