package cn.wycclub.web.controller;

import cn.wycclub.domain.*;
import cn.wycclub.factory.ServiceFactory;
import cn.wycclub.service.CollectionService;
import cn.wycclub.service.ProductService;
import cn.wycclub.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Service;
import java.io.IOException;
import java.util.List;
/**
 * 获取收藏分页
 * @author WuYuchen
 * @date 2017-11-16 22:42
 */

@WebServlet(name = "GetCollectionServlet",urlPatterns = {"/collection.do"})
public class GetCollectionServlet extends HttpServlet {
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
        User user = (User) session.getAttribute("user");
        CollectionService collectionService = ServiceFactory.getServiceFactory().getService(CollectionService.class);
        ProductService productService = ServiceFactory.getServiceFactory().getService(ProductService.class);
        QueryInfo queryInfo = WebUtils.requestToBean(request, QueryInfo.class);
        PageBean pageBean = collectionService.getCollectionByPage(queryInfo, user.getUid());
        List<CollectionBean> list = pageBean.getList();
        for (CollectionBean collectionBean : list) {
            ProductBean productBean = productService.getProductById(collectionBean.getPid());
            collectionBean.setProductBean(productBean);
        }
        user.setList(list);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/WEB-INF/jsp/collection.jsp").forward(request, response);
    }
}
