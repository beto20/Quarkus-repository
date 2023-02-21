package com.alberto.app.person.repository;

import com.alberto.app.person.model.entity.StudentEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StudentRepository implements PanacheRepositoryBase<StudentEntity, Long> {
}
