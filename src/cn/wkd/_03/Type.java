package cn.wkd._03;

/**
 * @author 许佳华
 * @Description: 雇员的种类
 * @date 2020/3/11 18:44
 */
public class Type {
    int id;
    String typeName;

    public Type() {
    }

    public Type(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
