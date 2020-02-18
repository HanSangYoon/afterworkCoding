package com.example.restapi.demo;

public class Employee {

    public Employee(){
        //Constructor
    }

    public Employee(Integer id, String firstName, String lastName, String email){
        //super(); //super() 는 부모의 생성자를 의미함.

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    //getter & setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "Employee [id = " + id + ", first name = " + firstName + ", last name = " + lastName + ", email = " + email + "]";
    }
}
