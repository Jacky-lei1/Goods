package com.bjsxt.consumer.controller;

import com.bjsxt.consumer.service.ManagerGoodsTypeService;
import com.bjsxt.goods.pojo.TbGoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-10-21 11:37
 */
@Controller
public class PageController {


    /**
     * 加载商城后台的首页
     */
    @RequestMapping("/")
    public String showIndex(){
        //请求装发到findAllGoods，查询所有的商品
        return "forward:/findAllGoods";
    }

    /**
     * 加载其他的jsp视图
     */
    @RequestMapping("{page}")
    public String showPage(@PathVariable String page){
        System.out.println("加载其他的jsp视图");
        return page;

    }
}
