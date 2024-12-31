package com.mhr.polytechnicexammanagement.service

import com.mhr.polytechnicexammanagement.model.Department
import com.mhr.polytechnicexammanagement.model.Student
import com.mhr.polytechnicexammanagement.model.Result
import com.mhr.polytechnicexammanagement.repository.DepartmentRepository
import com.mhr.polytechnicexammanagement.repository.ResultRepository
import com.mhr.polytechnicexammanagement.repository.StudentRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service


@Service
@Transactional
class DepartmentService(private val departmentRepository: DepartmentRepository) {

    fun getAllDepartments(): List<Department> = departmentRepository.findAll()

    fun getDepartmentById(id: Long): Department = departmentRepository.findById(id).orElseThrow {
        RuntimeException("Department not found with id $id")
    }

    fun addDepartment(department: Department): Department = departmentRepository.save(department)
}



@Service
@Transactional
class StudentService(private val studentRepository: StudentRepository) {

    fun getAllStudents(): List<Student> = studentRepository.findAll()

    fun getStudentById(id: Long): Student = studentRepository.findById(id).orElseThrow {
        RuntimeException("Student not found with id $id")
    }

    fun addStudent(student: Student): Student = studentRepository.save(student)
}




@Service
@Transactional
class ResultService(private val resultRepository: ResultRepository) {

    fun getResultsByStudentId(studentId: Long): List<Result> = resultRepository.findByStudentId(studentId)

    fun addResult(result: Result): Result = resultRepository.save(result)
}
