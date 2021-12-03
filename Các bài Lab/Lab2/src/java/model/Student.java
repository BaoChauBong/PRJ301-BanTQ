/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author ADMIN
 */
public class Student {

    int id;
    String name;
    Boolean gender;
    Date dob;

    public Student(int id, String name, Boolean gender, Date dob) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getGender() {
        return gender;
    }

    public Date getDob() {
        return dob;
    }

    public String getDobFormat() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(dob);
    }

}
