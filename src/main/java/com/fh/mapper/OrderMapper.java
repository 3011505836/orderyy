package com.fh.mapper;

import com.fh.model.Order;
import com.fh.model.OrderQuery;
import com.fh.model.Product;

import java.util.List;

public interface OrderMapper {
    Long queryCount(OrderQuery orderQuery);

    List<Order> queryOrderList(OrderQuery orderQuery);

    List<Product> queryProduct();

    Product getProductId(Integer id);

    void addOrder(Order order);

    Order getOrderById(Integer id);

    void updateOrder(Order order);

    void deleteOrder(Integer id);
}
