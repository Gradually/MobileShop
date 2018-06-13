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
 * 删除商品的servlet
 * @author WuYuchen
 * @date 2017-11-22 13:31
 */

@WebServlet(name = "RemoveProductServlet",urlPatterns = {"/removeProduct.admin"})
public class RemoveProductServlet extends HttpServlet {
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
        String currentPage = request.getParameter("currentPage");
        service.removeProduct(Integer.parseInt(request.getParameter("pid")));
        response.sendRedirect(request.getContextPath() + "/productManager.admin?currentPage=" + currentPage);
    }
}
