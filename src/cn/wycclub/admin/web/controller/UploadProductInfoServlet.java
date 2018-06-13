package cn.wycclub.admin.web.controller;

import cn.wycclub.admin.service.AdminService;
import cn.wycclub.admin.utils.AdminUtils;
import cn.wycclub.domain.ProductBean;
import cn.wycclub.factory.ServiceFactory;
import cn.wycclub.utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 增加商品的servlet
 * 实现图片上传功能
 * @author WuYuchen
 * @date 2017-11-22 23:48
 */

@WebServlet(name = "UploadProductInfoServlet" ,urlPatterns = {"/uploadProductInfo.admin"})
public class UploadProductInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || !AdminUtils.getAdminUsername().equals(session.getAttribute("admin"))) {
            request.setAttribute("message","抱歉,您没有登陆,请登录后再次尝试!");
            request.setAttribute("pagePath","admin.admin");
            request.getRequestDispatcher("/WEB-INF/jsp/admin/message.jsp").forward(request, response);
            return;
        }
        AdminService service = ServiceFactory.getServiceFactory().getService(AdminService.class);
        InputStream in = null;
        FileOutputStream out = null;
        Map<String,String> map = new LinkedHashMap<>();
        String fileName = "";
        try {
            //获取工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //获取解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //设置文件上传缓冲区大小
            factory.setSizeThreshold(1024*1024*5);
            //设置解析器所用码表
            upload.setHeaderEncoding("UTF-8");
            //设置上传支持的最大文件大小
            upload.setSizeMax(1024*1024*5);
            List<FileItem> fileItems = upload.parseRequest(request);
            //记录写入图片文件个数
            int count = 0;
            //记录写入商品信息个数
            int productInfoCount = 0;
            for (FileItem item : fileItems) {
                if (item.isFormField()) {
                    //表单普通项
                    String inputName = item.getFieldName();
                    String inputValue = item.getString("UTF-8");
                    map.put(inputName,inputValue);
                    productInfoCount ++;
                    if (productInfoCount == 4) {
                        ProductBean productBean = WebUtils.mapToBean(map, ProductBean.class);
                        //将商品信息插入数据库中,并且返回pid作为存放商品图片资源文件夹名称
                        fileName = service.addProduct(productBean) + "";
                    }
                } else {
                    //表单文件项
                    in = item.getInputStream();
                    //获取存放所有商品资源的文件夹绝对路径
                    String imagePath = this.getServletContext().getRealPath("/images/product");
                    //存放单独商品的文件夹路径,mian(主图)desc(商品详情)
                    String imageMainPath = imagePath + File.separator + fileName + File.separator + "main";
                    String imageDescPath = imagePath + File.separator + fileName + File.separator + "desc";
                    //创建新建商品对应的资源文件夹
                    File file = new File(imageMainPath);
                    if (!file.exists()) {
                        new File(imageMainPath).mkdirs();
                    }
                    file = new File(imageDescPath);
                    if (!file.exists()) {
                        new File(imageDescPath).mkdirs();
                    }
                    //开始写入操作
                    int len = 0;
                    byte buffer[] = new byte[1024];
                    if (count <= 3) {
                        out = new FileOutputStream(imageMainPath + File.separator + (count + 1) + ".jpg");
                    } else {
                        out = new FileOutputStream(imageDescPath + File.separator + "1.jpg");
                    }
                    while ((len = in.read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                    }
                    count ++;
                }
            }
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            request.setAttribute("message","文件大小超出5M!");
            request.getRequestDispatcher("/WEB-INF/jsp/admin/message.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            //上传成功后重定向到商品管理界面,并显示出新增商品
            response.sendRedirect(request.getContextPath() + "/productManager.admin");
        }
    }
}
