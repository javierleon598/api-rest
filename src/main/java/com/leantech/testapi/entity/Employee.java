package com.leantech.testapi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name="employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Integer id;
    
    @Column(name="salary")
    private String salary;

    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "person", referencedColumnName = "id_candidate")
    @ManyToOne(fetch = FetchType.LAZY)
    private Candidate person;
    
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "position", referencedColumnName = "id_position")
    @ManyToOne(fetch = FetchType.LAZY)
    private Position position;

    
    public Employee(){}

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getSalary(){
        return salary;
    }

    public void setSalary(String salary){
        this.salary = salary;
    }

    public Candidate getPerson(){
        return person;
    }

    public void setPerson(Candidate person){
        this.person = person;
    }

    public Position getPosition(){
        return position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

}
