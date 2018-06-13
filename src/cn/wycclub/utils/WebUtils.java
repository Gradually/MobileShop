package cn.wycclub.utils;

import cn.wycclub.domain.ProductBean;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Web层工具类
 *
 * @author WuYuchen
 * @date 2017-10-27 21:27
 */
public class WebUtils {
    /**
     * 将request中的数据复制到javabean中储存
     * */
    public static <T> T requestToBean(HttpServletRequest request, Class<T> beanClass) {
        try {
            //获取request中的内容转化成map
            Map map = request.getParameterMap();
            //将传进来的bean实例化
            T bean = beanClass.newInstance();
            BeanUtils.populate(bean, map);
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将map中的数据复制到javabean中储存
     * */
    public static <T> T mapToBean(Map map, Class<T> beanClass) {
        try {
            T bean = beanClass.newInstance();
            BeanUtils.populate(bean, map);
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyToBean(Object src, Object dest) {
        final BigDecimal BIGDECIMAL_ZERO = new BigDecimal("0");
        BigDecimalConverter bd = new BigDecimalConverter(BIGDECIMAL_ZERO);
        ConvertUtils.register(bd, java.math.BigDecimal.class);
        try {
            BeanUtils.copyProperties(dest,src);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void getImageBean(HttpServletRequest request, List<ProductBean> list) {
        for (ProductBean productBean : list) {
            productBean.getImageBean().setPath(request.getServletContext().getRealPath("/"));
        }
    }

}
