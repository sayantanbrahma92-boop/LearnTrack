package com.airtribe.learntrack.entity;

/**
 * Base class to demonstrate inheritance.
 * Represents common properties of a person.
 */


public class Person{
    private Long id;
    private String firstname;
    private String lastname;
    private String email;

    // ========== Constructors ==========
    public Person() {

    }

    public Person(Long id, String firstname, String lastname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;

    }

    // ========== Getters & Setters ==========

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    // ========== display Info ==========
    public String getdisplayName() {
        return firstname+" "+lastname;
    }
}

