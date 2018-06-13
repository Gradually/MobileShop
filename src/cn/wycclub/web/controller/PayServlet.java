package cn.wycclub.web.controller;

import cn.wycclub.domain.CartBean;
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
import javax.xml.ws.Service;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * 付款界面
 * @author WuYuchen
 * @date 2017-11-13 09:55
 */

@WebServlet(name = "PayServlet",urlPatterns = {"/pay.do"})
public class PayServlet extends HttpServlet {
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
        int sum = Integer.parseInt(request.getParameter("sum"));
        User user = (User) session.getAttribute("user");
        BigDecimal paymoney = new BigDecimal(sum);
        if (paymoney.compareTo(user.getMoney()) > 0) {
            String message = "亲,您余额不足,无法购买这些商品!";
            request.setAttribute("message",message);
            request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
            return;
        }
        request.setAttribute("sum",sum);
        request.getRequestDispatcher("/WEB-INF/jsp/pay.jsp").forward(request,response);
    }
}
