package cn.wycclub.service;

import cn.wycclub.domain.CartBean;

import java.util.List;

/**
 * @author WuYuchen
 * @date 2017-11-06 08:37
 */

public interface CartService {
    /**
     * 添加购物车
     * */
    void addCart(CartBean cartBean);


    /**
     * 获取购物车
     * */
    List<CartBean> getCart(int uid);


    /**
     * 更新购物车
     * */
    void updateCart(CartBean cartBean);


    /**
     * 删除购物车商品
     * */
    void deleteCart(int cid);


    /**
     * 删除购物车,在创建订单表的时候
     * */
    void deleteCartByOrders(int uid);
}
