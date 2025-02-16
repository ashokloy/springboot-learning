package com.mylearning.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepo {
    void employeeSave();
    List<Employee> findAllEmployee();
}
