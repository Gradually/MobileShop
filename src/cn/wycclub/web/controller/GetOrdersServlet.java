package cn.wycclub.web.controller;

import cn.wycclub.domain.*;
import cn.wycclub.factory.ServiceFactory;
import cn.wycclub.service.OrdersService;
import cn.wycclub.service.ProductService;
import cn.wycclub.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 获取订单分页
 * @author WuYuchen
 * @date 2017-11-12 19:32
 */

@WebServlet(name = "GetOrdersServlet", urlPatterns = {"/orders.do"})
public class GetOrdersServlet extends HttpServlet {
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
        OrdersService ordersService = ServiceFactory.getServiceFactory().getService(OrdersService.class);
        ProductService productService = ServiceFactory.getServiceFactory().getService(ProductService.class);
        QueryInfo queryInfo = WebUtils.requestToBean(request, QueryInfo.class);
        User user = (User) session.getAttribute("user");
        PageBean pageBean = ordersService.getCollectionByPage(queryInfo, user.getUid());
        List<OrdersBean> list = pageBean.getList();
        if (list != null) {
            for (OrdersBean ordersBean : list) {
                ProductBean productBean = productService.getProductById(ordersBean.getPid());
                ordersBean.setProductBean(productBean);
            }
            request.setAttribute("pageBean",pageBean);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/orders.jsp").forward(request, response);
    }
}
