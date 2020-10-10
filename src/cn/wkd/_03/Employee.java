package cn.wkd._03;

/**
 * @author 许佳华
 * @Description: 模板，雇员类
 * @date 2020/3/11 18:43
 */
public class Employee {
    int id,category_id;
    String name;
    double salary;

    Type type;

    public Employee() {
    }

    public Employee(int category_id, String name, double salary, Type type) {
        this.category_id = category_id;
        this.name = name;
        this.salary = salary;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", category_id=" + category_id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", type=" + type +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Employee(int id, int category_id, String name, double salary, Type type) {
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.salary = salary;
        this.type = type;
    }
}
