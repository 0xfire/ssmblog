package com.zed.pojo;

import java.io.Serializable;

/**
 * (Address)实体类
 *
 * @author makejava
 * @since 2020-05-19 20:57:04
 */
public class Address implements Serializable {
    private static final long serialVersionUID = 165474156051404516L;
    
    private String id;
    
    private String type;
    
    private String userAddress;
    
    private String userId;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userId='" + userId + '\'' +
                ", user=" + user +
                '}';
    }
}