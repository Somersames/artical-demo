package xyz;

import xyz.entity.Goods;

import java.math.BigDecimal;

public class RemainProcessor implements OrderProcessor<String, Goods>{

    @Override
    public Goods apply(String id) {
        // DO CHECK
        Goods goods = new Goods();
        goods.setId(id);
        goods.setRemain(10);
        goods.setPrice(BigDecimal.ONE);
        return goods;
    }
}
