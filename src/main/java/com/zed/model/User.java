package com.zed.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private String gender;
    private String hobby;
    private String regDate;
    private String userInfo;
    private String avatar;
    private String homeAddress;
    private String workAddress;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", hobby='" + hobby + '\'' +
                ", regDate='" + regDate + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", avatar='" + avatar + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", workAddress='" + workAddress + '\'' +
                '}';
    }
}
