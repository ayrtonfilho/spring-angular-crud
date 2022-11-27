package com.ayrton.crudangular.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data //getters and setters
@Entity
@Table(name = "tb_courses")

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 90)
    @Column(length = 90, nullable = false)
    private String name;
    
    @NotNull
    @Length(max = 10)
    @Pattern( regexp = "Back-end|Front-end")
    @Column(length = 10, nullable = false)
    private String category;

    
}
