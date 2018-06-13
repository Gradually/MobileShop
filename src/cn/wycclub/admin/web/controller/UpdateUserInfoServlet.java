package cn.wycclub.admin.web.controller;

import cn.wycclub.admin.service.AdminService;
import cn.wycclub.admin.utils.AdminUtils;
import cn.wycclub.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 更新用户信息的servlet
 * @author WuYuchen
 * @date 2017-11-22 15:26
 */

@WebServlet(name = "UpdateUserInfoServlet",urlPatterns = {"/updateUserInfo.admin"})
public class UpdateUserInfoServlet extends HttpServlet {
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
        int state = Integer.parseInt(request.getParameter("state"));
        int uid = Integer.parseInt(request.getParameter("uid"));
        String currentPage = request.getParameter("currentPage");
        AdminService service = ServiceFactory.getServiceFactory().getService(AdminService.class);
        service.updateUserInfo(uid, state);
        response.sendRedirect(request.getContextPath() + "/userManager.admin?currentPage=" + currentPage);
    }
}
