package com.alberto.app.person.model.entity;

import com.alberto.app.course.model.entity.CourseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_student")
public class StudentEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "courses_id", nullable = true)
    private List<CourseEntity> enrolledCourses;

    public StudentEntity(List<CourseEntity> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public StudentEntity(String name, String lastName, String code, String email, String password, String country, String province, String district, Boolean isActive, List<CourseEntity> enrolledCourses) {
        super(name, lastName, code, email, password, country, province, district, isActive);
        this.enrolledCourses = enrolledCourses;
    }

    public StudentEntity() {

    }

    public List<CourseEntity> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<CourseEntity> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}
