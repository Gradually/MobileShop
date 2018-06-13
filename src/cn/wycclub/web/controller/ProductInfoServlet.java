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
 * 商品信息显示
 * @author WuYuchen
 * @date 2017-11-05 13:27
 */

@WebServlet(name = "ProductInfoServlet", urlPatterns = {"/product.do"})
public class ProductInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid;
        if (request.getParameter("pid") =="") {
            pid = (int) request.getAttribute("pid");
        } else {
            pid = Integer.parseInt(request.getParameter("pid"));
        }
        ProductService service = ServiceFactory.getServiceFactory().getService(ProductService.class);
        ProductBean productBean = service.getProductById(pid);
        request.setAttribute("productBean",productBean);
        List<ProductBean> radomProduct = service.getProductByIndex(3);
        request.setAttribute("radomProduct",radomProduct);
        List<ProductBean> newProduct = service.getProductByIndex(3);
        request.setAttribute("newProduct",newProduct);
        List<String> brandList = service.getBrand();
        request.setAttribute("brandList",brandList);
        request.getRequestDispatcher("/WEB-INF/jsp/product.jsp").forward(request,response);
    }
}
