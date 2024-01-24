package com.example.demo.studentcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.studententity.Student;
import com.example.demo.studentservice.StudentService;

@RestController
public class StudentController {
	
	public StudentService studentService;
	
	
	 @PostMapping("/raj")
	    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
	        Student createdStudent = studentService.createStudent(student);
	        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
	    }
	 
	   @GetMapping("/{id}")
	    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
	        Optional<Student> student = studentService.getStudentById(id);

	        if (student.isPresent()) {
	            return new ResponseEntity<>(student.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {
		Student updated = studentService.updateStudent(id, updatedStudent);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}
	
	  @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
	        studentService.deleteStudent(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	  
	  
	  @GetMapping
	    public ResponseEntity<List<Student>> getAllStudents() {
	        List<Student> students = studentService.getAllStudents();
	        return new ResponseEntity<>(students, HttpStatus.OK);
	    }
}
