package com.ayrton.crudangular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayrton.crudangular.model.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{}