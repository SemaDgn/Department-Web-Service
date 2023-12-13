package com.SemaDogan.SpringBootJDBC.service;

import com.SemaDogan.SpringBootJDBC.entity.Department;
import com.SemaDogan.SpringBootJDBC.error.DepartmentNotFoundException;
import com.SemaDogan.SpringBootJDBC.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmendById(Long departmendId) throws DepartmentNotFoundException {
        Optional<Department> department= Optional.of(departmentRepository.findById(departmendId).get());
        if (!department.isPresent())
            throw new DepartmentNotFoundException("Department not avaible");
        Department department1 = department.get();
        return department.get();
    }

    @Override
    public String deleteDepartmentById(Long departmendId) {
        departmentRepository.deleteById(departmendId);
        return "Departmen succesfullt deleted.";
    }

    @Override
    public Department updateDepartment(Long departmendId, Department department) {
        Department depDB = departmentRepository.findById(departmendId).get();
        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()))
            depDB.setDepartmentName(department.getDepartmentName());
        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode()))
            depDB.setDepartmentCode(department.getDepartmentCode());
        if (Objects.nonNull(department.getDepartmentAdress()) && !"".equalsIgnoreCase(department.getDepartmentAdress()))
            depDB.setDepartmentAdress(department.getDepartmentAdress());
        return  departmentRepository.save(depDB);

    }

    @Override
    public Department fetchDepartmentByName(String department) {
        //burada repositry üzerinde default bir arama methodu yok ada gore bız kendımız bunu docs.Spring/data/Query Methods/QueryCreation
        // sitesinden Query kısmında bakıp alabılırız.        // yanı manuela olarak sorgular yazmak mumkun
        // gidip repository interfacesınde  metodun imzasını yazıcaz.
        return departmentRepository.findByDepartmentNameIgnoreCase(department);

    }

}

