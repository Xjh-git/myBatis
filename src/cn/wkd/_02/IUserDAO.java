package cn.wkd._02;

import java.util.List;
import java.util.Map;

/**
 * @author 许佳华
 * @Description: 提供对数据库操作的接口
 * @date 2020/3/11 11:07
 */
public interface IUserDAO {
    /**
     * 根据id查询user对象
     * @param id
     * @return user对象
     */
    public User queryUserById(int id);

    /**
     * 新增一个user
     * @param user
     */
    public void  addUser(User user);

    /**
     * 根据id删除一个user
     * @param id
     */
    public void deleteUserById(int id);

    /**
     * 查询所有的user
     * @return user集合
     */
    public List<User> queryAllUser();

    /**
     * 更新user
     * @param user
     */
    public void updateUser(User user);

    /**
     * 多参数处理   map
     * @param map
     * @return
     */
    public List<User> queryUserByMap(Map<String, Object> map);

    /**
     * 动态sql案例   if和where
     * @param map
     * @return
     */
    public List<User> queryUserByParams(Map< String, Object> map);

    /**
     * 批量删除user
     * @param ids
     */
    public void deleteBatch(List<Integer> ids);

    /**
     * 批量插入user
     * @param users
     */
    public void addUserBatch(List<User> users);
}
