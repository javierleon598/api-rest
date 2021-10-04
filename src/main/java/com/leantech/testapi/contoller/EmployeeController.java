package com.leantech.testapi.contoller;

import java.util.List;


import com.leantech.testapi.entity.Employee;
import com.leantech.testapi.entity.Employees;
import com.leantech.testapi.service.IEmployeeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employees> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/employee")
    public Employee saveEmployees(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
    	
	@PutMapping("/employee")
	public Employee modifyEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return employee;
	} 
	
	@DeleteMapping("/employee")
	public String deleteEmployee(@RequestParam("id") String id) {
		employeeService.deleteEmployee(id);
		return "Employee Deleted";
	}

    // @GetMapping("/employee")
    // public List<Employees> getEmployees(@RequestParam("position") String position,@RequestParam("name") String name){
    //     return employeeService.getEmployeesByFilter(position,name);
    // }
    
}
