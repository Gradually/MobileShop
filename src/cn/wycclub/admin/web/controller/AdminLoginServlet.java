package cn.wycclub.admin.web.controller;

import cn.wycclub.admin.utils.AdminUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 管理员后台的登陆验证
 * @author WuYuchen
 * @date 2017-11-19 16:31
 */

@WebServlet(name = "AdminLoginServlet", urlPatterns = {"/login.admin"})
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("admin") == username) {
            System.out.println("aaa");
            request.setAttribute("message","抱歉,您没有登陆,请登录后再次尝试!");
            request.getRequestDispatcher("/WEB-INF/jsp/admin/message.jsp").forward(request, response);
            return;
        }
        if (AdminUtils.intoAdmin(username, password)) {
            request.getSession().setAttribute("admin",username);
            response.sendRedirect(request.getContextPath() + "/index.admin");
        } else {
            request.setAttribute("message","管理员账号或密码不存在!");
            request.getRequestDispatcher("/WEB-INF/jsp/admin/message.jsp").forward(request, response);
        }
    }
}
