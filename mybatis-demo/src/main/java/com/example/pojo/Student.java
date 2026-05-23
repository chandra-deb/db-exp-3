package com.example.pojo;

import java.sql.Date;

public class Student {
    private int sid;
    private String sname;
    private String sgender;
    private String smajor;
    private Date sbirthday;
    private double screditPoints;

    public Student() {}

    public Student(String sname, String sgender, String smajor, Date sbirthday, double screditPoints) {
        this.sname = sname;
        this.sgender = sgender;
        this.smajor = smajor;
        this.sbirthday = sbirthday;
        this.screditPoints = screditPoints;
    }

    public int getSid() { return sid; }
    public void setSid(int sid) { this.sid = sid; }
    public String getSname() { return sname; }
    public void setSname(String sname) { this.sname = sname; }
    public String getSgender() { return sgender; }
    public void setSgender(String sgender) { this.sgender = sgender; }
    public String getSmajor() { return smajor; }
    public void setSmajor(String smajor) { this.smajor = smajor; }
    public Date getSbirthday() { return sbirthday; }
    public void setSbirthday(Date sbirthday) { this.sbirthday = sbirthday; }
    public double getScreditPoints() { return screditPoints; }
    public void setScreditPoints(double screditPoints) { this.screditPoints = screditPoints; }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sgender='" + sgender + '\'' +
                ", smajor='" + smajor + '\'' +
                ", sbirthday=" + sbirthday +
                ", screditPoints=" + screditPoints +
                '}';
    }
}
