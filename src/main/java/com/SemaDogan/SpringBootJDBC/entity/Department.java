package com.SemaDogan.SpringBootJDBC.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data//getter-setter vb create
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = " Departmen Name is not null")
//    @Length(max = 5,min = 0)
//    @Size(max = 10,min=1)
//    @Email
//    @Positive
//    @Negative
//    @PositiveOrZero
    private String departmentName;
    private  String departmentAdress;
    private  String departmentCode;


}
