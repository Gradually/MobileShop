package cn.wycclub.web.controller;

import cn.wycclub.domain.PageBean;
import cn.wycclub.domain.ProductBean;
import cn.wycclub.domain.QueryInfo;
import cn.wycclub.factory.ServiceFactory;
import cn.wycclub.service.ProductService;
import cn.wycclub.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 获取商品分页并显示商品详情页
 * @author WuYuchen
 * @date 2017-11-02 21:19
 */

@WebServlet(name = "CategoryServlet",urlPatterns = {"/category.do"})
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProductService service = ServiceFactory.getServiceFactory().getService(ProductService.class);
            //将用户请求封装到QueryInfo对象中去
            QueryInfo queryInfo = WebUtils.requestToBean(request, QueryInfo.class);
            PageBean pageBean = service.getProductByPage(queryInfo);
            String brand = request.getParameter("brand");
            request.setAttribute("brand",brand);
            request.setAttribute("pageBean", pageBean);
            request.getRequestDispatcher("/WEB-INF/jsp/category.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message","服务器出现了一个问题,正在返回主页");
            request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request,response);
        }
    }
}
