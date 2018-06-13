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
import java.util.Set;

/**
 * 商品搜索内容提交和查询
 * @author WuYuchen
 * @date 2017-11-29 14:59:24
 */
@WebServlet(name = "SearchProductServlet", urlPatterns = {"/SearchProduct.do"})
public class SearchProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String searchStr = request.getParameter("search");
        if (searchStr == null || "".equals(searchStr.trim())) {
            request.setAttribute("message","请勿搜索空字符!");
            request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
            return;
        }
        ProductService service = ServiceFactory.getServiceFactory().getService(ProductService.class);
        Set<ProductBean> set = service.searchProduct(searchStr);
        request.setAttribute("set",set);
        request.getRequestDispatcher("/WEB-INF/jsp/searchResult.jsp").forward(request, response);
    }
}
