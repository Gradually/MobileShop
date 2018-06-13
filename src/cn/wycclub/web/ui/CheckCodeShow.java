package cn.wycclub.web.ui;

import cn.wycclub.domain.CheckCode;
import cn.wycclub.utils.CheckCodeUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 显示验证码的图片,并且将验证码所代表的值放在session中带给浏览器
 * @author WuYuchen
 * @date 2017-10-27 13:41
 */

@WebServlet(name = "CheckCodeShow" ,urlPatterns = {"/checkcode"})
public class CheckCodeShow extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CheckCode checkCode = CheckCodeUtils.getCheckCode();
        String code = checkCode.getCode();
        request.getSession().setAttribute("code",code);
        BufferedImage image = checkCode.getImage();
        response.setContentType("image/jpeg");
        response.setHeader("Cache-Control","no-cache");
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
}
