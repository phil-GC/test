package cn.itcast.controller;

import cn.itcast.domain.Goods;
import cn.itcast.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Goods> goodsList = goodsService.findAll();
        System.out.println(goodsList);
        modelAndView.addObject("goodsList",goodsList);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(int id){
        ModelAndView modelAndView = new ModelAndView();
        Goods goods = goodsService.findById(id);
        modelAndView.addObject("goods",goods);
        modelAndView.setViewName("update");
        return modelAndView;
    }

    @RequestMapping("/update")
    public String update(Goods goods){
        goodsService.update(goods);
        return "redirect:/goods/findAll";
    }

}
