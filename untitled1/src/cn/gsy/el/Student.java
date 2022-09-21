package cn.gsy.el;
/**
* @description: TODO
* @author 瑛
* @date 2022/9/21 15:57
* @version 1.0
*/

public class Student {
    private String name;
    private String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return name + ":" + mobile;
    }
}