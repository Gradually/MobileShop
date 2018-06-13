package cn.wycclub.admin.web.controller;

import cn.wycclub.admin.service.AdminService;
import cn.wycclub.admin.service.impl.AdminServiceImpl;
import cn.wycclub.admin.utils.AdminUtils;
import cn.wycclub.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Service;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * 管理员后台主页
 * @author WuYuchen
 * @date 2017-11-19 17:18
 */

@WebServlet(name = "AdminIndexShow",urlPatterns = {"/index.admin"})
public class AdminIndexShow extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || !AdminUtils.getAdminUsername().equals(session.getAttribute("admin"))) {
            request.setAttribute("message","抱歉,您没有登陆,请登录后再次尝试!");
            request.getRequestDispatcher("/WEB-INF/jsp/admin/message.jsp").forward(request, response);
            return;
        }
        AdminService service = ServiceFactory.getServiceFactory().getService(AdminService.class);
        BigDecimal ordersMoney = service.getOrdersMoneyBySum();
        int productSum = service.getQuantity("product_info");
        int userSum = service.getQuantity("user_info");
        int ordersSum = service.getQuantity("product_orders");
        request.setAttribute("productSum",productSum);
        request.setAttribute("userSum",userSum);
        request.setAttribute("ordersSum",ordersSum);
        request.setAttribute("ordersMoney",ordersMoney);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/index.jsp").forward(request, response);
    }
}
