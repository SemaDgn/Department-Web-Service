package com.SemaDogan.SpringBootJDBC.service;

import com.SemaDogan.SpringBootJDBC.entity.Department;
import com.SemaDogan.SpringBootJDBC.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

   List<Department> fetchDepartmentList();

   Department fetchDepartmendById(Long departmendId) throws DepartmentNotFoundException;

   String deleteDepartmentById(Long departmendId);

   Department updateDepartment(Long departmendId, Department department);

   Department fetchDepartmentByName(String department);
}
