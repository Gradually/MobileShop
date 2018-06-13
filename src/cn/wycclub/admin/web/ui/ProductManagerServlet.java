package cn.wycclub.admin.web.ui;

import cn.wycclub.admin.service.AdminService;
import cn.wycclub.admin.utils.AdminUtils;
import cn.wycclub.domain.PageBean;
import cn.wycclub.domain.QueryInfo;
import cn.wycclub.factory.ServiceFactory;
import cn.wycclub.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 显示商品管理界面
 * @author WuYuchen
 * @date 2017-11-20 19:03
 */

@WebServlet(name = "ProductManagerServlet",urlPatterns = {"/productManager.admin"})
public class ProductManagerServlet extends HttpServlet {
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
        QueryInfo queryInfo = WebUtils.requestToBean(request, QueryInfo.class);
        PageBean pageBean = service.getAllProduct(queryInfo);
        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/productManager.jsp").forward(request, response);
    }
}
