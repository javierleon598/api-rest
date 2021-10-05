package com.leantech.testapi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leantech.testapi.entity.Employee;
import com.leantech.testapi.dto.Employees;
import com.leantech.testapi.dto.Response;
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
    public List<Response> getEmployees(){
        
        List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();

        Map<String, List<Employee>> map = new HashMap<String, List<Employee>>();

        for (Employee employee : employeeList) {
            String key  = employee.getPosition().getName();
            if(map.containsKey(key)){
                List<Employee> list = map.get(key);
                list.add(employee);

            }else{
                List<Employee> list = new ArrayList<Employee>();
                list.add(employee);
                map.put(key, list);
            }
        }

        List<Employees> employeesList = new ArrayList<Employees>();
        for (Employee employee : employeeList) {
            Employees employees = new Employees();
            employees.setId(employee.getId());
            employees.setSalary(employee.getSalary());
            employees.setPerson(employee.getPerson());
            // employees.setName(employee.getPosition().getName());
            employeesList.add(employees);
        }

        List<Response> response = new ArrayList<Response>();
        for (Map.Entry<String, List<Employee>> employee : map.entrySet()) {
            Response responseT = new Response();
            List<Employees> employeesListT = new ArrayList<Employees>();
            for (Employee employeeT : employee.getValue()) {
                
                Employees employees = new Employees();
                employees.setId(employeeT.getId());
                employees.setSalary(employeeT.getSalary());
                employees.setPerson(employeeT.getPerson());
                employeesListT.add(employees);

                responseT.setId(employeeT.getPosition().getId());
                responseT.setName(employee.getKey());
            }
            responseT.setEmployees(employeesListT);
            response.add(responseT);
        }

        System.out.println(map.toString());
    
        // return employeesList;
        return response;
    }

    @Override
    public void deleteEmployee(String id){
        employeeRepository.deleteById(Integer.parseInt(id));
    }

    @Override
    public List<Response> getEmployeesByFilter(String position,String name) {
        List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();

        Map<String, List<Employee>> map = new HashMap<String, List<Employee>>();

        for (Employee employee : employeeList) {
            String key  = employee.getPosition().getName();
            if(map.containsKey(key)){
                List<Employee> list = map.get(key);
                list.add(employee);

            }else{
                List<Employee> list = new ArrayList<Employee>();
                list.add(employee);
                map.put(key, list);
            }
        }

        List<Employees> employeesList = new ArrayList<Employees>();
        for (Employee employee : employeeList) {
            Employees employees = new Employees();
            if(employee.getPosition().getName().equals(position) || employee.getPerson().getName().equals(name)){
                employees.setId(employee.getId());
                employees.setSalary(employee.getSalary());
                employees.setPerson(employee.getPerson());
                // employees.setName(employee.getPosition().getName());
                employeesList.add(employees);
            }
        }

        List<Response> response = new ArrayList<Response>();
        for (Map.Entry<String, List<Employee>> employee : map.entrySet()) {
            Response responseT = new Response();
            List<Employees> employeesListT = new ArrayList<Employees>();
            for (Employee employeeT : employee.getValue()) {
                
                Employees employees = new Employees();
                if(employeeT.getPosition().getName().equals(position) || employeeT.getPerson().getName().equals(name)){
                    employees.setId(employeeT.getId());
                    employees.setSalary(employeeT.getSalary());
                    employees.setPerson(employeeT.getPerson());
                    employeesListT.add(employees);
                }

                responseT.setId(employeeT.getPosition().getId());
                responseT.setName(employee.getKey());
                responseT.setEmployees(employeesListT);
            }
            response.add(responseT);
        }

        System.out.println(map.toString());
    
        // return employeesList;
        return response;
    }

}
