package cn.wycclub.web.controller;

import cn.wycclub.domain.CartBean;
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
import javax.xml.ws.Service;
import java.io.IOException;

/**
 * 添加购物车项
 * @author WuYuchen
 * @date 2017-11-08 15:11
 */

@WebServlet(name = "AddCartServlet", urlPatterns = {"/addcart.do"})
public class AddCartServlet extends HttpServlet {
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
        cartBean.setProductBean(productService.getProductById(cartBean.getPid()));
        cartService.addCart(cartBean);
        int pid = Integer.parseInt(request.getParameter("pid"));
        response.sendRedirect(request.getContextPath() + "/product.do?pid=" + pid);
    }
}
