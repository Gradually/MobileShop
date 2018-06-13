package cn.wycclub.web.controller;

import cn.wycclub.domain.CollectionBean;
import cn.wycclub.domain.User;
import cn.wycclub.factory.ServiceFactory;
import cn.wycclub.service.CollectionService;

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
 * 删除收藏项
 * @author WuYuchen
 * @date 2017-11-16 22:46
 */

@WebServlet(name = "RemoveCollectionServlet",urlPatterns = {"/removeCollection.do"})
public class RemoveCollectionServlet extends HttpServlet {
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
        int cid = Integer.parseInt(request.getParameter("cid"));
        CollectionService collectionService = ServiceFactory.getServiceFactory().getService(CollectionService.class);
        collectionService.removeCollection(cid);
        User user = (User) session.getAttribute("user");
        List<CollectionBean> list = user.getList();
        int index = 0;
        for (CollectionBean collectionBean : list) {
            if (collectionBean.getCid() == cid) {
                break;
            }
            index ++;
        }
        list.remove(index);
        response.sendRedirect(request.getContextPath() + "/collection.do?uid=" + user.getUid());
    }
}
