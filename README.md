# JDBC

---

- 什么是JDBC
	- JDBC全称Java Data Connectivity(java数据库连接)，可以为多种数据库提供统一的访问，体现了Java“编译一次，到处运行**"精神！"**
	
---

- JDBC编程步骤
	1. 加载驱动程序：Class.forName(driverClass)
	   加载Mysql驱动：Class.forName("com.mysql.jdbc.Driver")
	   加载Oracle驱动：Class.forName("oracle.jdbc.driver.OracleDriver")
	2. 获得数据库连接：DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/imooc/","username","password")
	3. 创建Statement对象：conn.createStatement();