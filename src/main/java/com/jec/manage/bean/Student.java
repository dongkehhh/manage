package com.jec.manage.bean;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private Integer id;

    private String name;

    private Integer learntime;

    public Integer getLearntime() {
        return learntime;
    }

    public void setLearntime(Integer learntime) {
        this.learntime = learntime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private String classId;

    private String teachername;

    private Date opendate;

    private static final long serialVersionUID = 1L;

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



    public String getClassid() {
        return classId;
    }

    public void setClassid(String classid) {
        this.classId = classid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public Date getOpendate() {
        return opendate;
    }

    public void setOpendate(Date opendate) {
        this.opendate = opendate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", learntime=").append(learntime);
        sb.append(", classid=").append(classId);
        sb.append(", teachername=").append(teachername);
        sb.append(", opendate=").append(opendate);
        sb.append("]");
        return sb.toString();
    }
}