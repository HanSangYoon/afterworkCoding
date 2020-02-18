package com.example.restapi.demo;

import org.springframework.stereotype.Repository;

//import com.example.restapi.demo.Employee;
//import com.example.restapi.demo.Employeesss;

@Repository
public class EmployeeDAO {

    private static Employeesss list = new Employeesss();

    static{
        list.getEmployeeList().add(new Employee(1, "syhan01", "han01", "microscope83-01@naver.com"));
        list.getEmployeeList().add(new Employee(2, "syhan02", "han02", "microscope83-02@naver.com"));
        list.getEmployeeList().add(new Employee(3, "syhan03", "han03", "microscope83-03@naver.com"));
        list.getEmployeeList().add(new Employee(4, "syhan04", "han04", "microscope83-04@naver.com"));
        list.getEmployeeList().add(new Employee(5, "syhan05", "han05", "microscope83-05@naver.com"));
    }

    public Employeesss getAllEmployees(){
        return list;
    }

    public void addEmployee(Employee employee){
        list.getEmployeeList().add(employee);
    }
}
