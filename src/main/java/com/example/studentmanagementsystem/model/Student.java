package com.example.studentmanagementsystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The Student class.
 * @author Jorge Vasquez
 * @since 1.8
 */
@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(name = "student_classroom",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "classroom_code", referencedColumnName = "code"))
    private List<Classroom> classrooms;

    /**
     * Empty constructor for Student.
     */
    public Student() {
        // No Op
    }

    /**
     * @return the student's id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the student's id.
     * @param id the new student's id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the student's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the student's first name.
     * @param firstName the new student's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the student's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the student's last name.
     * @param lastName the new student's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the student's classrooms
     */
    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    /**
     * Sets the student's classrooms.
     * @param classrooms the new student's classrooms
     */
    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    /**
     * Adds a classroom to this student's classrooms list.
     * @param classroom the classroom to be added
     */
    public void addClassroom(Classroom classroom) {
        classrooms.add(classroom);
    }

    /**
     * Removes a classroom from this student's classrooms list.
     * @param classroom the classroom to be removed
     */
    public void removeClassroom(Classroom classroom) {
        classrooms.remove(classroom);
    }
}
