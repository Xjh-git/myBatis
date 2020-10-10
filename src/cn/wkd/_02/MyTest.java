package cn.wkd._02;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 许佳华
 * @Description: 测试mybatis环境的第二种方式
 * @date 2020/3/11 10:14
 */
public class MyTest {

    /**
     * 环境搭建测试，单查询
     *
     * @throws IOException
     */
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
            //            User user = (User) session.selectOne("org.mybatis.example.BlogMapper.selectUser", 4);
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            User user = userDAO.queryUserById(6);
            System.out.println(user);
        } finally {
            session.close();
        }
    }

    /**
     * 插入案例
     *
     * @throws IOException
     */
    @Test
    public void testAddUser() throws IOException {
        //mybatis 全局配置文件路径
        String resource = "mybatis.xml";
        //加载配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        //从SqlSessionFactory中获取SqlSession
        //        SqlSession session = sqlMapper.openSession();
        //true 表示自动提交事务
        SqlSession session = sqlMapper.openSession(true);
        try {
            //执行sql
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            User user = new User();
            user.setUsername("赵云");
            user.setPassword("abcd");
            userDAO.addUser(user);
            //手动获取的session，需要手动提交事务
            //            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * 删除案例
     *
     * @throws IOException
     */
    @Test
    public void testDeleteUser() throws IOException {
        //mybatis 全局配置文件路径
        String resource = "mybatis.xml";
        //加载配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        //从SqlSessionFactory中获取SqlSession
        //        SqlSession session = sqlMapper.openSession();
        //true 表示自动提交事务
        SqlSession session = sqlMapper.openSession(true);
        try {
            //执行sql
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            userDAO.deleteUserById(14);
        } finally {
            session.close();
        }
    }

    /**
     * 全查询案例
     *
     * @throws IOException
     */
    @Test
    public void testQueryAllUser() throws IOException {
        //mybatis 全局配置文件路径
        String resource = "mybatis.xml";
        //加载配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        //从SqlSessionFactory中获取SqlSession
        //        SqlSession session = sqlMapper.openSession();
        //true 表示自动提交事务
        SqlSession session = sqlMapper.openSession(true);
        try {
            //执行sql
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            List<User> users = userDAO.queryAllUser();
            for (User user : users) {
                System.out.println(user);
            }
        } finally {
            session.close();
        }
    }

    /**
     * 更新案例
     *
     * @throws IOException
     */
    @Test
    public void testUpdateUser() throws IOException {
        //mybatis 全局配置文件路径
        String resource = "mybatis.xml";
        //加载配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        //从SqlSessionFactory中获取SqlSession
        //        SqlSession session = sqlMapper.openSession();
        //true 表示自动提交事务
        SqlSession session = sqlMapper.openSession(true);
        try {
            //执行sql
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            User user = new User();
            user.setId(15);
            user.setUsername("刘皇叔");
            user.setPassword("1234");
            userDAO.updateUser(user);
        } finally {
            session.close();
        }
    }

    /**
     * 多参数处理案例
     *
     * @throws IOException
     */
    @Test
    public void testParams() throws IOException {
        //1.mybatis全局配置文件的路径
        String resource = "mybatis.xml";
        //2.加载配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //3.创建SqlSessionFactory
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);//快捷健：Ctrl+1
        //*****************************从 SqlSessionFactory 中获取 SqlSession
        //4.从SqlSessionFactory获取一个SqlSession
        SqlSession session = sqlMapper.openSession(true);//trueb表示自动提交事务
        try {
            //5.执行sql
            IUserDAO userDao = session.getMapper(IUserDAO.class);
            //方式一：直接传参
            //			User user = userDao.queryUserByUP("赵云", "qwer");

            Map<String, Object> map = new HashMap<>();
            map.put("name", "刘皇叔");
            map.put("pwd", "1234");
            List<User> queryUserByMap = userDao.queryUserByMap(map);
            System.out.println(queryUserByMap);
        } finally {
            session.close();
        }
    }

    /**
     * 动态sql（if）案例
     *
     * @throws IOException
     */
    @Test
    public void testQueryUserByParams() throws IOException {
        //1.mybatis全局配置文件的路径
        String resource = "mybatis.xml";
        //2.加载配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //3.创建SqlSessionFactory
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);//快捷健：Ctrl+1
        //*****************************从 SqlSessionFactory 中获取 SqlSession
        //4.从SqlSessionFactory获取一个SqlSession
        SqlSession session = sqlMapper.openSession(true);//trueb表示自动提交事务
        try {
            //5.执行sql
            IUserDAO userDao = session.getMapper(IUserDAO.class);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("username", "刘皇叔");
            //            map.put("password", "1234");

            List<User> queryUserByParams = userDao.queryUserByParams(map);
            System.out.println(queryUserByParams);
        } finally {
            session.close();
        }
    }

    /**
     * 批量删除user案例
     *
     * @throws IOException
     */
    @Test
    public void testDeleteBatch() throws IOException {
        //1.mybatis全局配置文件的路径
        String resource = "mybatis.xml";
        //2.加载配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //3.创建SqlSessionFactory
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);//快捷健：Ctrl+1
        //*****************************从 SqlSessionFactory 中获取 SqlSession
        //4.从SqlSessionFactory获取一个SqlSession
        SqlSession session = sqlMapper.openSession(true);//trueb表示自动提交事务
        try {
            //5.执行sql
            IUserDAO userDao = session.getMapper(IUserDAO.class);
            List<Integer> ids = new ArrayList<>();
            ids.add(4);
            ids.add(6);
            ids.add(13);
            userDao.deleteBatch(ids);
        } finally {
            session.close();
        }
    }

    /**
     * 批量插入user的测试案例
     *
     * @throws IOException
     */
    @Test
    public void testAddUserBatch() throws IOException {
        //1.mybatis全局配置文件的路径
        String resource = "mybatis.xml";
        //2.加载配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //3.创建SqlSessionFactory
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);//快捷健：Ctrl+1
        //*****************************从 SqlSessionFactory 中获取 SqlSession
        //4.从SqlSessionFactory获取一个SqlSession
        SqlSession session = sqlMapper.openSession(true);//trueb表示自动提交事务
        try {
            //5.执行sql
            IUserDAO userDao = session.getMapper(IUserDAO.class);
            List<User> users = new ArrayList<>();
            users.add(new User("张三", "1234"));
            users.add(new User("李四", "abcd"));
            users.add(new User("王五", "qwer"));
            users.add(new User("赵六", "zxcv"));
            userDao.addUserBatch(users);
        } finally {
            session.close();
        }
    }
}
