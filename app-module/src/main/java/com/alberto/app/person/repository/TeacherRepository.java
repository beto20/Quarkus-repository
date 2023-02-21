package com.alberto.app.person.repository;

import com.alberto.app.person.model.entity.TeacherEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TeacherRepository implements PanacheRepositoryBase<TeacherEntity, Long> {
}
