package cn.wycclub.web.controller;

import cn.wycclub.domain.FormBean;
import cn.wycclub.domain.User;
import cn.wycclub.exception.UserExistException;
import cn.wycclub.service.impl.BusinessUserServiceImpl;
import cn.wycclub.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 注册验证表单
 * @author WuYuchen
 * @date 2017-10-27 22:22
 */

@WebServlet(name = "RegisterServlet" , urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FormBean form = WebUtils.requestToBean(request, FormBean.class);
        //校验验证码
        String code = (String) request.getSession().getAttribute("code");
        code = code.toLowerCase();
        request.getSession().removeAttribute("code");
        String checkCode = request.getParameter("checkCode");
        checkCode = checkCode.toLowerCase();
        if (!code.equals(checkCode)) {
            request.getSession().setAttribute("form",form);
            request.setAttribute("checkCodeError","验证码错误!");
            request.getRequestDispatcher("/WEB-INF/jsp/registerMessage.jsp").forward(request, response);
            return;
        }
        //校验form提交的数据
        boolean flag = form.check();
        if (!flag) {
            request.setAttribute("formError",form.getError());
            request.getRequestDispatcher("/WEB-INF/jsp/registerMessage.jsp").forward(request,response);
            return;
        }
        //校验完毕将formbean复制到userbean中去
        User user = new User();
        WebUtils.copyToBean(form,user);
        //通过service将user存入数据库
        BusinessUserServiceImpl service = new BusinessUserServiceImpl();
        try {
            service.register(user);
            request.setAttribute("registerIsOK", "恭喜您注册成功!!,接下来将会跳转到登陆界面!");
            request.getRequestDispatcher("/WEB-INF/jsp/registerMessage.jsp").forward(request, response);
        } catch (UserExistException e) {
            request.setAttribute("message","用户已存在,请换一个用户名注册");
            request.getRequestDispatcher("/WEB-INF/jsp/registerMessage.jsp").forward(request,response);
        }
    }
}
