package com.SemaDogan.SpringBootJDBC.controller;

import com.SemaDogan.SpringBootJDBC.entity.Department;
import com.SemaDogan.SpringBootJDBC.error.DepartmentNotFoundException;
import com.SemaDogan.SpringBootJDBC.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        //bu loglama ile biz intellij console bılgı bastık. istersek bir dosyayada basılabılır.
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();

    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmendId) throws DepartmentNotFoundException {
        LOGGER.info("Inside fetchDepartmentById of DepartmentController");

        return departmentService.fetchDepartmendById(departmendId);

    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmendId) {
        LOGGER.info("Inside deleteDepartmentById of DepartmentController");
        return departmentService.deleteDepartmentById(departmendId);

    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmendId, @RequestBody Department department) {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.updateDepartment(departmendId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable String department) {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentByName(department);
    }
}
