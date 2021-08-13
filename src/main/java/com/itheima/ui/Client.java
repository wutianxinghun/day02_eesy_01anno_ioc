package com.itheima.ui;
import com.itheima.dao.IAccountDao;
import com.itheima.srvice.IAccountService;
import com.itheima.srvice.impl.AccountServieceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取对象
        IAccountService as= (IAccountService) ac.getBean("accountServiece");
//        IAccountService as2= (IAccountService) ac.getBean("accountServiece");
//        System.out.println(as);
//        IAccountDao adao=ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(adao);
        as.saveAccount();
        ac.close();
//        System.out.println(as==as2);
    }
}
