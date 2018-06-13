package cn.wycclub.web.controller;

import cn.wycclub.domain.CartBean;
import cn.wycclub.domain.ProductBean;
import cn.wycclub.domain.User;
import cn.wycclub.factory.ServiceFactory;
import cn.wycclub.service.CartService;
import cn.wycclub.service.ProductService;
import cn.wycclub.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 更新购物车
 * @author WuYuchen
 * @date 2017-11-08 16:20
 */

@WebServlet(name = "UpdateCartServlet", urlPatterns = {"/updatecart.do"})
public class UpdateCartServlet extends HttpServlet {
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
        CartService cartService = ServiceFactory.getServiceFactory().getService(CartService.class);
        ProductService productService = ServiceFactory.getServiceFactory().getService(ProductService.class);
        CartBean cartBean = WebUtils.requestToBean(request, CartBean.class);
        ProductBean productBean = productService.getProductById(cartBean.getPid());
        cartBean.setProductBean(productBean);
        cartService.updateCart(cartBean);
        User user = (User) request.getSession().getAttribute("user");
        response.sendRedirect(request.getContextPath() + "/cart.do?uid=" + user.getUid());
    }
}