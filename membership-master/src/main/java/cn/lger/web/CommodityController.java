package cn.lger.web;

import cn.lger.dao.GoodDao;
import cn.lger.domain.Commodity;
import cn.lger.exception.BalanceNotEnoughException;
import cn.lger.exception.CommodityNumberNotEnoughException;
import cn.lger.exception.IdNotFoundException;
import cn.lger.service.CommodityService;
import cn.lger.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-17.
 */
@Controller
public class CommodityController {

    @Resource
    private CommodityService commodityService;
    @Autowired
    private GoodService goodservice;
    @GetMapping("/addCommodity")
    public String getAddCommodityView(){
        return "addCommodity";
    }

    @PostMapping("/addCommodity")
    @ResponseBody
    public String addCommodity(Commodity commodity){
        try{
            //return commodityService.add(commodity);
            commodity.setId(commodity.toString());
            GoodDao add = goodservice.dooperation("addgood");
            int result = add.operation(commodity);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return "success";
    }
    @PostMapping("/deleteCommodity")
    @ResponseBody
    public String deleteCommodity(Commodity commodity){
      System.out.println("aaaaaaaaaaaa");

        System.out.println(commodity.getId());
        System.out.println(commodity.getCommodityPrice());
        try{
            //commodity.setId(commodity.toString());

            GoodDao delete = goodservice.dooperation("deletegood");
            int result = delete.operation(commodity);
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }


    @GetMapping("/modifyCommodity")
    public String getModifyCommodityView(){
        return "modifyCommodity";
    }

    @PostMapping("/updateCommodity")
    @ResponseBody
    public String updateCommodity(Commodity commodity){

        try{
           // commodityService.updateMemberGrade(commodity);
            GoodDao update = goodservice.dooperation("updategood");
            int result = update.operation(commodity);
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @PostMapping("/queryAllCommodity")
    @ResponseBody
    public Page<Commodity> queryAllCommodity(Integer currentPage){
        if (currentPage == null || currentPage < 0){
            currentPage = 0;
        }
        Pageable pageable = new PageRequest(currentPage, 3);
        return commodityService.findAll(pageable);
    }
    @GetMapping("/purchaseCommodity")
    public String getPurchaseCommodityView(){
        return "purchaseCommodity";
    }

    @PostMapping("/purchaseCommodity")
    @ResponseBody
    public String purchaseCommodity(String memberId, String commodityId, boolean balance){
        try{
            commodityService.purchaseCommodity(memberId, commodityId, balance);
        } catch (CommodityNumberNotEnoughException e){
            e.printStackTrace();
            return "商品数量不足";
        } catch (BalanceNotEnoughException e){
            e.printStackTrace();
            return "会员余额不足";
        } catch (IdNotFoundException e){
            e.printStackTrace();
            return "会员账号或商品账号不存在";
        }
        return "success";
    }
}
