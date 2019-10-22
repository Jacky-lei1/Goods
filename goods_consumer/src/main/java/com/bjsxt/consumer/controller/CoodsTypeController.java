package com.bjsxt.consumer.controller;

import com.bjsxt.consumer.service.ManagerGoodsTypeService;
import com.bjsxt.goods.pojo.TbGoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-10-21 14:44
 */
@Controller
public class CoodsTypeController {

    /**
     * 注入本地的service对象
     */
    @Autowired
    private ManagerGoodsTypeService managerGoodsTypeService;

    /**
     * 查询商品的所有类型
     */
    @RequestMapping(value = "/findAllType",
            produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public List<TbGoodsType> showIndex(){
        List<TbGoodsType> allGoodsTypeService = managerGoodsTypeService.findAllGoodsTypeService();
        System.out.println("服务消费者中获取到的所有商品类型的数据："+allGoodsTypeService);
        return allGoodsTypeService;
    }
}
