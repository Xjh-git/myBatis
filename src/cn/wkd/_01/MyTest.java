package cn.wkd._01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * @author 许佳华
 * @Description: 测试mybatis环境的第一种方式
 * @date 2020/3/11 10:14
 */
public class MyTest {

    @Test
    public void test() throws IOException {
        //mybatis 全局配置文件路径
        String resource = "mybatis.xml";
        //加载配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        //从SqlSessionFactory中获取SqlSession
        SqlSession session = sqlMapper.openSession();
        try {
            //执行sql
            //selectOne 执行单查询 selectOne("sql语句的路径",参数)
            //路径 sql映射文件的namespace.调用sql的id
            User user = (User) session.selectOne("org.mybatis.example.BlogMapper.selectUser", 4);
            System.out.println(user);
        } finally {
            session.close();
        }
    }
}
