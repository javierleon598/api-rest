package com.leantech.testapi.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="candidate")
public class Candidate implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidate")
    private Integer id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="address")
    private String address;
    
    @Column(name="cellphone")
    private String cellphone;
    
    @Column(name="city_Name")
    private String cityName;

    public Candidate(){}

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

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getCellphone(){
        return cellphone;
    }

    public void setCellphone(String cellphone){
        this.cellphone = cellphone;
    }

    public String getCityName(){
        return cityName;
    }

    public void setCityName(String cityName){
        this.cityName = cityName;
    }
    
}
