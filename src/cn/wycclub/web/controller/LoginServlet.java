package cn.wycclub.web.controller;

import cn.wycclub.domain.CollectionBean;
import cn.wycclub.domain.User;
import cn.wycclub.exception.UsernameOrPasswordErrorException;
import cn.wycclub.factory.ServiceFactory;
import cn.wycclub.service.CollectionService;
import cn.wycclub.service.UserService;
import cn.wycclub.service.impl.BusinessUserServiceImpl;
import cn.wycclub.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * 验证登陆表单
 * @author WuYuchen
 * @date 2017-10-29 11:18
 */

@WebServlet(name = "LoginServlet",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService service = ServiceFactory.getServiceFactory().getService(UserService.class);
        CollectionService collectionService = ServiceFactory.getServiceFactory().getService(CollectionService.class);
        try {
            User user = service.login(username,password);
            if (user.getState() == 1) {
                request.setAttribute("message","您当前用户由于违反本网页条规已被封禁,请自行联系网站管理员获取解禁方式!");
                request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
                return;
            }
            //验证正确之后,跳转到主页,并保存登陆印记
            List<CollectionBean> list = collectionService.getCollection(user.getUid());
            user.setList(list);
            request.getSession().setAttribute("user",user);
            request.setAttribute("isOK","登陆成功!3s后跳转到主页");
            request.getRequestDispatcher("/WEB-INF/jsp/loginMessage.jsp").forward(request,response);
        } catch (UsernameOrPasswordErrorException e) {
            request.setAttribute("message","用户名或密码不存在!!");
            request.getRequestDispatcher("/WEB-INF/jsp/loginMessage.jsp").forward(request,response);
        }
    }
}
