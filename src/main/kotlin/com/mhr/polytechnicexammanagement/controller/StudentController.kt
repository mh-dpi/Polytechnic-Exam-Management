package com.mhr.polytechnicexammanagement.controller

import com.mhr.polytechnicexammanagement.model.Department
import com.mhr.polytechnicexammanagement.model.Student
import com.mhr.polytechnicexammanagement.model.Result
import com.mhr.polytechnicexammanagement.service.DepartmentService
import com.mhr.polytechnicexammanagement.service.ResultService
import com.mhr.polytechnicexammanagement.service.StudentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/departments")
class DepartmentController(private val departmentService: DepartmentService) {

    @GetMapping
    fun getAllDepartments(): ResponseEntity<List<Department>> {
        return ResponseEntity.ok(departmentService.getAllDepartments())
    }

    @GetMapping("/{id}")
    fun getDepartmentById(@PathVariable id: Long): ResponseEntity<Department> {
        return ResponseEntity.ok(departmentService.getDepartmentById(id))
    }

    @PostMapping
    fun createDepartment(@RequestBody department: Department): ResponseEntity<Department> {
        return ResponseEntity.status(201).body(departmentService.addDepartment(department))
    }
}




@RestController
@RequestMapping("/api/students")
class StudentController(private val studentService: StudentService) {

    @GetMapping
    fun getAllStudents(): ResponseEntity<List<Student>> {
        return ResponseEntity.ok(studentService.getAllStudents())
    }

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): ResponseEntity<Student> {
        return ResponseEntity.ok(studentService.getStudentById(id))
    }

    @PostMapping
    fun createStudent(@RequestBody student: Student): ResponseEntity<Student> {
        return ResponseEntity.status(201).body(studentService.addStudent(student))
    }
}



@RestController
@RequestMapping("/api/results")
class ResultController(private val resultService: ResultService) {

    @GetMapping("/student/{studentId}")
    fun getResultsByStudentId(@PathVariable studentId: Long): ResponseEntity<List<Result>> {
        return ResponseEntity.ok(resultService.getResultsByStudentId(studentId))
    }

    @PostMapping
    fun createResult(@RequestBody result: Result): ResponseEntity<Result> {
        return ResponseEntity.status(201).body(resultService.addResult(result))
    }
}
