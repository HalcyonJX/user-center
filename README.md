# 用户中心管理项目

#### 1. 项目简介

企业核心的用户中心系统，基于 Spring Boot 后端 + React 前端的 **全栈项目** ，实现了用户注册、登录、查询等基础功能。

项目仓库地址：https://github.com/HalcyonJX/user-center

##### 1.1 项目收获

1. 学会前后端企业主流开发技术的应用
2. 了解做项目的完整流程，能够独立开发及上线项目
3. 学到系统设计的方法和经验
4. 学到一些实际的编码技巧，比如开发工具、快捷键、插件的使用
5. 学到代码的优化技巧，比如抽象、封装、提高系统性能、节约资源的方法
6. 学习登录态、代理、多环境、容器、跨域等重要的开发知识
7. 学到一些源码阅读的技巧
8. 提升自主解决问题的能力

##### 1.2 技术选型

###### 前端

主要运用阿里Ant Design生态：

- HTML+CSS+JavaScript三件套
- React开发框架
- Ant Design Pro项目模板
- Ant Design端组件库
- Umi开发框架
- Umi Request请求库
- 正向和反向代理

###### 后端

- Java编程语言
- Spring+SpringMVC+SpringBoot框架
- MyBatis+MyBatis Plus数据访问框架
- MySQL数据库
- jUnit单元测试库

#### 2. 项目开发流程

##### 2.1 需求分析

1. 登录/注册
2. 用户管理（仅管理员可见）对用户的查询或者修改
3. 用户校验（仅星球用户可见）

##### 2.2 技术选型

- 前端

  三件套+React+组件库Ant Design+Umi+Ant Design Pro(现成的管理系统)

- 后端

  - java
  - spring(依赖注入框架，帮助你管理Java对象，集成一些其他的内容)
  - springmvc(web框架，提供接口访问、restful接口等能力)
  - mybatis(Java操作数据库的框架，持久层框架，对jdbc的封装)
  - mybatis-plus(对mybatis的增强，不用写sql也实现增删改查
  - springboot(快速启动/快速集成项目。不用自己管理spring配置，不用自己整合各种框架)
  - junit单元测试库
  - mysql数据库

# 项目初始化

![](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240915160305182.png)

## 前端初始化

### Ant Design Pro

[官网](https://pro.ant.design/zh-CN/docs/getting-started/)

在创建的目录文件夹里，在地址栏输入cmd

![image-20240915160852916](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240915160852916.png)

按照官网输入命令 `npm i @ant-design/pro-cli -g`，第二个命令`pro create user-center-frontend`：

![image-20240526211543654](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526211543654.png)

### 启动项目

在右上角设置，点击项目结构，导入生成的前端模块：

![image-20240915163400533](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240915163400533.png)

初始化前端项目，运行一下`npm install`：
![image-20240915163506491](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240915163506491.png)

运行十分缓慢。。。

运行start脚本，打开项目

![image-20240511001711263](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240511001713.png)

两种启动命令的区别：

start:dev 比start 多了一个 **MOCK=none**，这是把模拟的数据给关闭了，因为现在没有写后端，所以使用start:dev去启动项目就不能登录了。

按照提示输入用户名和密码，就可以进入以下页面：

![image-20240526211619704](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526211619704.png)

### 项目瘦身

减少国际化内容

因为没有国外访问，项目中提供了删除国际化的脚本命令，国际化代码在src->locales文件夹下。

在package.json中找到 `i18n-remove`,运行帮你删除国际化的一些代码

![image-20240511003832985](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240511003833.png)

- 介绍项目结构

![image-20240511003638759](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240511003639.png)

![image-20240511003655868](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240511003656.png)

![image-20240526211645927](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526211645927.png)

上面可以删除的文件都删除了

除此之外，还需要删除以下引用到已删除文件的代码

重新启动项目，至此，前端初始化完毕。

## 后端初始化

### 初始化后端项目

本项目使用Java8，配置服务器URL:`start.aliyun.com`

![image-20240915170704069](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240915170704069.png)

选择依赖项：

![image-20240512002132035](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512002132.png)

测试连接一下mysql就行了。

### 引入mybatis-plus

[官网](https://baomidou.com/)

按照官网用例测试一下：

![image-20240526211714514](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526211714514.png)

我们创建一个数据库：

![image-20240915171513521](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240915171513521.png)

按照官网实例测试一下demo：

![image-20240512003140591](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512003141.png)

测试成功之后，我们就可以导入mybatis-plus的依赖了：

`````xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.1</version>
</dependency>
`````

导入依赖成功后，将`application.properties`的后缀名改为`yml`，yml高级一点，支持嵌套。

在application.yml中写入项目名和端口号，数据库的配置：

![image-20240915172157874](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240915172157874.png)

### 扫描mapper文件夹

按照官网开始下一步，在 Spring Boot 启动类中添加 `@MapperScan` 注解，扫描 Mapper 文件夹：

````java
@SpringBootApplication
@MapperScan("com.guyue.usercenterbackend.mapper")
public class UserCenterBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterBackendApplication.class, args);
    }

}
````

我们创建一个mapper文件夹，再创建一个model文件夹，model文件夹存放Java对象，和数据库字段做一个映射：

`````java
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
`````

编写 Mapper 包下的 `UserMapper`接口:

````java
@Repository
public interface UserMapper extends BaseMapper<User> {
    //继承这个类，里面写了很多crud方法
}
````

### 开始使用

导入Junit依赖：

````xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
</dependency>
````

如果还不行，换成2.7.8版本的：

![image-20240915221713512](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240915221713512.png)

很迷惑，加载不出来这个版本，却能运行，换2.2.2版本不能运行。

```java
import com.guyue.usercenterbackend.mapper.UserMapper;
import com.guyue.usercenterbackend.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class SampleTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5,userList.size());
        userList.forEach(System.out::println);
    }

}
```

## 数据库设计

### 表设计

用户表：

| 字段         | 说明                         | 类型       |
| ------------ | ---------------------------- | ---------- |
| id           | 用户id（主键）               | bigint     |
| username     | 昵称                         | varchar    |
| userAccount  | 登录账号                     | varchar    |
| userPassword | 密码                         | varchar    |
| avatarUrl    | 头像                         | vachar     |
| gender       | 性别                         | tinyint    |
| phone        | 电话                         | varchar    |
| email        | 邮箱                         | varchar    |
| userStatus   | 用户状态                     | int 0-正常 |
| createTime   | 创建时间                     | datetime   |
| updateTime   | 更新时间                     | datetime   |
| isDelete     | 是否删除(逻辑删除)           | tinyint    |
| userRole     | 用户角色 0-普通用户 1-管理员 | int        |
| planetCode   | 星球编号                     | varchar    |

### 使用idea开始建表

![image-20240526211801166](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526211801166.png)

最终建表语句：

````sql
# 用户表
create table user
(
    id           bigint auto_increment comment 'id' primary key,
    username     varchar(256)                       null comment '用户昵称',
    userAccount  varchar(256)                       null comment '账号',
    userPassword varchar(512)                       not null comment '密码',
    avatarUrl    varchar(1024)                      null comment '用户头像',
    gender       tinyint                            null comment '性别',
    phone        varchar(128)                       null comment '电话',
    email        varchar(512)                       null comment '邮箱',
    userStatus   int      default 0                 not null comment '状态 0 - 正常',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete     tinyint  default 0                 not null comment '是否删除',
    userRole     int      default 0                 not null comment '用户角色 0 - 普通用户 1 - 管理员',
    planetCode   varchar(512)                       null comment '星球编号'
)
    comment '用户';
````

# 后端功能开发

## 注册功能

### 项目目录

创建`controller`、`service`、`utils`：

+ controller：请求层或控制层。这个目录中的所有文件专门用来接收请求，不做任何的业务处理，只接收请求
+ service：专门用来编写业务逻辑，比如说登录注册
+ mapper：数据访问层，专门用于从数据库中查询数据
+ model：定义了数据库相对应的母校，或者用到的一些封装类
+ utils：存放一些工具类

删掉一些没用的文件：之前的测试类，还有static文件。

剩下的文件：

![image-20240526212101899](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212101899.png)

### 数据库基本操作

使用自动生成器：

> MybatisX 插件，自动根据数据库生成 domain实体对象、mapper（操作数据库的对象）、mapper.xml（定义了mapper对象和数据库的关联，可以在里面自己写SQL）、service（包含常用的增删改查）、serviceImpl（service的具体实现）

在idea中安装MybatisX插件，然后对`user`表使用`MybatisX-Generator`：

![image-20240526212110239](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212110239.png)

![image-20240512111256507](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512111257.png)

![image-20240512111459718](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512111500.png)

这里Model要勾选上。

生成的代码，把domain放在model包下；UserMapper放到mapper包下；impl包和UserService放到service包下；然后删除generator包：

![image-20240512112326431](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512112327.png)

![image-20240526212122695](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212122695.png)

resources文件夹中的UserMapper.xml是mp框架使用到的一个配置文件，会和Mapper文件关联上，当我们移动刚才生成的代码，有可能会使这个文件里的路径不对。

测试一下代码是否可用

给UserService创建一个测试类，把鼠标放在UserService上，按下alt+enter：

![image-20240512112908346](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512112909.png)

在生成类中编写代码：

````java
@SpringBootTest
class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();

        boolean save = userService.save(user);
    }
}
````

这里使用一个插件`GenerateAllSetter`，这个插件可以一键帮你生成对象的所有set方法等。将鼠标放在user上，按alt+enter：

![image-20240526212136163](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212136163.png)

然后删除一些不需要设置的字段，最后测试代码：

````java
@SpringBootTest
class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("古月方源");
        user.setUserAccount("fangyuan");
        user.setUserPassword("123456");
        user.setAvatarUrl("https://gitee.com/n1ghtstar3/picture/raw/master/20240512113432.png");
        user.setGender(1);
        user.setPhone("123");
        user.setEmail("456");
        boolean save = userService.save(user);
        System.out.println(user.getId());
        //断言，判断是不是真
        Assertions.assertTrue(save);
    }
}
````

运行之后出现如下报错：Unknown column 'user_account' in 'field list'

![image-20240526212148279](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212148279.png)

**报错原因**：mybatis-plus 默认会将驼峰转换成下划线，所以就出现在“字段列表”中出现未知列”user_account"，在application.yml中关闭默认转换。

![image-20240512114316027](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512114316.png)

![image-20240512114352642](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512114353.png)

添加之后再次运行就运行成功了，可以在数据库中看到插入的数据。

### 注册逻辑

1. 用户在前端输入账号和密码、以及校验码(todo)
2. 校验用户的账号、密码、校验密码，是否符合要求
   + 非空
   + 账号长度不小于4位
   + 密码长度不小于8位
   + 账号不能重复
   + 账号不包含特殊字符
   + 密码和校验密码相同
3. 对密码进行加密（不能明文存储到数据库中）
4. 向数据库中插入用户数据

### 注册代码

接口逻辑开发，在userService里写：

````java
public interface UserService extends IService<User> {
    /**
     * 注册接口
     * @param userAccount 账号
     * @param userPassword 密码
     * @param checkPassword 校验密码
     * @return 返回新用户ID
     */
    long userRegister(String userAccount,String userPassword,String checkPassword);
}
````

然后写实现方法，鼠标放在userRegister上，alt+enter：

![image-20240512115420490](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512115421.png)

写实现类之前，去[maven repository](https://mvnrepository.com/) 找一个很好用的库，搜索`apache common lang`，找到使用人最多的一个。使用这个依赖的原因是为了调用StringUtils类中的方法，简化校验代码：

````xml
<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.12.0</version>
</dependency>
````

实现类方法：

````java
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        //1.校验
        if(StringUtils.isAllBlank(userAccount,userPassword,checkPassword)){
            return -1;
        }
        if(userAccount.length() < 4){
            return -1;
        }
        if(userPassword.length() < 8 || checkPassword.length() < 8){
            return -1;
        }

        //账户不能包含特殊字符
        String validPattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\]/<>/?~! @#￥%……&*（）——+|{}【】‘；：“”’。，、？]"; //正则表达式，网上搜
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if(matcher.find()){
            return  -1;
        }
        //密码和校验密码相同
        if(!userPassword.equals(checkPassword)){
            return -1;
        }

        //账户不能重复
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("userAccount",userAccount);
        Long count = userMapper.selectCount(userQueryWrapper);
        if(count > 0){
            return  -1;
        }
        //2.加密
        final String SALT = "love";
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        //3.插入数据
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptPassword);
        boolean result = this.save(user);
        if(!result){
            return -1;
        }
        return user.getId();
    }
}
````

测试一下，鼠标放在userRegister上，alt+enter：

![image-20240526212206207](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212206207.png)

测试类方法：

````java
@Test
void userRegister() {
    String userAccount = "ningbing";
    String userPassword = "";
    String checkPassword = "123456";
    long result = userService.userRegister(userAccount, userPassword, checkPassword);
    Assertions.assertEquals(-1,result);
    userAccount = "bin";
    result = userService.userRegister(userAccount,userPassword,checkPassword);
    Assertions.assertEquals(-1,result);
    userAccount = "yupi";
    userPassword = "123456";
    result = userService.userRegister(userAccount,userPassword,checkPassword);
    Assertions.assertEquals(-1,result);
    userAccount = "yu pi";
    userPassword = "12345678";
    result = userService.userRegister(userAccount,userPassword,checkPassword);
    Assertions.assertEquals(-1,result);

    checkPassword = "123456789";
    result = userService.userRegister(userAccount,userPassword,checkPassword);
    Assertions.assertEquals(-1,result);

    userAccount = "fangyuan";
    checkPassword = "12345678";
    result = userService.userRegister(userAccount,userPassword,checkPassword);
    Assertions.assertEquals(-1,result);

    userAccount = "ningbing";
    result = userService.userRegister(userAccount,userPassword,checkPassword);
    Assertions.assertTrue(result > 0);
}
````

测试通过，数据库能查到插入的数据即成功。

## 登录功能

### 登录接口

接收参数：用户账号、密码（请求参数很长时不建议用get）

请求类型：POST

请求体：JSON格式的数据

返回值：用户信息(**脱敏**)

### 登录逻辑

1. 校验用户账号是否合法
   + 非空
   + 账号长度不小于4位
   + 密码不小于8位
   + 账号不包含特殊字符
2. 校验密码是否输入正确，要和数据库中的密文密码去对比
3. 我们要记录用户的登录态(**session**)，将其存到服务器上(用后端SpringBoot框架封装的服务器tomcat去记录cookie)
4. 返回脱敏后的用户信息

### 如何知道是哪个用户登录了？

1. 连接服务器端后，得到一个session状态(匿名会话)，返回给前端
2. 登录成功后，得到了登录成功的session，并且给该session设置一些值(比如用户信息)，返回给前端一个设置cookie的"命令"
3. 前端接收到后端的命令后，设置cookie，保存到浏览器内
4. 前端再次请求后端的时候(相同的域名)，在请求头中带上cookie去请求
5. 后端拿到前端传来的cookie，找到对应的session
6. 后端从session中可以取出基于该session存储的变量(用户的登录信息、登录名)

### 简单说明cookie和session

**以最常见的登录案例讲解cookie的使用过程：**

1. 首先用户在客户端浏览器向服务器首次发起登录请求
2. 登录成功后，服务端会把登录的用户信息设置在cookie中，并将cookie返回给客户端浏览器
3. 客户端浏览器接收到cookie请求后，会把cookie保存到本地(内存和磁盘都有可能，看情况而定)
4. 以后再次访问该web应用时，客户端浏览器就会把本地的cookie带上，这样服务端就能根据cookie获得用户信息了

**以登录案例讲解session的使用过程：**

1. 首先用户在客户端浏览器发起登录请求
2. 登录成功后，服务端会把用户信息保存在服务器，并返回一个唯一的session标识给客户端浏览器。
3. 客户端浏览器会把这个唯一的session标识保存起来
4. 以后再次访问web应用时，客户端浏览器会把这个唯一的session标识带上，这样服务端就能根据这个唯一标识找到用户信息。

### 登录代码

在userservice里写登录接口：

````java
/**
 * 登录接口
 * @param userAccount 用户账号
 * @param userPassword 用户密码
 * @return 脱敏后的用户信息
 */
User userLogin(String userAccount,String userPassword);
````

快捷生成实现方法，写登录逻辑(复用一部分注册逻辑)。

关于盐值，注册和登录都需要用到，所以提取到方法外，作为类属性：

`````java
/**
 * 盐值，混淆密码
 */
private static final String SALT = "love";
`````

记录日志，使用一个`@Slf4j`的注解：

![image-20240512151555237](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512151556.png)

按照登录逻辑写代码：

`````java
@Override
public User userLogin(String userAccount, String userPassword) {
    //1.先校验
    if(StringUtils.isAnyBlank(userAccount,userPassword)){
        return null;
    }
    if (userAccount.length() < 4) {
        return null;
    }
    if (userPassword.length() < 8) {
        return null;
    }
    //账号不能包含特殊字符
    String validPattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\]/<>/?~! @#￥%……&*（）——+|{}【】‘；：“”’。，、？]"; //正则表达式，网上搜
    Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
    if (matcher.find()) {
        return null;
    }
    //2.加密
    String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());

    //3.查询用户是否存在
    QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
    userQueryWrapper.eq("userAccount", userAccount);
    userQueryWrapper.eq("userPassword",encryptPassword);
    User user = userMapper.selectOne(userQueryWrapper);
    //用户不存在
    if(user == null){
        //日志
        log.info("user login failed,userAccount Cannot match userPassword");
        return null;
    }
    //3.用户脱敏

    //4.记录用户的登录态
    return user;
}
`````

再给UserService添加一个请求参数，我们需要它来记录用户的登录状态：

![image-20240512152447873](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512152448.png)

继续写记录用户的登录状态，怎么记录用户的登录状态呢？我们使用request，用getSession拿到session，用setAttribute往session里设置一些值(比如用户信息)。

setAttribute它是一个map，可以存储键值对，我们就需要设置一个键值对，给用户的登录状态分配一个建。(放在类属性那里)：

````java
/**
 * 用户登录状态键
 */
public static final String USER_LOGIN_STATE = "userLoginState";

//4.记录用户的登录态
request.getSession().setAttribute(USER_LOGIN_STATE,user);
````

### 用户脱敏

我们在登录之后，返回给前端一些信息，但是我们不能将数据库中所有关于用户的信息都返回，所以我们要对用户信息进行脱敏：

![image-20240526212222295](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212222295.png)

填写返回值，不需要返回的就删了：

````java
//3.用户脱敏
User safetyUser = new User();
safetyUser.setId(user.getId());
safetyUser.setUsername(user.getUsername());
safetyUser.setUserAccount(user.getUserAccount());
safetyUser.setAvatarUrl(user.getAvatarUrl());
safetyUser.setGender(user.getGender());
safetyUser.setPhone(user.getPhone());
safetyUser.setEmail(user.getEmail());
safetyUser.setUserStatus(user.getUserStatus());
safetyUser.setCreateTime(user.getCreateTime());
return safetyUser; //注意这里返回脱敏后的user
````

### 逻辑删除

上面代码其实还是有问题，用户被删除只是逻辑上被删除，还是存在于数据库当中，我们还是可以查到的，我们可以到Mybatis-plus官网上找到逻辑删除。

![image-20240526212228539](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212228539.png)

放入application.yml中的代码：

````yaml
mybatis-plus:
  configuration:
    map-underscore-to-camel-case: false
  global-config:
    db-config:
      logic-delete-field: isDelete # 全局逻辑删除的实体字段名(since 3.3.0,配置后可以忽略不配置步骤2)
      logic-delete-value: 1 # 逻辑已删除值(默认为 1)
      logic-not-delete-value: 0 # 逻辑未删除值(默认为 0)
````

在User类中给`isDelete`字段打上注解`@TableLogic`即可。

## 控制层编写接口

**控制层 Controller 封装请求**

> controller 层倾向于对请求参数本身的校验，不涉及业务逻辑本身（越少越好）
>
> service 层是对业务逻辑的校验（有可能被 controller 之外的类调用）
>
> [@RestController ]() 设用于编写 restful 风格的 api，返回值默认为 json 类型 

在controller包下创建一个UserController类，打上@RestController注解，这个类里面所有的请求的接口返回值，响应的数据类型都是application json，再打上@RequestMapping，定义请求路径写user即可。

```java
@RestController
@RequestMapping("/user")
public class UserController {
    
}
```

下载插件`Auto filling Java call arguments`，自动填充java的参数。

### 用户注册请求

在参数括号中alt+enter使用刚才下载的插件：

![image-20240512154604910](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512154605.png)

使用json格式的参数最好封装一个对象，来记录所有参数。在`model.domain`下创建request包，包下新增一个对象UserRegisterRequest。

写上注释，继承Serializable可序列化接口，生成序列化ID（先搜索操作`serializable class without serialVersionUID`,然后打勾即可）。

![image-20240512155214816](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512155215.png)

![image-20240526212246248](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212246248.png)

回到UserController.java，就可以在userRegister引用UserRegisterRequest，在参数位置打上一个@RequestBody，没打上的话，SpringMVC框架不知道怎么把前端传来的json参数去跟合适的对象做一个关联。

````java
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/register")
    public Long userRegister(@RequestBody UserRegisterRequest userRegisterRequest){
        if(userRegisterRequest == null){
            return null;
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        if(StringUtils.isAnyBlank(userAccount,userPassword,checkPassword)){
            return null;
        }
        return userService.userRegister(userAccount,userPassword,checkPassword);
    }
}
````

### 用户登录请求

UserLoginRequest：

````java
/**
 * 用户登录请求体
 * @author HalcyonJX
 */
@Data
public class UserLoginRequest implements Serializable {
    private static final long serialVersionUID = 229191219915041796L;
    private String userAccount;
    private String userPassword;
}
````

````java
@PostMapping("/login")
public User userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request){
    if(userLoginRequest == null){
        return null;
    }
    String userAccount = userLoginRequest.getUserAccount();
    String userPassword = userLoginRequest.getUserPassword();
    if(StringUtils.isAnyBlank(userAccount,userPassword)){
        return null;
    }
    return userService.userLogin(userAccount,userPassword,request);
}
````

### 测试

idea自带了一个测试工具，Tools -> HTTP Client -> Create Request in HTTP Client

![image-20240526212359409](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212359409.png)

![image-20240512160510997](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512160511.png)

![image-20240526212408947](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212408947.png)

打断点，然后debug模式启动UserCenterApplication，然后再启动工具。

![image-20240512160816902](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512160817.png)

登录成功才有返回结果，登录失败无返回结果。

查看一下返回结果：

![image-20240526212423993](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212423993.png)

## 用户管理

> !!! 必须鉴权，这些只能管理员使用
>
> 1. 查询用户（允许根据用户名查询）、
>
> 2. 删除用户

在UserController下继续编写用户管理接口

**查询用户**：

````java
@GetMapping("/search")
public List<User> searchUsers(String username){
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    if(StringUtils.isNotBlank(username)){
        queryWrapper.like("username",username);
    }
    return userService.list(queryWrapper);
}
````

**删除用户**：

`````java
@PostMapping("/delete")
public boolean deleteUser(@RequestBody long id){
    if(id <= 0){
        return false;
    }
    return userService.removeById(id);
}
`````

这两个方法有问题：因为这个接口随便一个人就能调用，我们还没有校验他是否是管理员。

在数据库表中添加一个字段(此前我们已经添加过了)。添加后再生成一次代码，修改一下即可。

在用户脱敏中添加管理员的set方法：

`````java
safetyUser.setUserRole(user.getUserRole());
`````

回到UserController，添加一个校验，首先我们要先拿到用户的登录状态：

![image-20240512163820702](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512163821.png)

这里我们需要拿到用户登录状态，所以将定义的登录状态键，剪切到UserService来

![image-20240526212432565](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212432565.png)

回到UserController继续编写：

````java
@GetMapping("/search")
public List<User> searchUsers(String username,HttpServletRequest request){
    //仅管理员可查询
    Object userObj = request.getSession().getAttribute(UserService.USER_LOGIN_STATE);
    User user = (User) userObj;
    if(user == null || user.getUserRole() != 1){
        return new ArrayList<>();
    }
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    if(StringUtils.isNotBlank(username)){
        queryWrapper.like("username",username);
    }
    return userService.list(queryWrapper);
}
````

这段代码能算绝对完美吗？其实不完美，这里它的用户角色还是有点问题的，先建一个包，叫constant，在包下创建UserConstant接口，将刚刚的用户登录状态键剪切过来，再写两个权限常量：

![image-20240512164528822](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512164529.png)

有两个地方会出现问题，导入即可。

利用常量，把1改成 ADMIN_ROLE：

`````java
if(user == null || user.getUserRole() != ADMIN_ROLE){
    return new ArrayList<>();
}
`````

删除接口也是同样逻辑：

````java
@PostMapping("/delete")
public boolean deleteUser(@RequestBody long id,HttpServletRequest request){
    //仅管理员可删除
    Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
    User user = (User) userObj;
    if(user == null || user.getUserRole() != ADMIN_ROLE){
        return false;
    }
    if(id <= 0){
        return false;
    }
    return userService.removeById(id);
}
````

提取重复代码：

````java
/**
     * 是否为管理员
     * @param request 请求
     * @return 返回布尔值
     */
private boolean isAdmin(HttpServletRequest request){
    //仅管理员可查询
    Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
    User user = (User) userObj;
    return user != null && user.getUserRole() == ADMIN_ROLE;
}
````

前面两段代码：

````java
if(!isAdmin(request)){
    return new ArrayList<>();
}
if(!isAdmin(request)){
    return false;
}
````

在application.yml增加session失效时间(1天)

![image-20240512165250966](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512165251.png)

移除之前的登录态，把target删除。

因为管理员查询用户也需要脱敏，封装一下脱敏代码：

````java
/**
 * 用户脱敏
 * @param originUser 原始的用户
 * @return 返回脱敏的用户
 */
public User getSafetyUser(User originUser){
    User safetyUser = new User();
    safetyUser.setId(originUser.getId());
    safetyUser.setUsername(originUser.getUsername());
    safetyUser.setUserAccount(originUser.getUserAccount());
    safetyUser.setAvatarUrl(originUser.getAvatarUrl());
    safetyUser.setGender(originUser.getGender());
    safetyUser.setPhone(originUser.getPhone());
    safetyUser.setEmail(originUser.getEmail());
    safetyUser.setUserStatus(originUser.getUserStatus());
    safetyUser.setCreateTime(originUser.getCreateTime());
    safetyUser.setUserRole(originUser.getUserRole());
    return safetyUser;
}
````

以前的代码：

````java
//3.用户脱敏
User safetyUser = getSafetyUser(user);
````

再给这个getSafetyUser上加一个@Override注解，然后Pull到接口里，UserService.java就会多这个方法。

![image-20240512165834366](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240512165835.png)

`````java
/**
 * 用户脱敏
 * @param originUser 原始用户
 * @return 返回脱敏用户
 */
User getSafetyUser(User originUser);
`````

去到searchUsers里，修改最后一句代码，把最后一句代码脱敏一下，Java8的知识。

`````java
return userService.list(queryWrapper);
改为
List<User> userList = userService.list(queryWrapper);
return userList.stream().map(user -> {
    return userService.getSafetyUser(user);
}).collect(Collectors.toList());
`````

接下来就像之前一样测试一下查询和删除接口。

# 前端功能开发

## 修改页面信息

修改底部信息：

![image-20240526212659585](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212659585.png)

我的修改：

![image-20240526212708671](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212708671.png)

修改项目logo：

定义一个全局的常量，在src包下新建constant包，在constant新建一个`index.ts`，把自己的logo地址复制一下。

![image-20240526212743389](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212743389.png)

把`/logo.svg`改为`{SYSTEM_LOGO}`，这里要导入一下。

![image-20240513134036721](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513134037.png)

## 删除多余代码

删掉其他登录方式，反正我们不需要这些：

![image-20240513134842361](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513134843.png)

删掉手机号登录：

![image-20240918212858969](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240918212858969.png)

删掉后半截：

![image-20240918212945663](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240918212945663.png)

修改输入栏默认信息，改为请输入账号和请输入密码：

![image-20240526212757270](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212757270.png)

全局替换，把用户名改为账号，快捷键ctrl+r。

删掉验证码，手机号的登录代码：

![image-20240918213358244](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240918213358244.png)

将忘记密码修改为 忘记密码联系管理员：

![image-20240918213550766](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240918213550766.png)

## 对接后台接口

找到登录参数，修改为后端对应的名称`userAccount`和`userPassword`，按f6进行重构：

![image-20240513141831180](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513141832.png)

回到handleSubmit，点击login，修改request的请求地址，去[Ant Design Pro](https://pro.ant.design/zh-CN/docs/overview/)搜索请求：

![image-20240526212809756](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212809756.png)

![image-20240918215733530](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240918215733530.png)

在`app.tsx`文件中添加：

`````typescript
export const request: RequestConfig = {
  prefix:'http://localhost:8080',
  timeout:1000,
};
`````

在登录接口中，修改路径：`/api/user/login`

![image-20240526212819664](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212819664.png)

去登录测试一下：

![image-20240918220538895](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240918220538895.png)

> 现在有一个问题，有啥问题，我们遇到了一个跨域错误，为什么会跨域？因为我们当前前端的浏览器地址是在8000端口，但是后端在8080端口，端口不一样，就是跨域的。跨域的解决方式有很多种，要吗搭一个代理，要吗在后端支持跨域，但是后端支持跨域很不安全。

Ant Design Pro提供了一个配置代理的方式，在`proxy.ts`文件中，将地址修改为本地8080端口地址：

![image-20240526212825757](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212825757.png)

删掉之前的`prefix`，因为前端请求路径默认是8000端口，所以不用额外配置，转发到8080是代理完成的，对前端是隐形的，前端访问路径还是8000。

![image-20240918221126373](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240918221126373.png)

后端yml文件里，指定全局api：

![image-20240513145627039](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513145628.png)

在`index.tsx`中把username统一替换成userAccount，ctrl+r 替换，password也全部替换成userPassword（有些不用替换）

给密码加个长度校验：

![image-20240526212833455](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212833455.png)

这里改成user，如果user存在的话，就显示登录成功，并且设置用户的登录状态为user：

![image-20240513150753621](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513150754.png)

测试一下，后端断点打在登录接口校验处。后端可以接收到请求，拿到账号和密码则成功。

使用数据库里的数据可以看到前端的响应就成功了。

![image-20240526212842174](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212842174.png)

不知道为什么，谷歌浏览器没返回信息。

bug修复：这里记录的是`safetyUser`的登录态

![image-20240918232408246](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240918232408246.png)

### 补充知识：

前后端交互：

+ 前端需要向后端发送请求
+ 前端ajax请求后端
+ axios封装了ajax
+ request是ant design 项目又封装了一次
+ 追踪request源码：用到了umi插件、requestConfig是一个配置

代理：

+ 正向代理：替客户端向服务端发送请求，可以解决跨域问题
+ 反向代理：替服务端统一接收请求。

怎么搞代理？

Nginx 服务器

Node.js 服务器

这个项目中

原本请求：http://localhost:8000/api/user/login

代理到请求：http://localhost:8080/api/user/login

反向代理和正向代理的区别：https://www.cnblogs.com/taostaryu/p/10547132.html

## 注册功能

### 快速添加一个注册页面

直接复制登录页面，然后修改名称`Register`

将两个`Login`替换成`Register`

![image-20240513153832712](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513153834.png)

### 定义注册地址

我们需要去定义一下，用户在地址栏里面输入什么网址，才能够访问到新建的页面，新建路由。

> 我们现在是用了React router这样一个路由组件，可以帮助我们把url和写的页面组件关联上，这样的话用户访问某一个地址。比如说user/register，然后访问它的时候，后面去指定一个我们写的组件的位置，比如说user/register，它就会找到user配置目录下的register

![image-20240526212849715](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212849715.png)

在index.tsx中注释代码

到`app.tsx`修改一些内容(不做这些访问register时会重定向到login页面)

![image-20240526212854399](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212854399.png)

修改以下代码：

![image-20240513171338646](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513171339.png)

### 写前端代码

删除代码：

![image-20240513171825995](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513171826.png)

接着删除忘记密码，手机登录，自动登录等。

![image-20240919112224415](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240919112224415.png)

修改代码，修改界面标题，改为账号密码注册：

![image-20240513172316979](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513172317.png)

注册需要两个密码框，复制密码框代码：

![image-20240513172425991](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513172426.png)

修改提示信息：

![image-20240526212908289](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212908289.png)

再把中文登录全局替换成注册，但是此时登录按钮还是没有从登录变成注册。（因为我们使用这个现成的loginform组件的原因，不是我们自己写的）

去看LoginForm的源码，点击LoginForm，进入到对应的文件，这个是这个组件的类型定义。

![image-20240513173425376](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513173426.png)

点击webstrom上的选择打开的文件，定位到这个文件的位置

![image-20240526212920182](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212920182.png)

点击js，就能看见组件源码，源码里有一个`submitText`

![image-20240513173502595](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513173503.png)

在注册页面index.tsx中新增代码：

![image-20240513173705259](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513173706.png)

这样注册界面按钮就成功修改了文本。

然后我们开始写提交逻辑

找到index.tsx中的表单提交，ctrl点击`LoginParams`，复制登录参数到下面，修改为注册参数，再回到index.tsx中，将LoginParams修改为RegisterParams：

![image-20240526212931405](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212931405.png)

将`LoginParams`替换成`RegisterParams`：

![image-20240919113139009](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240919113139009.png)

新增密码校验：

![image-20240513174900273](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513174901.png)

编写注册接口，ctrl+点击login：

![image-20240919113702606](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240919113702606.png)

点击LoginResult，到跳转的页面中复制`loginresult`，修改成注册result，再回到刚才跳转过来的地方，将`LoginResult`改成`RegisterResult`，回到index.tsx 把user改为id，login改成register，并修改一下注册逻辑。

![image-20240526212942156](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212942156.png)

index.tsx中的id逻辑：

![image-20240513175804227](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513175805.png)

然后删除注册页面不需要的代码：

![image-20240513180003672](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513180004.png)

![image-20240526212953169](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212953169.png)

![image-20240513180115001](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513180115.png)

![image-20240526212958774](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526212958774.png)

在登录页面添加注册页面：

![image-20240513182202101](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240513182203.png)

### 前后端API接口测试

在后端注册接口打几个断点：

+ 试下密码不一致有没有弹出提示。弹出提示就成功
+ 试下正常进行注册 （没成功可能有超时的原因，重新启动），输入数据库已经存在的用户，注册失败，返回了`-1`，注册过了，用户名重复，我没有提示`用户名已经存在`,这是一个待优化的点。
+ 换一个用户名进行注册，提示注册成功，并且跳转到了登录页面。
+ 再进行登录测试，登录成功了，但是并没有返回信息和跳转页面。

## 登录功能

### 获取用户的登录态、信息接口

在UserServiceImpl做一个判断

![image-20240518124620869](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240518124622.png)

在UserController中添加获取当前用户登录态、信息接口：

![image-20240518124954088](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240518124955.png)

> 代码还是有问题的，因为没有判断用户是否被封号之类的

回到前端，在app.tsx点击queryCurrentUser

![image-20240526213006398](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213006398.png)

修改路径

![image-20240526213012201](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213012201.png)

点击CurrentUser，修改返回的东西(根据数据库字段)：

![image-20240518125507323](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240518125508.png)

修改app.tsx文件里的代码：

![image-20240518125630309](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240518125631.png)

将白名单提到最上面去：

![image-20240518125804757](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240518125805.png)

修改名称为`username`：

![image-20240526213025881](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213025881.png)

将白名单名称修改为`NO_NEED_LOGIN_WHITE_LIST`：

![image-20240518130203077](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240518130203.png)

修改登录代码(这里好像不需要修改）：

![image-20240518131018498](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240518131020.png)

我们需要将下面代码改为`user`：

![image-20240526213034322](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213034322.png)

### 头像水印设置

找到`AvatarDropDown.tsx`文件，修改头像的变量名`avatarUrl`，把报红的name换成username

![image-20240526213042788](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213042788.png)

点击`current`：在页面中修改以下代码

![image-20240518134642110](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240518134642.png)

![image-20240518134703515](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240518134704.png)

![image-20240518134748592](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240518134749.png)

在同级文件`index.tsx`下修改代码：

![image-20240518135030976](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240518135031.png)

## 用户管理后台

### 创建用户管理页面

这个框架有现成的管理页面，我们去看看人家写好的查询表格

![image-20240518232836998](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240518232838.png)

这些代码很复杂，我们整一个精简一点的，在page文件夹下新建Admin文件夹，把user文件下的Register文件夹复制粘贴到admin文件夹下，改名为UserManage

![image-20240518233053615](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240518233054.png)

去route.ts添加一个路由

![image-20240526213057519](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213057519.png)

access来自access.ts文件，我们修改一下权限，让管理员才能访问：

![image-20240526213102583](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213102583.png)

登录试试有没有作用，有作用就成功。

### 开发管理页面

删除二级管理页面的路由，因为我们已经写了一个自己的管理页面了。

更改一下写死的`Admin.tsx`页面，修改为以下内容：

![image-20240518234411248](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240518234413.png)

到官方文档找现有的表格[高级表格](https://procomponents.ant.design/components/table?tab=api&current=1&pageSize=5)，使用下面这个表格

![image-20240526213110349](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213110349.png)

复制代码到UserManage文件夹下的`index.tsx`，删除一些不需要的代码

![image-20240526213116599](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213116599.png)

![image-20240519000334478](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240519000335.png)

![image-20240519000407257](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240519000408.png)

![image-20240526213125248](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213125248.png)

![image-20240519000526664](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240519000529.png)

![image-20240526213134124](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213134124.png)

![image-20240923225839242](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240923225839242.png)

修改列名，改成`API.CurrentUser`

![image-20240519000716106](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240519000717.png)

修改展示的列，根据数据中的字段

````typescript
const columns: ProColumns<API.CurrentUser>[] = [
  {
    dataIndex: 'index',
    valueType: 'indexBorder',
    width: 48,
  },
  {
    title:'用户名',
    dataIndex:'username',
    copyable:true,
  },
  {
    title:'用户账号',
    dataIndex:'userAccount',
    copyable:true,
  },
  {
    title:'头像',
    dataIndex:'avatarUrl',
    copyable:true,
  },
  {
    title:'性别',
    dataIndex:'gender',
  },
  {
    title:'电话',
    dataIndex:'phone',
    copyable:true,
  },
  {
    title:'邮件',
    dataIndex:'email',
    copyable:true,
  },
  {
    title:'状态',
    dataIndex:'userStatus',
  },
  {
    title:'角色',
    dataIndex:'userRole',
  },
  {
    title:'创建时间',
    dataIndex:'createTime',
    valueType:'dateTime',
  },
  // {
  //   disable: true,
  //   title: '状态',
  //   dataIndex: 'state',
  //   filters: true,
  //   onFilter: true,
  //   ellipsis: true,
  //   valueType: 'select',
  //   valueEnum: {
  //     all: { text: '超长'.repeat(50) },
  //     open: {
  //       text: '未解决',
  //       status: 'Error',
  //     },
  //     closed: {
  //       text: '已解决',
  //       status: 'Success',
  //       disabled: true,
  //     },
  //     processing: {
  //       text: '解决中',
  //       status: 'Processing',
  //     },
  //   },
  // },
  // {
  //   disable: true,
  //   title: '标签',
  //   dataIndex: 'labels',
  //   search: false,
  //   renderFormItem: (_, { defaultRender }) => {
  //     return defaultRender(_);
  //   },
  //   render: (_, record) => (
  //     <Space>
  //       {record.labels.map(({ name, color }) => (
  //         <Tag color={color} key={name}>
  //           {name}
  //         </Tag>
  //       ))}
  //     </Space>
  //   ),
  // },
  // {
  //   title: '操作',
  //   valueType: 'option',
  //   key: 'option',
  //   render: (text, record, _, action) => [
  //     <a
  //       key="editable"
  //       onClick={() => {
  //         action?.startEditable?.(record.id);
  //       }}
  //     >
  //       编辑
  //     </a>,
  //     <a href={record.url} target="_blank" rel="noopener noreferrer" key="view">
  //       查看
  //     </a>,
  //     <TableDropdown
  //       key="actionGroup"
  //       onSelect={() => action?.reload()}
  //       menus={[
  //         { key: 'copy', name: '复制' },
  //         { key: 'delete', name: '删除' },
  //       ]}
  //     />,
  //   ],
  // },
];
````

在api.ts中增加一个搜索用户的接口

![image-20240519001557662](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240519001558.png)

回到UserManage文件夹下的index.tsx

![image-20240526213143394](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213143394.png)

页面 头像显示，直接显示图片：

![image-20240526213153225](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213153225.png)

角色不能直接显示0和1，优化一下，把这段代码剪切，粘贴到这里

![image-20240519002345235](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240519002346.png)

![image-20240519002511201](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240519002512.png)

将操作的代码留下，删掉其余注释掉的代码。

## 注销功能开发

### 后端开发

> 先写业务逻辑层，业务逻辑层就是service目录
>
> 我们这个项目所有代码基本都和用户相关，现在直接进入UserService.java，这个service类，service接口它就算专门用来编写用户相关的服务的。

方法名`userLogout`，暂时返回int，用户注销需要接收什么参数？看用户登录的时候。

​	**之前的用户登录逻辑，当用户登录成功，从数据库中校验他的账号和密码是正确的之后，我们要把用户的登陆状态存到服务器的一个session中，我们取这个session的时候，就从request对象中取。**

​	所以，我们想要用户注销的话，反其道而行之，移除登录状态，即注销登录。

在UserService里，这里接收参数是一个请求对象，因为session是和请求关联的，所以session要从request对象中取，就必须要把这个对象作为此参数：

![image-20240525175818282](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240525175820.png)

alt+enter快速实现这个方法，然后就可以从request中取session，之前我们把用户登录 状态的标识设置为了一个常量 USER_LOGIN_STATE ,移除属性就把这个常量移除掉就可以了，注销成功返 回1（在session中移除掉这个登录状态）

![image-20240525180015821](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240525180016.png)

> 现在service层写完了，现在去controller层，就是实际接收用户或者说前端的层，在这层编写接口。

复制login方法，粘贴到login方法的下面，修改为用户注销

![image-20240525180218812](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240525180219.png)

### 前端开发

> 前端注销代码，在导航条，component组件目录中，RightContent目录，AvatarDropdown(头像下拉菜单)

​	**如果说要注销，肯定要把前端已经存在的登录态给它设置为空，我们前端登录存在了app.tsx，这 里定义了一个currentUser，尤其是getInitialState方法，每次刷新页面或刚进入新页面时，最先执行 的一个方法。 这个方法中，定义了一些要初始化的操作，比如获取已登录用户的信息，会把用户信息放 到InitialState里，如果我们要注销，就要把InitialState里已存在的用户信息清空掉**

我们ctrl点击AvatarDropdown里的`loginOut`方法：

![image-20240526213210917](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213210917.png)

再ctrl点击outLogin，这里对应我们后端的接口调用：

![image-20240525180814062](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240525180814.png)

修改以下路径，修改为`/api/user/logout`：

![image-20240525180920410](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240525180921.png)

可以去测试一下，是否成功。用户退出了登录，状态码200，返回1即成功。

# 项目优化

## 补充星球编号

> 之前我们用户注册的时候，只让用户填了账号密码，我们现在要补充一些逻辑来校验这个用户 必须是星球里的用户，虽然说某种原因，这个星球用户的数据没办法获取到。 
>
> ​	可以先让用户自己来，后期我们再编写一个脚本什么的，输入所有已加入星球的用户列表，然 后让服务器去做一次校验，把不符合要求的用户全部封掉就可以了。

### 后端开发

在数据库表中添加一个字段`planetCode`，生成代码后做相关修改。

在用户脱敏里补充星球编号，我们要把星球编号返回出去

![image-20240526213258441](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213258441.png)

给注册请求体再补充一个星球编号的参数

![image-20240525182649042](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240525182649.png)

在控制层的注册接口补充一个校验和参数

![image-20240526213304011](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213304011.png)

在service和实现层补充一下这个字段。

补充对用户星球编号的校验，不能为空，不能大于5

![image-20240526213314350](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213314350.png)

还要校验星球编号不能重复

![image-20240525183239900](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240525183240.png)

再增加一个插入的数据

![image-20240526213321393](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213321393.png)

测试类代码userRegister添加一个参数：

![image-20240525183731012](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240525183732.png)

> 但是上面这种写法不是特别好，如果说参数比较多的情况下，更推荐把这些对象封装到一起，这样 就不用每次多加一个参数，把所有调用他的地方都要改一遍；当然这样也有好处，就是你新加参数 之后，可以有意识的去修改之前的逻辑，实际工作中，两种方法都可以。

### 前端开发

前端补充一个输入框，找一下用户注册的文件，复制账号框，修改一下：

![image-20240526213327392](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213327392.png)

![image-20240526213331431](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213331431.png)

再修改一下前端传递给后端的请求，ctrl点击RegisterParams，在参数列表补充一个planetCode：

![image-20240525184616898](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240525184617.png)

ctrl点击register，再点击CurrentUser，补充星球编号：

![image-20240525184746240](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240525184747.png)

![image-20240526213342061](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213342061.png)

![image-20240526213348572](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240526213348572.png)

再在管理页面增加一列星球编号：

![image-20240525185017956](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-img20240525185018.png)

修改完毕，接下来可以测试一下。

## 后端代码优化

### 通用返回对象

为什么要做通用返回对象？

目的：给对象补充一些信息，告诉前端这个请求在业务层面上是成功还是失败。

> ​	后端直接返回一个对象给前端，如果 这个数据出问题了、后端处理报错了、查不到用户，前端如果不可以区分的话，也不知道它到底为什么报错。
>
> ​	比如说一个测试，它返回了一个有六项的列表，假如后台返回一个空数组，前端可能也不会意识到它是错误的，如果说后台因为一些异常，我们强制给他返回空数组，但前端可能不知道对不对，他还以为这个只是一个本来就是数据库里没有用户的一个值。
>
> ​	所以我们需要定义一个通用的返回对象。

在userCenter下新建common包

> **无论你之后有什么对象，可能都要用到这个里面的一些方法，在这个项目仓库里公用的一些类**

在common包下新建BaseResponse.java（基本返回），写入以下内容：

![image-20240527170807750](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527170807750.png)

在common包下创建一个工具类ResultUtil，写入以下内容：

![image-20240527171225432](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527171225432.png)

试用一下，把之前所有请求都用BaseResponse封装一下，比如用户注册返回的是一个类型，现在把它改一下（状态码0，表示成功）

![image-20240527171506471](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527171506471.png)

登录接口也改一下：

![image-20240527171611134](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527171611134.png)

退出登录：

![image-20240527171711707](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527171711707.png)

其他的也一样修改

![image-20240527171854539](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527171854539.png)

下面报错我暂时先修改为 `return ResultUtils.success(new ArrayList<>()); `，后面会修改的。

![image-20240527172104358](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527172104358.png)

![image-20240527172201243](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527172201243.png)

### 自定义错误码

> ​	有任何错误，我们都直接返回-1，其实它的意义不是特别好，前端不知道 -1 是什么，后端可能也不知道 -1 代表什么
>
> ​	所以说我们要定义一个通用的错误码，我们要定义一套错误码的规范。

我们写一个枚举类，在common包下创建ErrorCode.java

![image-20240527172945530](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527172945530.png)

修改BaseResponse：

![image-20240527173238880](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527173238880.png)

完善ResultUtils

![image-20240527173427604](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527173427604.png)

回到UserController修改返回

![image-20240527173546807](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527173546807.png)

> ​	我们有很多需要修改成这样，这样写其实也不太优雅，提示也很别扭，而且我们每次好像都要 去调用这个错误返回类，接下来我们就封装全局异常处理，就是我们能不能把所有的错误都在一个 地方去处理。

### 封装全局异常处理

先定义全局异常，在usercenter包下创建一个exception包，在exception包下创建BusinessException.java，写入以下内容：

![image-20240527233833365](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527233833365.png)

回到UserController.java，刚刚写register，返回写成这样

![image-20240527233930401](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527233930401.png)

然后把controller的方法修改一下返回值：

![image-20240527234047106](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527234047106.png)

![image-20240527234140686](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527234140686.png)

![image-20240527234208095](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527234208095.png)

![image-20240527234239730](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527234239730.png)

![image-20240527234327786](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527234327786.png)

![image-20240527234352864](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527234352864.png)

同理，修改UserServiceImpl里的返回代码，还有很多，可以自己增加状态码，自己修改提示：

![image-20240527234638944](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527234638944.png)

![image-20240527234821837](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527234821837.png)

此时我们去前端注册，但是依然会抛出500的状态码，HTTP状态码本身就是500，没有抛出我们自己定义的状态码，所以我们需要全局异常处理器。

> **简单介绍**：全局异常处理器的作用：捕获代码中所有的异常集中处理。

在exception包下去定义一个`GlobalExceptionHandler`，再去ErrorCode添加一个系统内部异常的状态码：

![image-20240527235236819](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527235236819.png)

再去ResultUtils工具类中再写三个构造函数：

![image-20240527235532650](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527235532650.png)

在GlobalExceptionHandler中写下以下内容：

![image-20240527235806644](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240527235806644.png)

这样，我们就可以到前端测试注册失败是否会返回40000。

## 前端代码优化

### 全局请求响应拦截器

对接后端返回值，取data

在前端定义通用返回对象：

![image-20240923222138273](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240923222138273.png)

修改一下注册逻辑

![image-20240923222619413](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240923222619413.png)

给register的响应类型封装一下

![image-20240923222717255](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240923222717255.png)

验证一下注册按钮，提示星球编号过长，因为后端返回的description是星球编号过长

> 前端和后端做适配

适配后端，把API全改了，改成：

![image-20240923223744841](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240923223744841.png)

![image-20240923223808853](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240923223808853.png)

ctrl+点击request，写一个全局响应拦截器：

![image-20240923224200933](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240923224200933.png)

这里没有生效，因为这是.umi文件夹中的文件，之后我们封装自己的请求类，不用.umi自带的request方法。

把Register包下的index.tsx代码修改为：

![image-20240923225008686](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240923225008686.png)

我们可以在.gitignore添加上.umi，让编辑器帮我们识别出来，它就说项目自动生成的文件

![image-20240923225125481](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240923225125481.png)

现在写一个请求类，覆盖默认的request方法，在src文件夹下新建一个plugins文件夹，在plugins文件夹新建globalRequest.ts，复制代码https://blog.csdn.net/huantai3334/article/details/116780020到文件里：

````ts
/**
 * request 网络请求工具
 * 更详细的 api 文档: https://github.com/umijs/umi-request
 */
import {extend} from 'umi-request';
import {notification} from 'antd';
import {history} from 'umi';
import {getAccessToken, clearTokens} from './token'
import stringUtil from '@/utils/stringUtil'


const codeMessage = {
  200: '服务器成功返回请求的数据。',
  201: '新建或修改数据成功。',
  202: '一个请求已经进入后台排队（异步任务）。',
  204: '删除数据成功。',
  400: '发出的请求有错误，服务器没有进行新建或修改数据的操作。',
  401: '用户没有权限（令牌、用户名、密码错误）。',
  403: '用户得到授权，但是访问是被禁止的。',
  404: '发出的请求针对的是不存在的记录，服务器没有进行操作。',
  406: '请求的格式不可得。',
  410: '请求的资源被永久删除，且不会再得到的。',
  422: '当创建一个对象时，发生一个验证错误。',
  500: '服务器发生错误，请检查服务器。',
  502: '网关错误。',
  503: '服务不可用，服务器暂时过载或维护。',
  504: '网关超时。',
};

/**
 * 异常处理程序
 */
const errorHandler = (error: { response: Response }): Response => {
  const {response} = error;
  if (response && response.status) {
    const errorText = codeMessage[response.status] || response.statusText;
    const {status, url} = response;
    // console.log(status)
    // 处理参数问题
    let noParamUrl = url;
    if (url.indexOf('?') !== -1) {
      noParamUrl = url.substring(0, url.indexOf('?'));
    }

    if (url.indexOf('/system/oauth/token') !== -1) {
      notification.error({
        message: `请求错误 [20002]: ${noParamUrl}`,
        description: '账号不存在或密码错误',
      });
      return response;
    }
    if (status === 401) {
      notification.warn({
        message: '请重新登陆!',
      });
      clearTokens();
      history.push('/user/login');
    } else {
      notification.error({
        message: `请求错误 [${status}]: ${noParamUrl}`,
        description: errorText,
      });
    }
  } else if (!response) {
    notification.error({
      description: '您的网络发生异常，无法连接服务器',
      message: '网络异常',
    });
  }
  return response;
};

/**
 * 配置request请求时的默认参数
 */
const request = extend({
  errorHandler, // 默认错误处理
  credentials: 'include', // 默认请求是否带上cookie
  // requestType: 'form',
});

/**
 * 所以请求拦截器
 */
request.interceptors.request.use((url, options): any => {
  return {
    url,
    options: {
      ...options,
      headers: {
        Authorization: getAccessToken(),
      },
    },
  };
});

/**
 * 所有响应拦截器
 */
request.interceptors.response.use(async (response, options): Promise<any> => {

  const {url, status} = response;
  if (url.indexOf('/system/oauth/token') !== -1) {
    return response;
  }
  // 返回下载流的问题,可以在url添加标识
  if (url.indexOf('/download/') !== -1) {
    if (status !== 200) {
      notification.error({
        message: `下载出错 : ${url}`,
      });
    } else {
      return await response.clone().blob();
    }
    return null;
  }

  const data = await response.clone().json();
  // console.log(data)
  if ((status === 200 && data.code !== 1) || (status !== 200 && data.data !== undefined)) {
    // 处理参数问题
    let noParamUrl = url;
    if (url.indexOf('?') !== -1) {
      noParamUrl = url.substring(0, url.indexOf('?'));
    }
    const msg = (data.data === null || stringUtil.isEmpty(data?.data?.exceptionMsg)) ? data.msg : data.data.exceptionMsg;
    notification.error({
      message: `请求出错 [${data.code}]: ${noParamUrl}`,
      description: msg,
    });
  }
  return response;
});

export default request;

````

删掉不需要的代码，只留下：

```ts
/**
 * request 网络请求工具
 * 更详细的 api 文档: https://github.com/umijs/umi-request
 */
import {extend} from 'umi-request';




/**
 * 配置request请求时的默认参数
 */
const request = extend({
  credentials: 'include', // 默认请求是否带上cookie
  // requestType: 'form',
});

/**
 * 所以请求拦截器
 */
request.interceptors.request.use((url, options): any => {
  return {
    url,
    options: {
      ...options,
      headers: {

      },
    },
  };
});

/**
 * 所有响应拦截器
 */
request.interceptors.response.use(async (response, options): Promise<any> => {
  const data = await response.clone().json();
  return response;
});

export default request;
```

定义请求拦截器，比如说，我们可以在每次发请求的时候，console.log一下

![image-20240923230757378](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240923230757378.png)

前端请求接收到一个响应之后，我们先获取到这个相应的data值，然后从这个data值中判断一下

![image-20240923231057932](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240923231057932.png)

在api.ts文件里引入我们自己写的

![image-20240923231224228](https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240923231224228.png)

测试一下，注册会抛出40100码吗？

测试没登录之前访问管理页面会返回40100码吗？

如果可以，那就OK了。
