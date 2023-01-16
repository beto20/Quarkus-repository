package com.alberto.person.repository;

import com.alberto.person.model.entity.TeacherEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TeacherRepository implements PanacheRepositoryBase<TeacherEntity, Long> {
}
