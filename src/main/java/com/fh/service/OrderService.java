package com.fh.service;

import com.fh.model.DataTableResult;
import com.fh.model.Order;
import com.fh.model.OrderQuery;
import com.fh.model.Product;

import java.util.List;

public interface OrderService {
    DataTableResult queryOrderList(OrderQuery orderQuery);

    List<Product> queryProduct();

    Product getProductId(Integer id);

    void addOrder(Order order);

    Order getOrderById(Integer id);

    void updateOrder(Order order);

    void deleteOrder(Integer id);
}
