package com.fh.controller;

import com.fh.common.ServerResponse;
import com.fh.model.DataTableResult;
import com.fh.model.Order;
import com.fh.model.OrderQuery;
import com.fh.model.Product;
import com.fh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //queryProduct
    @RequestMapping("queryProduct")
    public Map<String,Object> queryProduct(){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Product> typeList = orderService.queryProduct();
            resultMap.put("code",200);
            resultMap.put("data",typeList);
            resultMap.put("message","请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",500);
            resultMap.put("data",null);
            resultMap.put("message","运行异常");
        }
        return resultMap;
    }

    @RequestMapping("queryOrderList")
    public Map<String,Object> queryOrderList(@RequestBody OrderQuery orderQuery){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            DataTableResult dataTableResult = orderService.queryOrderList(orderQuery);
            resultMap.put("code",200);
            resultMap.put("data",dataTableResult);
            resultMap.put("message","请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",500);
            resultMap.put("data",null);
            resultMap.put("message","运行异常");
        }
        return resultMap;
    }

    @RequestMapping("getProductId")
    public ServerResponse getProductId(Integer id){
        Product product = orderService.getProductId(id);
        return ServerResponse.success(product);
    }

    @RequestMapping("addOrder")
    public ServerResponse addOrder(Order order) {
        orderService.addOrder(order);
        return ServerResponse.success();
    }


    @RequestMapping("getOrderById")
    public ServerResponse getOrderById(Integer id) {
        Order order = orderService.getOrderById(id);
        return ServerResponse.success(order);
    }

    @RequestMapping("updateOrder")
    public ServerResponse updateOrder(Order order) {
        orderService.updateOrder(order);
        return ServerResponse.success();
    }

    @RequestMapping("deleteOrder")
    public ServerResponse deleteOrder(Integer id) {
        orderService.deleteOrder(id);
        return ServerResponse.success();
    }

}
