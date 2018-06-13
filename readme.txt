1. 导入工具jar包
    //BeanUtils工具
    commons-beanutils-1.8.0.jar
    commons-logging.jar

    //文件上传工具
    commons-fileupload-1.2.1.jar
    commons-io-1.4.jar

    //自定义标签
    javax.servlet.jsp.jstl.jar
    jstl-impl-1.2.2.jar

    //mysql驱动
    mysql-connector-java-5.1.41-bin.jar

2. 创建包
    //管理员包
    cn.wycclub.admin
    //javabean包
    cn.wycclub.domain
    //自定义el函数包
    cn.wtcclub.el
    //数据库dao层接口
    cn.wycclub.dao
    //dao接口的实现类
    cn.wycclub.dao.impl
    //业务逻辑层service
    cn.wycclub.service
    //业务逻辑层service实现类
    cn.wycclub.service.impl
    //控制器
    cn.wycclub.web.controller
    //页面的显示
    cn.wycclub.web.ui
    //工具包
    cn.wycclub.utils
    //工厂类包
    cn.wycclub.factory
    //异常类包
    cn.wycclub.exception
    //功能测试包
    cn.wycclub.juint.test

3. 构建实例(bean)
    //购物车Bean
    CartBean
    //验证码
    CheckCode
    //收藏bean
    CollectionBean
    //注册表单bean
    FormBean
    //订单bean
    OrdersBean
    //商品Bean
    ProductBean
    //用户bean
    User

    //分页bean
        PageBean    -->服务器封装的分页数据bean
        QueryInfo   -->用户传过来的需要查看的分页信息
        QueryResult -->查数据库返回的分页数据

4.配置文件
    //数据库连接配置文件
    db.properties
        driver          --> 驱动类名
        url             --> 连接数据库url
        mysqlAccount    --> 数据库用户名
        mysqlPassword   --> 数据库密码

    //管理员用户配置文件
    admin.properties
        username        -->管理员用户名
        password        -->管理员密码

    //dao层接口和实现类名配置文件（由Factory读取并实例化接口相对应实现类的对象）
    dao.properties&service.properties
        key             --> 接口类名
        value           --> 接口对应实现类名称

5. 创建数据库及表

    //创建数据库
    create database mobileshop;
    use mobileshop;

    用户信息表(uid,用户名,密码,邮箱,电话,地址,余额)
    create table user_info(
    uid int primary key auto_increment,
    username varchar(40) unique not null,
    password varchar(40) not null,
    email varchar(40) not null,
    tel varchar(20),
    address varchar(100),
    money decimal(10,2) default 100000,
    state int not null default 0,
    gmt_create datetime not null,
    gmt_modified timestamp not null
    );


    商品信息表(pid,商品名称,商品价钱,商品种类,商品介绍,库存)
    create table product_info(
    pid int primary key auto_increment,
    title varchar(100) not null,
    price decimal(10,3),
    stock int default 0,
    brand varchar(40) not null,
    gmt_create datetime not null,
    gmt_modified timestamp not null,
    constraint product_type_id_FK foreign key(tid) references product_type(tid),
    constraint product_brand_id_FK foreign key(bid) references product_brand(bid)
    )

    购物车信息表
    create table product_cart(
    cid int primary key auto_increment,
    uid int not null,
    pid int not null,
    quantity int not null,
    payable decimal(10,3) not null,
    gmt_create datetime not null,
    gmt_modified timestamp not null,
    constraint product_type_id_FK foreign key(uid) references user_info(uid),
    constraint product_brand_id_FK foreign key(pid) references product_info(pid)
    )

    订单信息表(oid,实付款,商品数量,商品id,用户id,状态[1.待收货 2.待评价 3.已评价])
    create table product_orders(
    oid int primary key auto_increment,
    payment decimal(10,3) not null,
    quantity int not null,
    pid int not null,
    uid int not null,
    state int not null default 0,
    gmt_create datetime not null,
    gmt_modified timestamp not null,
    constraint orders_user_id_FK foreign key(uid) references user_info(uid),
    constraint orders_product_id_FK foreign key(pid) references product_info(pid)
    )

    商品收藏表(收藏ID,商品ID,用户ID)
    create table user_collection(
        cid int primary key auto_increment,
        pid int not null,
        uid int not null,
        gmt_create datetime not null,
        gmt_modified timestamp not null,
        constraint collection_user_id_FK foreign key(uid) references user_info(uid),
        constraint collection_product_id_FK foreign key(pid) references product_info(pid)
    )

    访问量记录表
    create table user_visits(
         vid int primary key auto_increment,
         count int not null default 0,
         gmt_create datetime not null,
         gmt_modified timestamp not null
    )

    触发器:
    用户付款后触发商品库存修改
    delimiter $$
    create trigger stock_update after delete
    on product_cart for each row
    begin
        update product_info set stock = stock - old.quantity where pid=old.pid;
    end
    $$
    delimiter;


