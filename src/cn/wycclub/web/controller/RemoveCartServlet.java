package cn.wycclub.web.controller;

import cn.wycclub.domain.User;
import cn.wycclub.factory.ServiceFactory;
import cn.wycclub.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 删除购物车项
 * @author WuYuchen
 * @date 2017-11-11 15:10
 */

@WebServlet(name = "RemoveCartServlet",urlPatterns = {"/removecart.do"})
public class RemoveCartServlet extends HttpServlet {
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
        int cid = Integer.parseInt(request.getParameter("cid"));
        User user = (User) request.getSession().getAttribute("user");
        CartService service = ServiceFactory.getServiceFactory().getService(CartService.class);
        service.deleteCart(cid);
        response.sendRedirect(request.getContextPath() + "/cart.do?uid=" + user.getUid());
    }
}
