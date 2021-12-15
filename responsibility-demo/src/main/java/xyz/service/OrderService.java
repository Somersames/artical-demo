package xyz.service;

import xyz.CouponProcessor;
import xyz.OrderProcessor;
import xyz.RemainProcessor;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    public static void main(String[] args) {
        new OrderService().createOrder();
    }

    private void createOrder() {
        List<OrderProcessor> orderProcessorList = new ArrayList<>(2);
        orderProcessorList.add(new RemainProcessor());
        orderProcessorList.add(new CouponProcessor());
        orderProcessorList.stream().reduce(OrderProcessor::andThen)
                .orElseThrow(() -> new RuntimeException("function is error"))
                .apply("d1");
    }
}
