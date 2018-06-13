package cn.wycclub.factory;

import cn.wycclub.exception.DaoException;

import java.util.Properties;

/**
 * 获取一个Dao层对象的工厂
 * 获取传进来的接口的字节码文件文件名
 * 通过文件名查找dao.properties中与之对应的接口实现类完整路径
 * 并且将相对应接口实现类进行初始化并且将对象返回给方法调用者
 * @author WuYuchen
 * @date 2017-10-26 20:46
 */

public class DaoFactory {
    private static Properties daoConfig = new Properties();
    private static DaoFactory instance = new DaoFactory();

    private DaoFactory() {
        try {
            daoConfig.load(DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties"));
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    /**
     * 获取dao工厂
     * */
    public static DaoFactory getDaoFactory() {
        return instance;
    }

    public <T>T getDao(Class<T> clazz) {
        String name = clazz.getSimpleName();
        String className =  daoConfig.getProperty(name);
        try {
            T dao = (T) Class.forName(className).newInstance();
            return dao;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
