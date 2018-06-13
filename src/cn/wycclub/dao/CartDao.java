package cn.wycclub.dao;

import cn.wycclub.domain.CartBean;

import java.util.List;
import java.util.Map;

/**
 * @author WuYuchen
 * @date 2017-11-05 18:03
 */

public interface CartDao {

    /**
     * 添加商品到购物车
     * */
    void addCart(CartBean cartBean);

    /**
     * 从购物车中删除商品
     * */
    void deleteCart(int cid);

    /**
     * 更新购物车中的商品信息
     * */
    void updateCart(CartBean cartBean);


    /**
     * 获取购物车中的商品信息
     * */
    List<CartBean> getCart(int uid);

    /**
     * 检查购物车中是否存在相同商品
     * */
    Map<String,Integer> checkCart(int uid, int pid);

    /**
     * 用户结算删除购物车中的商品,
     * */
    void deleteCartByOrders(int uid);
}
