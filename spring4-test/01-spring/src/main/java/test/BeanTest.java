package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @version  1.0
 */
public class BeanTest {
    public static void main(String[] args)throws Exception {
        // 创建Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        // 获取id为person的Bean
        Person p = ctx.getBean("person" , Person.class);

        // 调用useAxe()方法
        p.useAxe();
    }
}