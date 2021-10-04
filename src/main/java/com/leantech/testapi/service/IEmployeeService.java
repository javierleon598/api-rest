package com.leantech.testapi.service;

import java.util.List;

import com.leantech.testapi.entity.Employee;
import com.leantech.testapi.dto.Employees;

public interface IEmployeeService {

    void saveEmployee(Employee employee);

    List<Employees> getEmployees();

    void deleteEmployee(String id);

    List<Employees> getEmployeesByFilter(String position,String name);

}
