package cn.wycclub.admin.web.controller;

import cn.wycclub.admin.service.AdminService;
import cn.wycclub.admin.utils.AdminUtils;
import cn.wycclub.domain.ProductBean;
import cn.wycclub.factory.ServiceFactory;
import cn.wycclub.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * 更新商品信息的servlet
 * @author WuYuchen
 * @date 2017-11-21 18:51
 */

@WebServlet(name = "UpdateProductInfoServlet",urlPatterns = {"/updateProductInfo.admin"})
public class UpdateProductInfoServlet extends HttpServlet {
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String currentPage = request.getParameter("currentPage");
        AdminService service = ServiceFactory.getServiceFactory().getService(AdminService.class);
        ProductBean productBean = WebUtils.requestToBean(request, ProductBean.class);
        service.updateProduct(productBean);
        response.sendRedirect(request.getContextPath() + "/productManager.admin?currentPage=" + currentPage);
    }
}
