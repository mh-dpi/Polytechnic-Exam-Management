package com.mhr.polytechnicexammanagement.repository

import com.mhr.polytechnicexammanagement.model.Department
import com.mhr.polytechnicexammanagement.model.Student
import com.mhr.polytechnicexammanagement.model.Result
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


interface DepartmentRepository : JpaRepository<Department, Long>


interface StudentRepository : JpaRepository<Student, Long> {
    fun findByEmail(email: String): Student?
}


interface ResultRepository : JpaRepository<Result, Long> {
    fun findByStudentId(studentId: Long): List<Result>
}
