package cn.wycclub.admin.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 管理员用户注销
 * @author WuYuchen
 * @date 2017-11-20 18:51
 */

@WebServlet(name = "AdminCancelServlet",urlPatterns = {"/cancel.admin"})
public class AdminCancelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession(false).removeAttribute("admin");
        request.setAttribute("message","注销完成,三秒后跳转回主页!");
        request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
    }
}
