package cn.wycclub.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 表单提交的数据封装类
 *
 * @author WuYuchen
 * @date 2017-10-27 17:24
 */

public class FormBean {
    private String username;
    private String password;
    private String repassword;
    private String email;
    private Map<String,String> error = new HashMap<String,String>();

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getError() {
        return this.error;
    }

    public boolean check() {
        boolean isOK = true;
        //检测账号合法性
        if (!(this.username.trim() == null || this.username.trim() == "")) {
            if (!this.username.matches("[a-zA-Z0-9]{5,10}")) {
                isOK = false;
                this.error.put("username","用户名不合法!");
            }
        } else {
            isOK = false;
            this.error.put("username","用户名不能为空!");
        }

        //检测密码合法性
        if (!(this.password.trim() == null || this.password.trim() == "")) {
            if (!this.password.matches("[a-zA-Z\\d]{6,18}")) {
                isOK = false;
                this.error.put("password","密码不合法");
            } else if (!this.password.equals(this.repassword)) {
                isOK = false;
                this.error.put("repassword","两次输入的密码不相同!");
            }
        } else {
            isOK = false;
            this.error.put("password","密码不能为空!");
        }

        //检测邮箱合法性
        if (!(this.email == null || this.email == "")) {
            if (!(this.email.matches("(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})"))) {
                isOK = false;
                this.error.put("email","邮箱格式不合法!");
            }
        } else {
            isOK = false;
            this.error.put("email","邮箱不能为空!");
        }

        return isOK;
    }
}
