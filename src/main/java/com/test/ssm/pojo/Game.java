package com.test.ssm.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Game {
    private Integer id;
    private String name;
    private Integer status;
    private String downloadUrl;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    public Game() {
    }

    public Game(Integer id, String name, int status, String downloadUrl, Date createdDate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.downloadUrl = downloadUrl;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
