package com.ayrton.crudangular.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayrton.crudangular.model.Course;



@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByOrderByNameAsc();
}