package com.crud.employee.service;

import com.crud.employee.entity.Employee;
import com.crud.employee.repository.EmployeeRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository repository;

    //1.  save employee
    public Employee addEmployee(Employee employee){
       return repository.save(employee);
    }
    //2.  list all employees
    public List<Employee> listEmployee(){
        return  repository.findAll();
    }

    //3.  listar por id

    public Employee  listById(Long id){

        Optional<Employee> findEmployee=repository.findById(id);

        if (findEmployee.isPresent()){
            return findEmployee.get();
        }
        throw new RuntimeException("O empregado com o ID:"+id+" nao existe");
    }
    //4.  actualizar um empregado
    public Employee updateEmployee(Employee employee){

        Optional<Employee> upEmploy=repository.findById(employee.getId());
        if (upEmploy.isPresent()){

            Employee updateEmploy=upEmploy.get();

            updateEmploy.setId(employee.getId());
            updateEmploy.setNome(employee.getNome());
            updateEmploy.setApelido(employee.getApelido());
            updateEmploy.setSalario(updateEmploy.getSalario());

            return repository.save(updateEmploy);

        }
        throw new RuntimeException("O empregado com o ID:"+employee.getId()+" nao existe");
    }

    //5.  Deletar um empregado
    public void deleteEmployee(Long id){

        Optional<Employee> existEmployee=repository.findById(id);

        if (existEmployee.isPresent()) {
             // existEmployee.get();
              repository.deleteById(id);
        }

        throw new RuntimeException("O empregado com o ID:"+id+" nao existe");

    }








}
