# JDBC

---

- 什么是JDBC
	- JDBC全称Java Data Connectivity(java数据库连接)，可以为多种数据库提供统一的访问，体现了Java“编译一次，到处运行"**精神!**
	
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