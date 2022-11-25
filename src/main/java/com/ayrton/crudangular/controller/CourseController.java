package com.ayrton.crudangular.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ayrton.crudangular.model.Course;
import com.ayrton.crudangular.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses/")

@Component //criar instância e gerenciar o ciclo de vida.
@AllArgsConstructor
public class CourseController {
    
    private CourseRepository courseRepository;

    // public CourseController(CourseRepository courseRepository) {
    //     this.courseRepository = courseRepository;
    // } se utilizar a notação do "@AllArgsConstuctor" não precisa disso.

    @GetMapping
    public List<Course> getCourses() {
        return courseRepository.findByOrderByNameAsc();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id){
        return courseRepository.findById(id)
        .map(courseFound -> ResponseEntity.ok().body(courseFound)).
        orElse(ResponseEntity.notFound().build());

        /*(line 44 to 45) se caso esse registro exista, crie um response entity com um body do curso encontrado.
         * Caso não encontre o registro, retorne um 404 de não encontrado!
        */
    }

    // @RequestMapping(method = RequestMethod.POST)
    /**
     *
     */

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody Course course){
        // System.out.println(course.getName());
        return courseRepository.save(course);
        // return ResponseEntity.status(HttpStatus.CREATED)
        // .body(courseRepository.save(course));
    }
    
    
    @PutMapping("{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody final Course course) {
        return courseRepository.findById(id)
        
        .map(courseFound -> {
            
            courseFound.setName(course.getName());
            courseFound.setCategory(course.getCategory());
            
            Course updated = courseRepository.save(courseFound);
            return ResponseEntity.ok().body(updated);
        })

        .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
        
        return courseRepository.findById(id)

        .map(courseFound -> {
            courseRepository.deleteById(id);   
            return ResponseEntity.noContent().<Void>build();
        }).
        orElse(ResponseEntity.notFound().build());
    }
}
