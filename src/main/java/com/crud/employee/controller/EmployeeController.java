package com.crud.employee.controller;

import com.crud.employee.entity.Employee;
import com.crud.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    public EmployeeService service;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAll(){
       return ResponseEntity.ok().body(service.listEmployee());
    }
    @GetMapping("/one/{id}")

    public ResponseEntity<Employee> getOne(@PathVariable Long id){
        return ResponseEntity.ok().body(service.listById(id));
    }
    @PostMapping("/save")
    public  ResponseEntity<Employee> saveOne(@RequestBody Employee employee){
        return ResponseEntity.ok().body(service.addEmployee(employee));
    }
    @PutMapping
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        return ResponseEntity.ok().body(service.updateEmployee(employee));
    }

    @DeleteMapping("/delete/{id}")

    public HttpStatus remove(@PathVariable Long id){
        service.deleteEmployee(id);
        return HttpStatus.OK;
    }

}
