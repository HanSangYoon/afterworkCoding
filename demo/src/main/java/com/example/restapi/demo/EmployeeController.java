package com.example.restapi.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/** @RestController
 *     It detects spring-webmvc so configure default spring mvc application beans. It help in scan and configure @RestController and similar annotations.
 *     It detects embed tomcat jars so configure embedded tomcat for us.
 *     It detects JSON jars so configure JSON support to APIs.
 */
@RestController
@RequestMapping(path="/employeessss")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    @GetMapping(path="/", produces = "application/json")
    public Employeesss getEmployees(){
        return employeeDao.getAllEmployees();
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmp(@RequestBody Employee employee) {
        Integer eid = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
        employee.setId(eid);

        employeeDao.addEmployee(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{eid}").buildAndExpand(employee.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
