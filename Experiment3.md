# Experiment 3 — MyBatis

Experiment 3——mybatis
## 一、Experimental object
（1）Learn the basic of mybatis;
（2）Master the use of mybatis in project practice.
## 二、Experimental content
### 2.1 Introduction of Mybatis
At present, the projects are separated from the front end and the back end. The browser sends requests to the back end through the page, and the back-end Controller processes the requests through the Service layer after receiving them, and calls the dao (mapper) layer to interact with the database and return data to the Service layer and Controller layer. The completed request data is encapsulated in json format and returned to the front end for rendering into the front end page.
In later experiments, we'll touch on SSM (spring, spring MVC, and mybatis) frameworks, springboot frameworks, front-end pages, and their relationships. Because these contents are very rich, we can only cover part of the content in the class, if you are interested, you can use your spare time to study systematically.
In this experiment, we will learn about the mybatis framework.
Mybatis
Mybatis helps programmers access data to a database.Traditional jdbc operation, there are a lot of repetitive code blocks. Such as: encapsulation when data is taken out, database connection establishment, and so on... The framework can reduce repetitive code and improve development efficiency.
(1)MyBatis is a Java-based persistence layer ORM(Object-Relational Mapping) framework, which provides persistence layer frameworks including SQL Maps and Data Access Objects (DAO). Eliminates almost all JDBC code and manual parameter setting and result set retrieval.
(2)MyBatis uses simple XML or annotations for configuration and raw mapping to map interfaces and java POJOs to records in a database.
This is mybatis official documentation you can refer to learn: https://mybatis.org/mybatis-3/index.html
### 2.2 Configure and use mybatis
Create a new maven project
Import the MyBatis related jar package in pom.xml
Write the Mybatis core configuration file, create the mybatis-config.xml file under resources, and configure your own database address, name, password, and mysql driver：
Create a package with the same name in the main java folder and in the resources folder：
In the main.java of the package you just created, create a student class with the same properties as in the table.Write the following code：
Create StudentsMapper interface in the same folder.Write the following code:
Create StudentsMapper.xml in the package created under resources.SQL statement, modified as required, formatted as in this example.
Add SQL mapping in the mybatis-config.xml file：
Create a test case in the test.java folder and run it：
Result：
## 三、Experimental task
1. Based on the above information, you can select a table in the scoremanagement database for add, delete, modify and query operations. Give the source code and run results.
2. Query all the attributes of the student table (including major, date of birth and credits).Give the source code and run results.
3. (Optional) Use MyBatis dynamic SQL to implement a multi-condition query for the student table (support fuzzy search by name, filtering by major, credit range query and pagination). Give the source code and run results.
Note: Please complete the experiment according to the experiment documentation, and put your code and the screenshot of the query results in the corresponding location. Complete the lab document in class and rename it with your student number and name and email it to your monitor after class.The deadline for submitting the lab report is before next class.

---

## Extracted Code / Text From Images

### Image 1 (image1.png)
```
service

|

Front-end page Back-end server
```

### Image 2 (image10.png)
```
Project v ~* StudentsMapperxml </> Mybatis-configxml

<?xml version="1.0" encodin;
<!DOCTYPE configuration

Y DQ mybatis D:\DataBaseExperiment\experiment3\mybatis

> D idea PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
Y Dsre “https: //mybatis org/dtd/mybatis-3-config.dtd">
Y Dain kconfiguration>
<environments default="development">
Cr i default="devell a
ee) <environment id="development">
vy Bcomaiansen <transactionManager type="JDBC"/>
\ B) Mapper oo SEBS BYTE Bimy sq AREER SE —->

<dataSource type="POOLED">

‘S StudentsMapper

<property name="driver" value="com.mysql.cj.jdbc.Driver"/>

Y Bpojo <property rl" value="jdbc:mysql: //localhost :3306/scoremanagement"/>
© Students <property sername" value="root"/>
Otenss <property name="password" value="1234"/>
</dataSource>
» (Sess </environment>
¥ (© comaiansen.Mapper </environments>

REBS sql

> StudentsMapper.xml —_————~
</> Mybatis-config.xml

<mapper resource
Y Dest () grees
v Diava 22 </configuration>

‘om. giansen.Mapper/StudentsMapper.xm1"]>
```

### Image 3 (image11.png)
```
Vee eR

> import ...
v Bpojo
© students D public class test ff
> public static void main(String[] args) throws IOException {
© Teachers String resource = "Mybatis-config.xml";
v QBresources InputStream inputStream = Resources.getResourceAsStream(resource) ;
\ Di comaiansen.Mapper SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream) ;
39 StudentsMapperaml SqlSession sqlSession = sqlSessionFactory.openSession();
StudentsMapper students = sqlSession.getMapper(StudentsMapper.class) ;
</> Mybatis-config.xml List<Students> selectall = students.selectall();
v Dtest for(Students student : selectall){
Y java System. out.print1n(student) ;
Gres ,
> D target @;
Q itignore 2 L

M pomxmi
```

### Image 4 (image12.png)
```
D:\JAVA\IJRE22\bin\java.exe
Students{sid = 1, sname = zhangsan}

javaagent :D:\Program Files\JetBrains\I

Students{sid = 2, sname = lisi}
Students{sid = 3, sname = wangwu}
Students{sid = 4, sname = zhaolei}
Students{sid = 5, sname = qianxi}
Students{sid = 6, sname = sunwu}

Process finished with exit code @
```

### Image 5 (image2.png)
```
1. What is MyBatis?

MyBatis

MyBatis is a persistence framework that simplifies JDBC and helps developers access data in the database efficiently.

+ MyBatis is a Java-based persistence
framework (ORM).

+ Itel

result set ret

+ Ituses XML or Annotations to map

inates almost all JDBC code,
‘manual parameter setting and
al

MyBatis

interfaces and Java POJOs to

database records.

Tras

Traditional JDBC

x
x
x
x
x

ional JDBC vs MyBatis

Alot of ropetitve code
Manual connection management
Marval parameter setting
Manual resuit set processing
Low development efficiency

MyBatis

‘Simple and coon
‘Aomatc connection management
‘Automatic parameter sting
‘Automatic result mapping

vs 2

High development efficiency

Core Components

SqlSession
Mapper

MappedStatement

Executor

The main interface to interact withthe database. Represents a session
Interface for writing SQL MyBatis implements it automaticaly
Contains SQL, input parameters, output resus and mapping informat
Executes SOL and returns costs

Creates SqlSession. Usually created once during application startup.

2. How It Works

(emybatis-config.xmi)

C2)

</>

sal Simple Flexible SQL
and easy to use (Write the SQL
sour

Application
(ava Code) SalSession |
‘| Ee MappedStatement
(Factory) (SQL Mapper) Database)
Create Sqisession Execute SQL and Contains SQL Execute SQL in
to execute SQL map results. and mapping database and
commands. information. return results
4. Basic Usage Steps
1. Add Dependency 2. Configure 3. Write Mapper 4. Use in Code
_ — —
oO” & </>
‘Add MyBatis Configure database Write SQL and Got SqlSession andl
dependency comnesion rn mappings execute SQL through
(pom.xml) Pipa atte, (XML or Annotations) Mapper interface

% o

Stable and
reliable

Better performance
(with caching)

Highly extensible
(Plugins, etc.)
```

### Image 6 (image3.png)
```
£2) New Project

lq @

| Empty Project

Location: E:\Program\JetBrains\project oO
Project will be c ed in: E:\Program\JetBrains\project\mybatis
| 1M Maven Archetype J Create Git repository
Jakarta EE
4 Language: Java Kotlin Groovy JavaScript ar

& Spring Initializr
CB JavaFX Build system: IntelliJ Maven | Gradle
| &) Quarkus

JL Micronaut dpe 01.8 Or

© Ktor

OpenJDK version 1.8.0_38 v

@ Add sample code

Kotlin Multiplatform
B B @ Generate code with onboarding tips

® Compose for Desktop

HTML > Advanced Settings
& React

ex Express

| ‘A Angular CLI
<@ IDE Plugin

_ &% Android

V Vuejs

WY Vite

? Cancel
```

### Image 7 (image4.png)
```
M pomxml (mybatis)

1.0" encoding="UTF-8"?>]

http: //maven.apache.org/POM/4.0.0"

rttp: //wuw.w3.org/2001/XMLSchema- instance"

rttp: //maven.apache.org/POM/4.@.@ http: //maven.apache.org/xsd/maven-4.0.0.xsd">

1 <?xml _version=

xsi: schemaLocation:
<modelVersion>4.@.@</modelVersion>

7 <groupId>org. example</groupId>
<artifactId>mybatis</artifactId>
<version>1.@-SNAPSHOT</version>

<properties>
<maven..compiler. source>22</maven. compiler. source>
<maven. compiler.target>22</maven.compiler.target>
<project . build. sourceEncoding>UTF-8</project . build. sourceEncoding>

</properties>

<dependencies>

<dependency>
<groupId>mysql</groupld>

<antifactId>mysql-connector-javas/artifactId>

sversion>8.0.3@</version>
</dependency>
<dependency>
<groupId>org.mybatis</groupId>
<artifactId>mybatis</artifactId>
<version>3.5.9</version>
</dependency>
</dependencies>

</project>
```

### Image 8 (image5.png)
```
Project v </> Mybatis-configxml

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration

Y DQ mybatis D:\DataBaseExperiment\experiment3\mybatis

> D idea PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
Y Dsre “https: //mybatis org/dtd/mybatis-3-config.dtd">
Y Dain kconfiguration>
Cr <environments default="development">
ee) <environment id="development">
vy Bcomaiansen <transactionManager type="JDBC"/>
Y @& Mapper <te- BES \ BAER my sql AREAS -->
<dataSource type="POOLED">
@ StudentsMapper . _ .
<property "driver" value="com.mysql.cj-jdbc.Driver"/>
Y Boo <property jdbc:mysql: //localhost :3306/scoremanagement"/>
© Students <property lvalue="root"/>
© Teachers <property [value="1234"/>
</dataSource>
» (Sess </environment>
¥ (© comaiansen.Mapper </environments>
greek MEET <!--  REBSsqlihst-->
= <mappers>
</> Mybatis-configaxm! <mapper resourcel"com.giansen.Mapper/StudentsMapper .xm1"/
Y Bites CEES
© (Sis 22 </configurationa
Gest
> Dtarget
 stignore
```

### Image 9 (image6.png)
```
Y ©) comajiansen
\ @ Mapper
© StudentsMapper

v Bpojo
© Students
© Teachers

Y QRresources

¥ (© comaiansen.Mapper

~* StudentsMapperxml

</> Mybatis-config.xml

Y Dest

v Diava
Grest
> Dtarget
@ aitignore
M pomxmi
```

### Image 10 (image7.png)
```
package com.qiansen.pojo;

public class Students { 5 usages
private int sid; 4usages

private String sname; 4usages

public Students() { no usages
t

public Students(int sid, String sname) { no usages
this.sid = sid;

this.sname = sname;

public int getSid()/{/return sid;!}

public void setSid(int sid)/{/this.sid = sid;/}

public String getSname()| {return sname;\ }

public void setSname(String sname)| { this.sname

public String toString()| {return "Students{sid
```

### Image 11 (image8.png)
```
10

&

Package com.qiansen.Mapper;
import com.qiansen.pojo.Students;
import java.util.List;

public interface StudentsMapper { 4 usages
List<Students> selectall(); 2 usages
```

### Image 12 (image9.png)
```
Project v

Y OG mybatis D:\DataBaseExperiment\experiment3\mybatis

> D idea
Y Bsc

Y Bimain
\ Diava

® comaiansen
Y @& Mapper
* StudentsMapper

14

StudentsMapperxml

«

«

<?xml version="1.0" encoding="UTF-8" ?>
<!IDOCTYPE mapper

PUBLIC “-//mybatis.org//DTD Mapper 3.0//EN"

"http: //mybatis.org/dtd/mybatis-3-mapper .dtd">
<|--namespace=Bind a corresponding Dao/Mapper interface-->

{mapper namespace="com.giansen.Mapper .StudentsMapper">
<!--select#iiz a] -->
<select id="selectall" resultTyp.

select * from scoremanagement.students.
wen</select>

‘com. giansen.pojo.Students">’

</mappers|
```
