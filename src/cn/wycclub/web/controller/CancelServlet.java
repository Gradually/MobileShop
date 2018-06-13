package cn.wycclub.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注销登陆
 * @author WuYuchen
 * @date 2017-10-30 21:48
 */

@WebServlet(name = "CancelServlet" ,urlPatterns = {"/cancel.do"})
public class CancelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.getSession().removeAttribute("user");
            request.setAttribute("message", "注销成功!");
            request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
        } catch(Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "注销失败!");
            request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
        }
    }
}
