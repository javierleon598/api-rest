package com.leantech.testapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.leantech.testapi.entity.Employee;
import com.leantech.testapi.dto.Employees;
// import com.leantech.testapi.entity.Response;
import com.leantech.testapi.repository.CandidateRepository;
import com.leantech.testapi.repository.EmployeeRepository;
import com.leantech.testapi.repository.PositionRepository;
import com.leantech.testapi.service.IEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    PositionRepository positionRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void saveEmployee(Employee employee){
        candidateRepository.save(employee.getPerson());
        positionRepository.save(employee.getPosition());
        employeeRepository.save(employee);
    }

    @Override
    public List<Employees> getEmployees(){
        List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();
        // List<Response> response = new ArrayList<Response>();
        List<Employees> employeesList = new ArrayList<Employees>();
        for (Employee employee : employeeList) {
            Employees employees = new Employees();
            employees.setId(employee.getId());
            employees.setSalary(employee.getSalary());
            employees.setPerson(employee.getPerson());
            employees.setName(employee.getPosition().getName());
            employeesList.add(employees);
        }
        return employeesList;
    }

    @Override
    public void deleteEmployee(String id){
        employeeRepository.deleteById(Integer.parseInt(id));
    }

    @Override
    public List<Employees> getEmployeesByFilter(String position,String name) {
        List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();
        
        List<Employees> employeesList = new ArrayList<Employees>();
        for (Employee employee : employeeList) {
            Employees employees = new Employees();
            if(employee.getPosition().getName().equals(position) || employee.getPerson().getName().equals(name)){
                employees.setId(employee.getId());
                employees.setSalary(employee.getSalary());
                employees.setPerson(employee.getPerson());
                employees.setName(employee.getPosition().getName());
                employeesList.add(employees);
            }
        }
        return employeesList;
    }

}
