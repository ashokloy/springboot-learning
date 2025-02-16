package com.mylearning.demo.controller;

import com.mylearning.demo.repo.Employee;
import com.mylearning.demo.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/learn")
@RequiredArgsConstructor
@Slf4j
public class LearningController {

    private final EmployeeRepo employeeRepo;
    @Value("${test.value}")
    String value;

    @GetMapping("/test")
    public ResponseEntity<String> getLearning(@RequestParam String param){
        log.info("this is log {} param {} ", value, param);
        employeeRepo.employeeSave();
        List<Employee> list = employeeRepo.findAllEmployee();
        log.info("list size {}", list.size());
        return ResponseEntity.ok("Learning Controller "+value + " " + param);
    }
}
