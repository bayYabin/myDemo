##JDK安装

 - rpm -ivh jdk-13.interim.update.patch_linux-x64_bin.rpm

*Xshell 6*

1. 上传文件 `rz`
2. 下载文件 `sz filepath.ext<br>//文件会默认下载到系统的Downloads目录`

##添加服务自动启动

1. iptables服务自动启动
	- chkconfig --add iptables ??

   - chkconfig iptables on/off  ??


##文件编辑

- 末行模式下：q! 【强制退出不保存】 q【退出不保存】 wq【退出并保存后面也可以加个！】 
- 让/etc/profile文件修改后立即生效 ,可以使用如下命令: # source /etc/profile

##Maven配置
- ### 环境变量
	- export MAVEN_HOME=/usr/local/service/maven/apache-maven-3.6.2
	- export PATH=$PATH:$MAVEN_HOME/bin

- ###普通Java的项目
   - 启动命令:`java -cp maven-1.0-SNAPSHOT.jar com.google.Main >temp.log`
   - 本地项目位置:`D:\myTest\daily\byMonth\09\maven\google`
- ###搭建父子工程
	- ####参考
		-  参考01:<https://www.jianshu.com/p/7729bef0fbcf>
		-  参考02:<https://blog.csdn.net/nvisalsd/article/details/80803277>
    - ####试验01-父子项目
	 	- 文件夹目录 `D:\myTest\ideas\maven\parent\001`
		 - parent `D:\myTest\ideas\maven\parent\001\parent`
		 - childOne `D:\myTest\ideas\maven\parent\001\parent\childThree`
		 - childTwo `D:\myTest\ideas\maven\parent\001\parent\childTwo`
		 - common `D:\myTest\ideas\maven\parent\001\common`


- ###父项目和子项目的目录结构<br>![image][001]

- ###common项目结构<br>![image][002]

- ### 父项目pom.xml

		<?xml version="1.0" encoding="UTF-8"?>
		<project xmlns="http://maven.apache.org/POM/4.0.0"
		         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
		    <modelVersion>4.0.0</modelVersion>
		
		    <parent>
		        <groupId>org.springframework.boot</groupId>
		        <artifactId>spring-boot-starter-parent</artifactId>
		        <version>2.1.4.RELEASE</version>
		        <relativePath/> <!-- lookup parent from repository -->
		    </parent>
		
		    <groupId>com.robin</groupId>
		    <artifactId>parent</artifactId>
		    <version>1.0-SNAPSHOT</version>
		
		    <packaging>pom</packaging>
		    <name>这是一个父项目</name>
		    <description>所有子项目的父项目</description>
		    <properties>
		        <java.version>1.8</java.version>
		        <spring-cloud.version>Greenwich.SR1</spring-cloud.version>
		        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		    </properties>
		
		    <dependencyManagement>
		        <!--此处导的包其子项目均可以使用-->
		        <dependencies>
		            <dependency>
		                <groupId>com.robin</groupId>
		                <artifactId>common</artifactId>
		                <version>1.0-SNAPSHOT</version>
		            </dependency>
		        </dependencies>
		    </dependencyManagement>
		    <!-- 依赖的架包 -->
		    <dependencies>
		        <!--父项目自己用??-->
		        <!--<dependency>-->
		            <!--<groupId>com.robin</groupId>-->
		            <!--<artifactId>common</artifactId>-->
		            <!--<version>1.0-SNAPSHOT</version>-->
		        <!--</dependency>-->
		    </dependencies>
		    <!-- 子模块 -->
		    <modules>
		        <module>childThree</module>
		        <module>childTwo</module>
		        <module>childFour</module>
		    </modules>
		</project>


- ###子项目之一pom.xml

		<?xml version="1.0" encoding="UTF-8"?>
		<project xmlns="http://maven.apache.org/POM/4.0.0"
		         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
		    <modelVersion>4.0.0</modelVersion>
		    <parent>
		        <artifactId>parent</artifactId>
		        <groupId>com.robin</groupId>
		        <version>1.0-SNAPSHOT</version>
		    </parent>
		    <artifactId>childThree</artifactId>
		    <name>项目三</name>
		    <description>这是-项目三</description>
		</project>
- ###common的pom.xml


		<?xml version="1.0" encoding="UTF-8"?>
		<project xmlns="http://maven.apache.org/POM/4.0.0"
		         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
		    <modelVersion>4.0.0</modelVersion>
		
		    <groupId>com.robin</groupId>
		    <artifactId>common</artifactId>
		    <version>1.0-SNAPSHOT</version>
		</project>




##MySQL连接数据库
- ### MySQL8.0
	- 本地安装文件位置:`resources\file\mysql80-community-release-el7-3.noarch.rpm`
	- 步骤
		- sudo yum  mysql80-community-release-el7-3.noarch
		- **安装** 
			- sudo yum localinstall  mysql80-community-release-el7-3.noarch.rpm
		- **检测** 
			- yum repolist enabled | grep "mysql.*-community.*"
		- **安装数据库服务器** 
			- sudo yum install mysql-community-server -y
		- **启动MySQL**
			- sudo service mysqld start
			- Starting mysqld:[ OK ]
		- **查看服务器状态**
			- sudo service mysqld status
			- mysqld (pid 3066) is running.

		- **查看初始密码**
			- sudo grep 'temporary password' /var/log/mysqld.log
			- root@localhost: #C*>BqtGs9r5
		- **登录设置新密码**
			- mysql -uroot -p
			- ALTER USER 'root'@'localhost' IDENTIFIED BY 'a0@4gs4dg4H7thhjh!';
			- a0@4gs4dg4H7thhjh!

		- **8.0之前的数据库**
			- 第一步：root用户登录；mysql>mysql -u root -p rootpassword;

			- 第二步：赋予权限；mysql>
			    -  GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'a0@4gs4dg4H7thhjh!' WITH GRANT OPTION				
				- GRANT ALL PRIVILEGES ON *.* TO 'root'@'192.168.64.1' IDENTIFIED BY 'a0@4gs4dg4H7thhjh!' WITH GRANT OPTION				
				- GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'mypassword' WITH GRANT OPTION;			
			- 第三步：mysql>FLUSH   PRIVILEGES;
		- **8.0的数据库**
			- create user 'root'@'%' identified by 'a0@4gs4dg4H7thhjh!';			
			- grant all privileges on *.* to 'root'@'%' with grant option; 						
			- FLUSH   PRIVILEGES;			
		    - ALTER USER 'root'@'%' IDENTIFIED BY 'a0@4gs4dg4H7thhjh!' PASSWORD EXPIRE NEVER;   #修改加密规则 		
		    - ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'a0@4gs4dg4H7thhjh!';   #更新一下用户的密码 			 
			- FLUSH   PRIVILEGES;
- **baomidou**[<https://mp.baomidou.com/>]<br>
![image][003]
	- 本地文件位置`D:\myTest\daily\byMonth\09\myBatisPlus\officialDemos`

- ###Springboot-MyBatis
	- ####001
		- 时间:2019/10/28 19:08
		- 文件夹位置:
		- 参考地址:
			- [<http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/>]
			- [<https://github.com/mybatis/spring-boot-starter>]
			- [<https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start>]
		 
##dubbo
- ###dubbo服务连接
	- todo
- ###实例代码
	- 本地文件位置:`D:\myTest\daily\byMonth\08\spring\dubbo\mrbird\003`
- ###参考地址：
	- 001:<https://blog.csdn.net/sinat_30276961/article/details/83589748>
	- 002:<https://www.cnblogs.com/zjfjava/p/9696086.html#top>
	- 003:<https://www.cnblogs.com/zjfjava/p/9697275.html>
	- 004:<https://www.cnblogs.com/mingxiaoyue/p/9194431.html>
	- 005:<https://blog.csdn.net/zab635590867/article/details/83591448>
- ###依赖信息:		     


			dubbo的基本配置??
			<!-- dubbo -->
			<dependency>
			    <groupId>com.alibaba.boot</groupId>
			    <artifactId>dubbo-spring-boot-starter</artifactId>
			    <version>0.2.0</version>
			</dependency>
			
			<!-- zookeeper -->
			<dependency>
			    <groupId>org.apache.zookeeper</groupId>
			    <artifactId>zookeeper</artifactId>
			    <version>3.4.8</version>
			</dependency>
			<dependency>
			    <groupId>com.101tec</groupId>
			    <artifactId>zkclient</artifactId>
			    <version>0.10</version>
			</dependency>
- ###其他dubbo练习项目
	- 001
		- 时间:2019/10/28 19:08
		- 文件夹位置:
			- `D:\myTest\daily\byMonth\08\spring\dubbo\mrbird\004\dubboProject\parent`
			- `D:\myTest\daily\byMonth\08\spring\dubbo\mrbird\004\dubboProject\parent\service_one`
			- `D:\myTest\daily\byMonth\08\spring\dubbo\mrbird\004\common`
		- 参考地址:
			- [<http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/>]
			- [<http://dubbo.apache.org/en-us/docs/user/quick-start.html>]
			- [<https://github.com/apache/dubbo>]
			- [<https://github.com/apache/dubbo-spring-boot-project>]
	- 002

##Redis连接
- 缓存中间件连接

##RabbitMQ
- 消息中间件连接

##数据库主从(读写)分离
- 主从分离

##Node(npm)和React安装
- 安装前端环境和React小项目
- React
	- 本地项目位置:`D:\myTest\daily\byMonth\08\react\001`

- 其他React练习项目
	- 001
		- 时间:2019/10/28 19:08
		- 文件夹位置:
		- 参考地址:
			- [<https://reactjs.org/docs/getting-started.html#versioned-documentation>]
			- [<https://reactjs.org/docs/create-a-new-react-app.html>]
 

##Jenkins部署
- 项目自动部署
##Spring项目
- 本地文件位置`D:\myTest\daily\byMonth\08\spring`

##Java
- ###时间转换
	- **select FROM_UNIXTIME(1000/1000);**
	- **select UNIX\_TIMESTAMP('1970\-01\-01 20:00:00')\*1000;**

---
[001]:.\resources\image\001.png 'image 001'
[002]:.\resources\image\002.png 'image 002'
[003]:.\resources\image\003.png 'image 003'