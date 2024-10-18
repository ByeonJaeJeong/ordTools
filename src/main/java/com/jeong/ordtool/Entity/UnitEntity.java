package com.jeong.ordtool.Entity;

public class UnitEntity {

    private String name;
    private String grade;
    private String en;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    @Override
    public String toString() {
        return "UnitEntity{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", en='" + en + '\'' +
                '}';
    }
}
