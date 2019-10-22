package com.bjsxt.consumer.controller;

import com.bjsxt.consumer.service.FileUploadService;
import com.bjsxt.consumer.service.ManagerGoodsService;
import com.bjsxt.consumer.service.ManagerGoodsTypeService;
import com.bjsxt.goods.pojo.TbGoods;
import com.bjsxt.goods.pojo.TbGoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-10-21 15:49
 */
@Controller
public class GoodsController {
    @Autowired
    private ManagerGoodsTypeService managerGoodsTypeService;

    @Autowired
    private ManagerGoodsService managerGoodsService;

    @Autowired
    private FileUploadService fileUploadService;

    /**
     * 查找所有商品
     */
    @RequestMapping(value = "/findAllGoods",
            produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public String showAllGoods(HttpServletRequest request){
        List<TbGoods> tbGoods = managerGoodsService.findAllGoods();
        List<TbGoodsType> tbGoodsTypes = managerGoodsTypeService.findAllGoodsTypeService();
        request.getSession().setAttribute("goods",tbGoods);
        request.getSession().setAttribute("types",tbGoodsTypes);
        return "redirect:/index";

    }


    @RequestMapping(value = "/findGoods",
            produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public String findGoods(TbGoods tbGoods,HttpServletRequest request) {
        List<TbGoods> goods = managerGoodsService.findGoods(tbGoods);
        request.getSession().setAttribute("goods", goods);
        List<TbGoodsType> types = managerGoodsTypeService.findAllGoodsTypeService();
        request.getSession().setAttribute("types", types);
        return "redirect:/index";
    }


    /**
     * 添加商品信息
     */
    @RequestMapping(value = "/addGoods",
            produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public String addGoods(TbGoods tbGoods, MultipartFile multipartFile, HttpServletRequest request){
        try {
            /*上传图片到服务器*/
            String picPath = fileUploadService.picUpload(multipartFile);
            /*将获取到的图片的名字封装到tbGods实体类中*/
            tbGoods.setPicture(picPath);
            /*调用方法添加数据到表中*/
            managerGoodsService.insertGoods(tbGoods);
            /*将状态设置到session中，用于前台获取*/
            request.getSession().setAttribute("msg","添加成功！");
            /*带着数据重定向到index页面*/
            return "redirect:/index";
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("msg","添加失败！");
            /*如果出现异常，则重定向到添加商品的页面*/
            return "redirect:/goods-add";
        }
    }

}
