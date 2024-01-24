package com.example.demo.studentservice;

import java.util.List;
import java.util.Optional;

import com.example.demo.studententity.Student;

public interface StudentService {

	public Student createStudent(Student student);

	public List<Student> getAllStudents();

	public void deleteStudent(Integer studentId);

	Student updateStudent(Integer studentId, Student updatedStudent);

	public Optional<Student> getStudentById(Integer id);

}
