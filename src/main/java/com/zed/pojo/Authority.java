package com.zed.pojo;

import java.io.Serializable;

/**
 * (Authority)实体类
 *
 * @author makejava
 * @since 2020-05-24 19:22:40
 */
public class Authority implements Serializable {
    private static final long serialVersionUID = -21266986972372239L;
    
    private String role;
    
    private String permissions;
    
    private String permissionsUrl;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getPermissionsUrl() {
        return permissionsUrl;
    }

    public void setPermissionsUrl(String permissionsUrl) {
        this.permissionsUrl = permissionsUrl;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "role='" + role + '\'' +
                ", permissions='" + permissions + '\'' +
                ", permissionsUrl='" + permissionsUrl + '\'' +
                '}';
    }
}