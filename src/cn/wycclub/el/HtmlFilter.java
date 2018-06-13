package cn.wycclub.el;

import cn.wycclub.domain.CollectionBean;
import cn.wycclub.domain.PageBean;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * 自定义el函数
 *
 * @author WuYuchen
 * @date 2017-11-14 11:03
 */

public class HtmlFilter {

    /**
     * 由于BigDecimal小数点后有三位,这个方法将小数点后三位小数转成两位小数
     * */
    public static String priceTwoDecimal(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            throw new RuntimeException("价钱为空!");
        }
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(bigDecimal.doubleValue());
    }


    /**
     * 判断商品是否收藏
     * */
    public static boolean CollectionExist(List<CollectionBean> list,int pid) {
        if (list == null || "".equals(list)) {
            return false;
        } else {
            for (CollectionBean collectionBean : list) {
                if (collectionBean.getPid() == pid) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 检测当前总数据量是否大于页显示数据量,大于则返回true,反之
     * */
    public static boolean checkRow(PageBean pageBean) {
        if (pageBean.getTotalRecord() > pageBean.getPageSize()) {
            return true;
        }
        return false;
    }
}
