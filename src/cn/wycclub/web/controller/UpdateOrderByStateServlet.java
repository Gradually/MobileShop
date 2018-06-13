package cn.wycclub.web.controller;

import cn.wycclub.factory.ServiceFactory;
import cn.wycclub.service.OrdersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 更新订单状态
 * @author WuYuchen
 * @date 2017-11-14 20:43
 */

@WebServlet(name = "UpdateOrderByStateServlet",urlPatterns = {"/updatestate.do"})
public class UpdateOrderByStateServlet extends HttpServlet {
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
        long oid = Long.parseLong(request.getParameter("oid"));
        int state = Integer.parseInt(request.getParameter("state"));
        OrdersService ordersService = ServiceFactory.getServiceFactory().getService(OrdersService.class);
        ordersService.updateOrders(oid,state);
        response.sendRedirect(request.getContextPath() + "/orders.do");
    }
}
