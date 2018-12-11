# JDBC

---

- 什么是JDBC
	- JDBC全称Java DataBase Connectivity(java数据库连接)，可以为多种数据库提供统一的访问，体现了Java“编译一次，到处运行"**精神!**
	
---

- JDBC编程步骤
	1. 加载驱动程序：Class.forName(driverClass)
	   加载Mysql驱动：Class.forName("com.mysql.jdbc.Driver")->8.0.13("com.mysql.cj.jdbc.Driver")
	   加载Oracle驱动：Class.forName("oracle.jdbc.driver.OracleDriver")
	2. 获得数据库连接：DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/imooc(数据库名)/","username","password")
	3. 创建Statement对象：conn.createStatement();
	
---

- 样设
    - 采用MVC三层架构
        1. View（视图层）：对数据的一个展示
        2. Control（控制）：数据流通过程
        3. Model（模型层）：数据库映射，数据库映射抽象方法
        - DB（数据库）
        
---

- 视图层
    - 程序启动后，一直保持在运行状态
    - 循环接受控制台的输入参数
    - 调用Action（控制层）响应，并将返回结果展示在控制台
    - 直到输入特定的输入标记（如EXIT）后，程序退出
- 问题
    1. 循环接收参数
    2. 某个功能的保持
    
---

- 总结
    - JDBC是连接数据库的桥梁
    - 由Java语言编写的类和接口
    - 可以为多种数据库提供统一的接口
    - MVC三层架构
    
- JDBC各种连接方式
    - JDBC+ODBC桥的方式
        - 特点：需要数据库的ODBC驱动，仅适用于微软的系统
    - JDBC+厂商API的形式
        - 特点：厂商API一般使用C编写
    - JDBC+厂商Database Connection（Server+DataBase的形式）
        - 特点：在Java与DATABASE之间架起了一台专门用数据库连接的服务器（一般由数据库厂商提供）
    - JDBC+DATABASE的连接方式
        - 特点：这使得Application与数据库分开，开发者只需关心内部逻辑的实现而不需注重数据库连接的具体实现
        
- JDBC常用的API及**存储过程**的调用
    - 简单来说，存储过程就是为了以后的使用而保存的一条或多条MySQL语句的集合
        1. 通过把处理封装在容易使用的单元中，简化复杂的操作
        2. 由于步要求反复建立一系列处理步骤，保证了数据的完整性
        3. 简化对变动的管理，如果表明、列名或业务逻辑有变化只需要更改存储过程的带代码
        4. 提高性能
    - JDBC调用无参数的存储过程
    - JDBC调用含输入参数的存储过程
    - JDBC调用含输出参数的存储过程
    - JDBC调用含输入、输出参数的存储过程

---

- JDBC的事务管理
    - 事务：事务是作为**单个逻辑工作单元**执行的一系列操作，这些操作作为一个整体一起提交给系统，要么都执行、要么都不执行。
    - 特点
        1. 原子性（Atomicity）：事务是一个完整的操作
        2. 一致性（Consistency）：当事务完成时，数据必须处于一致状态
        3. 隔离性（Isolation）：对数据进行修改的所有并发事务是彼此隔离的
        4. 永久性（Durability）：事务完成后，它对数据库的修改被永久保持
     - JDBC对事务的管理
        1. 我们通过**提交commit** 或是 **rollback**来管理事务
        2. 事务默认是自动提交的
        3. 可以通过调用setAutoCommit(false)来禁止自动提交

---

- 数据库连接池
    1. 背景
        - 数据库连接是一种重要的资源
        - 获取连接->使用->关闭连接，频繁的连接数据库会增加数据库的压力
        - 解决以上问题出现了连接池技术
    2. 常用的开源的数据库连接池
        - dbcp
            1. Spring组织推荐使用
            2. 强制关闭连接或者数据库重启后，无法自动连接
            3. 没有自动的去回收空闲连接的功能
            4. DBCP有着比C3P0更高的效率，可能出现丢失连接
            5. DBCP提供最大连接数
            6. DBCP并没有相应的功能
        - c3p0
            1. Hibernate组织推荐使用
            2. 强制关闭连接或者数据库重启后，可以自动连接
            3. 自动回收空闲连接的功能
            4. C3P0稳定性较高
            5. C3P0提供最大空闲时间
            6. C3P0可以控制数据源内加载的PreparedStatements数量，并且可以设置帮助线程的数量来提升操作的速度
    
---

- JDBC的替代产品（发展）
    1. Commons-dbutils
        - Apache组织提供的一个开源JDBC工具类库，对传统操作数据库的类进行二次封装，可以把结果集转化为List
        - 特点
            1. 杜绝资源泄露，修正JDBC代码并不困难，但是着通常导致连接泄露并且难以跟踪到
            2. 大段的持久化数据到数据库代码彻底精简，剩下的代码清晰地表达了编码的意图
            3. 不需要手工从ResultSet里Set值到JavaBean中，每一行数据都将会以一个Bean实例的形式出现
        - 核心接口
            1. DbUtils：提供如关闭连接、装载JDBC驱动程序等常规工作的工具类
            2. QueryRunner：该类简化了SQL查询，它常常与ResultSetHandler组合在一起使用
            3. ResultHandler：执行处理一个java.sql.ResultSet，将数据转变并处理为任何一种形式，这样有益于其应用而且使用起来更容易
    2. hibernate
        - 一种Java语言下的对象关系映射解决方案，它是一种自由、开源的软件
        - 优点
            1. 轻量级的ORM框架
            2. 对JDBC进行了很好的封装，使用ORM做了映射，那么就可以通过面向对象的方式很容易的操纵数据库了
            3. 它提供了缓存机制，可以提高效率
        - 缺点
            1. 如果对大量的数据进行频繁的操作，性能效率比较低，不如直接使用JDBC
        - 核心接口
            1. Session接口：负责执行被持久化对象的CRUD操作
            2. SessionFactory接口：负责初始化Hibernate，它充当数据存储源的代理，并负责创建Session对象
            3. Configuration接口：负责配置并启动Hibernate，创建SessionFactory对象
            4. Transaction接口：负责事务相关的操作，可选
            5. Query和Criteria接口：负责执行各种数据库查询    
    3. mybatis 
        - Mybatis是支持普通SQL查询，存储过程和高级映射的优秀持久层框架
        - 特点
            1. 易于上手和掌握
            2. sql卸载xml里，便于同一管理和优化
            3. 解除sql与程序的耦合度
            4. 提供映射标签，支持对象与数据库的orm字段关系映射
            5. 提供对象关系映射标签，支持对象关系组建维护
            6. 提供xml标签，支持编写动态sql
    
---

- 总结