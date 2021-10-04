package com.leantech.testapi.entity;

import java.util.List;


public class Response {
    
    private Integer id;
    private String name;
    private List<Employees> employees;
    
    public Response(){}

    public Response(Integer id, String name, List<Employees> employees ){
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Employees> getEmployees(){
        return employees;
    }

    public void setEmployees(List<Employees> employees){
        this.employees = employees;
    }

}
