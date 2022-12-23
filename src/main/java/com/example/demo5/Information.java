package com.example.demo5;

import javafx.scene.control.Toggle;

public class Information {
    private String Name;
    private String Fname;
    private int grade;
    private Toggle gender;
    private String school;
    private Toggle fee;

    @Override
    public String toString() {
        return "Information{" +
                "Name='" + Name + '\'' +
                ", Fname='" + Fname + '\'' +
                ", grade=" + grade +
                ", gender=" + gender +
                ", school='" + school + '\'' +
                ", fee=" + fee +
                '}';
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Toggle getFee() {
        return fee;
    }

    public void setFee(Toggle fee) {
        this.fee = fee;
    }

    public Information(String name, String fname, int Grade, Toggle gender, String school, Toggle fee) {
        Name = name;
        Fname = fname;
        grade = Grade;
        this.gender = gender;
        this.school = school;
        this.fee = fee;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Toggle getGender() {
        return gender;
    }

    public void setGender(Toggle gender) {
        this.gender = gender;
    }
}
