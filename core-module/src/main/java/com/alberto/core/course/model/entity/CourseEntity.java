package com.alberto.core.course.model.entity;

import com.alberto.core.person.model.entity.StudentEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_course")
public class CourseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private String category;

    @ManyToOne
    private StudentEntity student;

    public CourseEntity() {
    }

    public CourseEntity(Integer id, String name, String description, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
