package cn.wycclub.web.controller;

import cn.wycclub.domain.ProductBean;
import cn.wycclub.factory.ServiceFactory;
import cn.wycclub.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 显示主页
 * @author WuYuchen
 * @date 2017-11-03 11:19
 */

@WebServlet(name = "IndexServlet",urlPatterns = {"/index.do" , "/index"})
public class IndexServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService service = ServiceFactory.getServiceFactory().getService(ProductService.class);
        List<String> brandList = service.getBrand();
        request.getSession().setAttribute("brandList", brandList);
        List<ProductBean> radomProductListGroom = service.getProductByIndex(4);
        request.setAttribute("radomProductListGroom", radomProductListGroom);
        List<ProductBean> radomProductListLike = service.getProductByIndex(4);
        request.setAttribute("radomProductListLike", radomProductListLike);
        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);
    }
}
