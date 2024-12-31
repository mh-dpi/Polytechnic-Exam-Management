package com.mhr.polytechnicexammanagement.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*


@Entity
data class Department(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String = "",
    @OneToMany(mappedBy = "department")
    @JsonManagedReference
    val students: List<Student>? = emptyList()
)



@Entity
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val firstName: String="",
    val lastName: String="",
    val email: String ="",
    val roll: Int=0,
    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    val department: Department? = null,
)



@Entity
data class Result(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val subject: String="",
    val marks: Int=0,
    @ManyToOne
    @JoinColumn(name = "student_id")
    val student: Student? =null,
)
