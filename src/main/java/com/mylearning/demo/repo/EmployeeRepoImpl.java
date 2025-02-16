package com.mylearning.demo.repo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class EmployeeRepoImpl implements EmployeeRepo{
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public void employeeSave() {
        try {
            Employee employee2 = new Employee();
            employee2.setEmpName("Dharvik");
            employee2.setEmpId("340975");
            mongoTemplate.insert(employee2, "Employee");
        }catch (Exception e){
            log.info("Exception occurs {}", e);
        }
    }

    @Override
    public List<Employee> findAllEmployee() {
        return mongoTemplate.findAll(Employee.class);
    }
}
