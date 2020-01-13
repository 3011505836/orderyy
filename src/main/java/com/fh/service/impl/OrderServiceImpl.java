package com.fh.service.impl;

import com.fh.mapper.OrderMapper;
import com.fh.model.DataTableResult;
import com.fh.model.Order;
import com.fh.model.OrderQuery;
import com.fh.model.Product;
import com.fh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Product> queryProduct() {
        return orderMapper.queryProduct();
    }

    @Override
    public DataTableResult queryOrderList(OrderQuery orderQuery) {
        Long count = orderMapper.queryCount(orderQuery);
        List<Order> list = orderMapper.queryOrderList(orderQuery);
        DataTableResult dataTableResult = new DataTableResult(orderQuery.getDraw(),count,count,list);
        return dataTableResult;
    }

    @Override
    public Product getProductId(Integer id) {
        return orderMapper.getProductId(id);
    }

    @Override
    public void addOrder(Order order) {
        order.setIsDel(1);
        orderMapper.addOrder(order);
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderMapper.getOrderById(id);
    }

    @Override
    public void updateOrder(Order order) {
        orderMapper.updateOrder(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderMapper.deleteOrder(id);
    }
}
