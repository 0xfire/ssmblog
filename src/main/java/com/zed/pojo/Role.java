package com.zed.pojo;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2020-05-22 17:44:29
 */
public class Role implements Serializable {
    private static final long serialVersionUID = -82099570467559242L;
    
    private String user;
    
    private String role;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}