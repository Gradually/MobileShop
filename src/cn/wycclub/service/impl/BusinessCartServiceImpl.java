package cn.wycclub.service.impl;

import cn.wycclub.dao.CartDao;
import cn.wycclub.dao.ProductDao;
import cn.wycclub.domain.CartBean;
import cn.wycclub.domain.ProductBean;
import cn.wycclub.factory.DaoFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 购物车的业务服务
 *
 * @author WuYuchen
 * @date 2017-11-05 18:17
 */

public class BusinessCartServiceImpl implements cn.wycclub.service.CartService {

    CartDao dao = DaoFactory.getDaoFactory().getDao(CartDao.class);

    /**
     * 添加商品到购物车
     * */
    @Override
    public void addCart(CartBean cartBean) {
        Map<String, Integer> map = dao.checkCart(cartBean.getUid(),cartBean.getPid());
        if (map != null) {
            int cid = map.get("cid");
            int quantity = map.get("quantity");

            cartBean.setCid(cid);
            cartBean.setQuantity(cartBean.getQuantity() + quantity);
            updateCart(cartBean);
        } else {
            dao.addCart(cartBean);
        }
    }

    /**
     * 获取用户购物车中的商品
     * */
    @Override
    public List<CartBean> getCart(int uid) {
        return dao.getCart(uid);
    }

    /**
     * 更新用户购物车内容
     * */
    @Override
    public void updateCart(CartBean cartBean) {
        dao.updateCart(cartBean);
    }

    /**
     * 删除购物车中的商品
     * */
    @Override
    public void deleteCart(int cid) {
        dao.deleteCart(cid);
    }

    /**
     * 用户结算删除用户购物车商品
     * */
    public void deleteCartByOrders(int uid) {
        dao.deleteCartByOrders(uid);
    }

}
