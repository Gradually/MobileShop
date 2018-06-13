package cn.wycclub.factory;

import cn.wycclub.exception.ServiceException;

import java.util.Properties;

/**
 * Service工厂
 * 获取传进来的接口的字节码文件文件名
 * 通过文件名查找service.properties中与之对应的接口实现类完整路径
 * 并且将相对应接口实现类进行初始化并且将对象返回给方法调用者
 * @author WuYuchen
 * @date 2017-10-27 16:52
 */

public class ServiceFactory {
    private static Properties serviceConfig = new Properties();
    private static ServiceFactory instance = new ServiceFactory();

    private ServiceFactory() {
        try {
            serviceConfig.load(ServiceFactory.class.getClassLoader().getResourceAsStream("service.properties"));
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    /**
     * 获取service工厂
     */
    public static ServiceFactory getServiceFactory() {
        return instance;
    }

    /**
     * 获取service实例
     */
    public <T> T getService(Class<T> clazz) {
        String name = clazz.getSimpleName();
        String className = serviceConfig.getProperty(name);
        try {
            T service = (T) Class.forName(className).newInstance();
            return service;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

}
