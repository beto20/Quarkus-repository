package com.alberto.core.person.repository;

import com.alberto.core.person.model.entity.TeacherEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TeacherRepository implements PanacheRepositoryBase<TeacherEntity, Long> {
}
