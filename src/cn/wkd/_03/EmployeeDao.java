package cn.wkd._03;

import java.util.List;

/**
 * @author 许佳华
 * @Description: 操作 emp 雇员表的接口
 * @date 2020/3/11 18:51
 */
public interface EmployeeDao {
    public Employee queryEmpById(int id);

    public List<Employee> queryEmpAndTypeById(int id);

}
