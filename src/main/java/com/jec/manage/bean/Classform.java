package com.jec.manage.bean;

import java.io.Serializable;

public class Classform implements Serializable {
    private Integer id;

    private String classid;

    private String teachername;

    private String teacherid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", classid=").append(classid);
        sb.append(", teachername=").append(teachername);
        sb.append(", teacherid=").append(teacherid);
        sb.append("]");
        return sb.toString();
    }
}