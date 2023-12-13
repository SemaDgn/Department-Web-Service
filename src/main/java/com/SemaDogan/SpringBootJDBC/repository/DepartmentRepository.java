package com.SemaDogan.SpringBootJDBC.repository;

import com.SemaDogan.SpringBootJDBC.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    //docs.Spring/data/Query Methods/QueryCreation adresınde bu sorguların kalıplerı var. Spring bizim revize ettiğimiz db alanlarına göre kalıplarla sorguları çeker.
    //Sql soegu kalıpları. And, or, endingWith vb.
    public Department findByDepartmentName(String departmentName);
    //@Query(value="SELECT * FROM DEPARTMENT WHERE DEPARTMENTNAME=?1. ",nativeQuery = true)
    //"?1" sorguya eklenecek parametreyı gosterır.
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}

