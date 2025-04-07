package com.deptmanagement.sys.controller;

import com.deptmanagement.sys.domain.entity.StudentEntity;
import com.deptmanagement.sys.dto.StudentDTO;
import com.deptmanagement.sys.mapper.StudentMapper;
import com.deptmanagement.sys.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p> Controller for managing Student operations. </p>
 */
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final IStudentService studentService;

    /**
     * <p> Constructor to inject StudentService. </p>
     *
     * @param studentService <p> Service to manage student-related operations. </p>
     */
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    private StudentMapper studentMapper;

    /**
     * <p> Retrieves all students in the system. </p>
     *
     * @return <p> List of all students as DTOs. </p>
     */
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    /**
     * <p> Retrieves a student by USN. </p>
     *
     * @param usn <p> The USN of the student. </p>
     * @return <p> The corresponding StudentDTO if found. </p>
     */
    @GetMapping("/{usn}")
    public ResponseEntity<StudentDTO> getStudentByUsn(@PathVariable String usn) {
        StudentEntity studentEntity = studentService.getStudentByUsn(usn);

        if (studentEntity == null) {
            return ResponseEntity.notFound().build();
        }

        StudentDTO studentDTO = studentMapper.toDTO(studentEntity);
        return ResponseEntity.ok(studentDTO);
    }

    /**
     * <p> Adds a new student to the system. </p>
     *
     * @param studentDTO <p> Student information to be added. </p>
     * @return <p> Success or failure message. </p>
     */
    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) {
        boolean isAdded = studentService.addStudent(studentDTO);

        if (!isAdded) {
            return ResponseEntity.badRequest().body("Error: USN already exists or Department ID not found.");
        }
        return ResponseEntity.ok("Student added successfully!");
    }

    /**
     * <p> Updates a student's name. </p>
     *
     * @param usn <p> The USN of the student to be updated. </p>
     * @param name <p> New name for the student. </p>
     * @return <p> Success message. </p>
     */
    @PutMapping("/{usn}")
    public ResponseEntity<String> updateStudent(@PathVariable String usn, @RequestParam String name) {
        studentService.updateStudent(usn, name);
        return ResponseEntity.ok("Student updated successfully!");
    }

    /**
     * <p> Deletes a student by USN. </p>
     *
     * @param usn <p> The USN of the student to be deleted. </p>
     * @return <p> Success message. </p>
     */
    @DeleteMapping("/{usn}")
    public ResponseEntity<String> deleteStudent(@PathVariable String usn) {
        studentService.deleteStudent(usn);
        return ResponseEntity.ok("Student deleted successfully!");
    }
}
