package cn.wycclub.admin.web.ui;

import cn.wycclub.admin.utils.AdminUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 显示管理员后台主页或者登陆界面
 * @author WuYuchen
 * @date 2017-11-19 16:16
 */

@WebServlet(name = "AdminLoginShow" , urlPatterns = {"/admin.admin"})
public class AdminLoginShow extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null &&  AdminUtils.getAdminUsername().equals(session.getAttribute("admin"))) {
            response.sendRedirect(request.getContextPath() + "/index.admin");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/jsp/admin/login.jsp").forward(request, response);
    }
}
