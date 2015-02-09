package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @version  1.0
 */
public class NewsManager {
    public static void main(String[] args) throws Exception {

        // 实例化Configuration，
        // 不带参数的configure()方法默认加载hibernate.cfg.xml文件，
        // 如果传入abc.xml作为参数，则不再加载hibernate.cfg.xml，改为加载abc.xml
        Configuration conf = new Configuration().configure();

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

        // 以Configuration实例创建SessionFactory实例
        SessionFactory sf = conf.buildSessionFactory(registry);

        // 创建Session
        Session session = sf.openSession();

        // 开始事务
        Transaction transaction = session.beginTransaction();

        // 创建消息对象
        News n = new News();
        // 设置消息标题和消息内容
        n.setTitle("疯狂Java联盟成立了");
        n.setContent("疯狂Java联盟成立了，网站地址http://www.crazyit.org");

        // 保存消息
        session.save(n);

        // 提交事务
        transaction.commit();

        // 关闭Session
        session.close();

        sf.close();

    }
}
