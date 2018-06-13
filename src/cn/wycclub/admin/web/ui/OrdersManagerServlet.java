package cn.wycclub.admin.web.ui;

import cn.wycclub.admin.service.AdminService;
import cn.wycclub.admin.utils.AdminUtils;
import cn.wycclub.domain.OrdersBean;
import cn.wycclub.domain.PageBean;
import cn.wycclub.domain.QueryInfo;
import cn.wycclub.factory.ServiceFactory;
import cn.wycclub.service.ProductService;
import cn.wycclub.service.UserService;
import cn.wycclub.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 显示订单管理界面
 * @author WuYuchen
 * @date 2017-11-21 15:37
 */

@WebServlet(name = "OrdersManagerServlet",urlPatterns = {"/ordersManager.admin"})
public class OrdersManagerServlet extends HttpServlet {
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
        QueryInfo queryInfo = WebUtils.requestToBean(request, QueryInfo.class);
        AdminService service = ServiceFactory.getServiceFactory().getService(AdminService.class);
        ProductService productService = ServiceFactory.getServiceFactory().getService(ProductService.class);
        UserService userService = ServiceFactory.getServiceFactory().getService(UserService.class);
        PageBean pageBean = service.getAllOrders(queryInfo);
        List<OrdersBean> list = pageBean.getList();
        for (OrdersBean ordersBean : list) {
            ordersBean.setProductBean(productService.getProductById(ordersBean.getPid()));
        }
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/ordersManager.jsp").forward(request, response);
    }
}
