package com.airtribe.learntrack.entity;

/**
 * Student entity extending Person.
 * Demonstrates inheritance, constructor overloading,
 * and method overriding.
 */

public class Student extends Person{
    private String batch;
    private boolean active;

    // ========== Constructors ==========
    public Student(){
        super();
        this.active=true;
    }

    // Parameterized constructor WITHOUT email
    public Student(Long id, String firstName, String lastName, String batch) {
        super(id, firstName, lastName, null);
        this.batch = batch;
        this.active = true;
    }

    // Parameterized constructor WITH email (default active = true)
    public Student(Long id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = true;
    }

    // ========== Getters & Setters ==========
    public String getBatch(){
        return batch;
    }

    public void setBatch(String batch){
        this.batch=batch;
    }

    public boolean getIsActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active=active;
    }

    // ========== Method Overriding ==========
    @Override
    public String getdisplayName(){
        return "Student: "+ getFirstname() +" "+ getLastname();
    }

    @Override
    public String toString() {
        return "Student {" +
                "id=" + getId() +
                ", name='" + getFirstname() + " " + getLastname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", batch='" + batch + '\'' +
                ", active=" + active +
                '}';
    }

}