package com.leantech.testapi.repository;

import com.leantech.testapi.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
// import org.springframework.stereotype.Repository;

// @Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
