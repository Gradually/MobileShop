package juint.test;

import cn.wycclub.dao.impl.ProductDaoJdbcImpl;
import cn.wycclub.domain.ProductBean;
import cn.wycclub.domain.ProductImageBean;
import cn.wycclub.domain.QueryResult;

import javax.management.Query;
import java.math.BigDecimal;
import java.util.List;

/**
 * 测试商品dao层
 *
 * @author WuYuchen
 * @date 2017-11-01 15:06
 */

public class ProductDaoTest {

    public static void main(String[] args) {
        ProductDaoJdbcImpl dao = new ProductDaoJdbcImpl();
        QueryResult queryResult = dao.pageQuery(0,5,"华为");
        int totalRecord = queryResult.getTotalRecord();
        List<ProductBean> list = queryResult.getList();
        for (ProductBean l : list) {
            System.out.println(l.getPid());
        }
    }

    public static void testAddProduct() {

    }

}
