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
    - JDBC调用无参数的存储过程
    - JDBC调用含输入参数的存储过程
    - JDBC调用含输出参数的存储过程
    - JDBC调用含输入、输出参数的存储过程

---

- JDBC的事务管理

---

- 数据库连接池
    - dbcp
    - c3p0
    
---

- JDBC的替代产品（发展）
    - hibernate
    - mybatis 
    
---

- 总结