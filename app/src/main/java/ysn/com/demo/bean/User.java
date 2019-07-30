package ysn.com.demo.bean;

/**
 * @Author yangsanning
 * @ClassName User
 * @Description 一句话概括作用
 * @Date 2019/7/30
 * @History 2019/7/30 author: description:
 */
public class User {

    private String name;
    private String des;

    public User(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "姓名: " + name + " \n" + "简介: " + des;
    }
}
