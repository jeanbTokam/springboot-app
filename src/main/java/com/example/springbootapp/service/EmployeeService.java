package com.example.springbootapp.service;

import com.example.springbootapp.models.Employee;
import com.example.springbootapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepo;
    public List<Employee> getAllEmployees(){
         List<Employee> list = new ArrayList<>();
         employeeRepo.findAll().forEach(employee -> list.add(employee));
         return list;
    }

    public Employee getEmployeeById(Integer id){
        return employeeRepo.findById(id).get();

    }
    public boolean saveOrUpdateEmployee(Employee employee){
        Employee emp = employeeRepo.save(employee);
        if (emp != null && employeeRepo.findById(emp.getId())!=null){
            return true;

        }
     return false;
    }
    public boolean deleteEmployee(Integer id){
            employeeRepo.deleteById(id);
            if (employeeRepo.findById(id) != null){
                return false;

            }
            return true;
    }
}
