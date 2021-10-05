package com.leantech.testapi.service;

import java.util.List;

import com.leantech.testapi.entity.Employee;
import com.leantech.testapi.dto.Response;

public interface IEmployeeService {

    void saveEmployee(Employee employee);

    List<Response> getEmployees();

    void deleteEmployee(String id);

    List<Response> getEmployeesByFilter(String position,String name);

}
