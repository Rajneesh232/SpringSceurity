package com.example.demo.studentserviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.studententity.Student;
import com.example.demo.studentrepository.StudentRepository;
import com.example.demo.studentservice.StudentService;

@Service
public abstract class StudentServiceImpl implements StudentService {

	public StudentRepository studentRepository;

//////CREATE(POST)

	public Student createStudent(Student student) {
		// Save the student to the database
		return studentRepository.save(student);
	}

//////// GETBYID
	public Optional<Student> getStudentById(Integer studentId) {
		// Retrieve the student from the database by ID
		return studentRepository.findById(studentId);
	}

/////////GETALL

	public List<Student> getAllStudents() {
		// Retrieve all students from the database
		return studentRepository.findAll();

	}
////////DELETE

	public void deleteStudent(Integer studentId) {
		// Check if the student exists
		if (!studentRepository.existsById(studentId)) {
			throw new RuntimeException("Student not found with id: " + studentId);
		}

		// Delete the student from the database
		studentRepository.deleteById(studentId);
	}
///////UPDATE

	public Student updateStudent(Integer studentId, Student updatedStudent) {
		// Retrieve the existing student from the database
		Student existingStudent = studentRepository.findById(studentId)
				.orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

		// Update the existing student with the new values
		existingStudent.setName(updatedStudent.getName());

		// Save the updated student back to the database
		return studentRepository.save(existingStudent);

	}

}
