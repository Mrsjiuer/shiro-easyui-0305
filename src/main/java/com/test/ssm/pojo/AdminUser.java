package com.test.ssm.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AdminUser {
    private Integer id;
    private String password;
    private String email;
    private String realName;
    private Integer status;
    private Integer isAdmin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date limitedDate;

    public AdminUser() {
    }

    public AdminUser(Integer id, String password, String email, String realName, Integer status, Integer isAdmin, Date limitedDate) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.realName = realName;
        this.status = status;
        this.isAdmin = isAdmin;
        this.limitedDate = limitedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getLimitedDate() {
        return limitedDate;
    }

    public void setLimitedDate(Date limitedDate) {
        this.limitedDate = limitedDate;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", realName='" + realName + '\'' +
                ", status=" + status +
                ", isAdmin=" + isAdmin +
                ", limitedDate=" + limitedDate +
                '}';
    }
}
