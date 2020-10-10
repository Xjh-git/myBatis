package cn.wkd._03;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author 许佳华
 * @Description:
 * @date 2020/3/11 18:56
 */
public class MyTest {


    @Test
    public void test() throws IOException {
        //1.mybatis全局配置文件的路径
        String resource = "mybatis.xml";
        //2.加载配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //3.创建SqlSessionFactory
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);//快捷健：Ctrl+1
        //*****************************从 SqlSessionFactory 中获取 SqlSession
        //4.从SqlSessionFactory获取一个SqlSession
        SqlSession session = sqlMapper.openSession();
        try {
            //5.执行sql
            EmployeeDao employeeDao = session.getMapper(EmployeeDao.class);
            Employee employee = employeeDao.queryEmpById(3);
            System.out.println(employee);
        } finally {
            session.close();
        }
    }


    @Test
    public void test2() throws IOException {
        //1.mybatis全局配置文件的路径
        String resource = "mybatis.xml";
        //2.加载配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //3.创建SqlSessionFactory
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);//快捷健：Ctrl+1
        //*****************************从 SqlSessionFactory 中获取 SqlSession
        //4.从SqlSessionFactory获取一个SqlSession
        SqlSession session = sqlMapper.openSession();
        try {
            //5.执行sql
            EmployeeDao employeeDao = session.getMapper(EmployeeDao.class);
            List<Employee> employees = employeeDao.queryEmpAndTypeById(3);
            System.out.println(employees);
        } finally {
            session.close();
        }
    }

}
