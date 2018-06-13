package cn.wycclub.web.controller;

import cn.wycclub.domain.CartBean;
import cn.wycclub.domain.OrdersBean;
import cn.wycclub.domain.ProductBean;
import cn.wycclub.domain.User;
import cn.wycclub.factory.ServiceFactory;
import cn.wycclub.service.CartService;
import cn.wycclub.service.OrdersService;
import cn.wycclub.service.ProductService;
import cn.wycclub.service.UserService;
import cn.wycclub.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 添加订单项
 * @author WuYuchen
 * @date 2017-11-13 17:27
 */

@WebServlet(name = "AddOrdersServlet",urlPatterns = {"/addorders.do"})
public class AddOrdersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            request.setAttribute("message","抱歉,您没有登陆,请登录后再次尝试!");
            request.setAttribute("page","login");
            request.getRequestDispatcher("/WEB-INF/jsp/PowerMessage.jsp").forward(request, response);
            return;
        }
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        UserService userService = ServiceFactory.getServiceFactory().getService(UserService.class);
        CartService cartService = ServiceFactory.getServiceFactory().getService(CartService.class);
        OrdersService ordersService = ServiceFactory.getServiceFactory().getService(OrdersService.class);
        ProductService productService = ServiceFactory.getServiceFactory().getService(ProductService.class);

        //修改用户信息
        User user = (User) session.getAttribute("user");
        String address = request.getParameter("address");
        BigDecimal paysum = new BigDecimal(request.getParameter("paysum"));
        String tel = request.getParameter("tel");
        user.setAddress(address);
        user.setTel(tel);
        user.setMoney(user.getMoney().subtract(paysum));
        userService.update(user);

        //删除用户购物车中的商品
        List<CartBean> list = cartService.getCart(user.getUid());
        cartService.deleteCartByOrders(user.getUid());

        //将购物车中的商品转移到订单中
        for (CartBean cartBean : list) {
            cartBean.setProductBean(productService.getProductById(cartBean.getPid()));
            OrdersBean ordersBean = new OrdersBean();
            WebUtils.copyToBean(cartBean, ordersBean);
            ordersService.addOrders(ordersBean);
        }
        response.sendRedirect(request.getContextPath() + "/orders.do");
    }
}
