package cn.wycclub.web.controller;

import cn.wycclub.dao.CollectionDao;
import cn.wycclub.domain.CollectionBean;
import cn.wycclub.domain.User;
import cn.wycclub.factory.ServiceFactory;
import cn.wycclub.service.CollectionService;
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
 * 添加收藏项
 * @author WuYuchen
 * @date 2017-11-15 14:17
 */

@WebServlet(name = "addCollectionServlet",urlPatterns = {"/addcollection.do"})
public class addCollectionServlet extends HttpServlet {
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
        CollectionService collectionService = ServiceFactory.getServiceFactory().getService(CollectionService.class);
        CollectionBean collectionBean = WebUtils.requestToBean(request, CollectionBean.class);
        User user = (User) session.getAttribute("user");
        collectionService.addCollection(collectionBean);
        List<CollectionBean> list = collectionService.getCollection(user.getUid());
        user.setList(list);
        String pid = request.getParameter("pid");
        response.sendRedirect(request.getContextPath() + "/product.do?pid=" + pid);
    }
}
