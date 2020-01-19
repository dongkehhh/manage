package com.jec.manage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Logs implements Serializable {
    private Integer id;

    private String username;

    private String operation;

    private String params;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createdtime;

    private String atmtype;

    private Integer typeone;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public String getAtmtype() {
        return atmtype;
    }

    public void setAtmtype(String atmtype) {
        this.atmtype = atmtype;
    }

    public Integer getTypeone() {
        return typeone;
    }

    public void setTypeone(Integer typeone) {
        this.typeone = typeone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", operation=").append(operation);
        sb.append(", params=").append(params);
        sb.append(", createdtime=").append(createdtime);
        sb.append(", atmtype=").append(atmtype);
        sb.append(", typeone=").append(typeone);
        sb.append("]");
        return sb.toString();
    }
}