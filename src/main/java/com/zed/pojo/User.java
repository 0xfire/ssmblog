package com.zed.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.List;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-05-19 20:57:26
 */
public class User implements Serializable {
    private static final long serialVersionUID = -93422234172837647L;
    
    private String id;
    
    private String name;
    
    private String password;
    
    private String gender;
    
    private String hobby;

    @DateTimeFormat(pattern="yyyy-MM-dd")   // 一定大小写，注意这样的格式转换，可以把前端的字符串时间转换为Date对象，但是一定要求前端页面传递"2018-06-06"格式，如果传递的是"2018-6-6"格式将抛出错误
    @JsonFormat(pattern="yyyy-MM-dd")      //  一定大小写，返回json数据，默认返回时间戳，通过JsonFormat转换格式
    private String regDate;
    
    private String userInfo;
    
    private String avatar;
    
    private String homeAddress;
    
    private String workAddress;

    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", hobby='" + hobby + '\'' +
                ", regDate='" + regDate + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", avatar='" + avatar + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", workAddress='" + workAddress + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}