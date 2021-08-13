package com.itheima.srvice.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.srvice.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 *
 * 曾经XML的配置
 *  <bean id="accountService" class="com.itheima.srvice.impl.AccountServieceImpl"
 *          scope="" init-method="" destory-method="" >
 *      <property name="" value="" /ref=""></property>
 *  </bean>
 *
 * 用于创建对象的注解
 *      他们的作用就和在XML配置文件中编写一个<bean>标签实现的功能是一样的
 *      @Component:
 *          作用：用于把当前类对象存入spring容器中。
 *          属性：
 *              value:用于把当前类对象存入spring容器中。当我们不写时，它默认值时当前类名，且首字母改小写。
 *      @Controller：一般用于表现层
 *      @Serviece：一般用于业务层
 *      @Repository:一般用于持久层。
 *          以上三个注解和Component一模一样。他们三个是spring框架为我们提供明确的三层使用注解，使我们的三层对象更加清晰。
 * 用于注入数据的
 *      他们的作用就和在XML配置文件中的<bean>标签中写一个<property>标签是一样的。
 *      Autowired:
 *          作用：自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功。
 *               如果ioc容器中没有任何bean的类型喝要注入的变量类型匹配，则报错。
 *          出现位置：
 *              可以使变量上，也可以是方法上。
 *      Qualifier（和Autowired组合使用，不能单独使用）
 *          作用：在按照类中注入的基础之上在按照名称注入。它在给类成员注入式 不能单独使用你。但是再给方法参数注入式可以
 *          属性：
 *              value:用于指定注入bean的id。
 *      Resource
 *          作用：直接按照bean的id注入。。它可以独立使用
 *          属性：
 *              name：用于指定bean的id。
 *  以上三个注入都只能注入其他bean类型的数值，而基本类型和string类型无法使用上述注解实现。
 *
 *      Value:
 *          作用：用于注入基本类型和String类型的数据。
 *          属性：
 *              value：用于指定数据的值。它可以使用spring中的SpEL（也就是spring的el表达式）
 *              SpEL的写法，${表达式}
 *  另外，集合类型的注入只能通过XML来实现。
 * 用于改变作用范围的
 *      他们作用集合在<bean>标签中使用scope属性实现的功能是一样的。
 *      Scope
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围的取值。常用取值：singgleton prototyep
 * 和生命周期相关
 *      他们作用就和在<bean>标签中使用init-method和destory-method作用是一样的
 *      PreDestory
 *          用于指定销毁方法
 *      PostConstruct
 *          用于指定初始化方法
 */
@Component(value = "accountServiece")
//@Scope("prototype")
public class AccountServieceImpl implements IAccountService {
    @Autowired()
    @Qualifier("accountDao2")
//    @Resource(name="accountDao2")
    private IAccountDao accountDao;
    @PostConstruct
    public void init(){
        System.out.println("初始化方法执行了");
    }
    @PreDestroy
    public void destory(){
        System.out.println("销毁方法执行了");
    }
    public void saveAccount(){
        accountDao.saveAccount();
    }
}
