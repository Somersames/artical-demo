package xyz;

import xyz.entity.Goods;
import xyz.entity.OrderInfo;

public class CouponProcessor implements OrderProcessor<Goods, OrderInfo>{

    @Override
    public OrderInfo apply(Goods goods) {
        return null;
    }
}
