package com.springmvc.controler;

import com.springmvc.dao.ItemsMapper;
import com.springmvc.entity.Items;
import com.springmvc.service.ItemService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ItemsControler {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/Items/list")
    public ModelAndView hello(){
        ModelAndView m = new ModelAndView();
        // 创建页面需要显示的商品数据
        List<Items> list = itemService.getItemsListq();
        //数据
        m.addObject("itemList",list);
        m.setViewName("itemList");
        return m;
    }

    @RequestMapping(value = "/Items/toEidt")
    public ModelAndView toEidt(Integer id,
                               HttpServletRequest request, HttpServletResponse response
            , HttpSession session, Model model){
        //String id = request.getParameter("id");
        //Items item = itemService.getItemsById(Integer.valueOf(id));
        Items item = itemService.getItemsById(id);
        ModelAndView m = new ModelAndView();
        m.addObject("item",item);
        m.setViewName("editItem");
        return m;
    }
    //修改
    @RequestMapping(value = "/Items/update")
    public ModelAndView update(Items idtems){
        idtems.setTime(new Date());
        itemService.updateItems(idtems);
        ModelAndView m = new ModelAndView();
        m.setViewName("success");
        return m;
    }

    //删除多个
    @RequestMapping(value = "/deletes")
    public ModelAndView deletes(Integer ids[]){


        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        return mav;
    }

    //修改多个
    @RequestMapping(value = "/updates")
    public ModelAndView updates(Integer ids[]){


        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        return mav;
    }

    //json数据交互
    @RequestMapping(value = "/json")
    public @ResponseBody Items json(@RequestBody  Items items){
        System.out.println(items);
        return items;
    }
}
