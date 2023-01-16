package com.alberto.course.repository;

import com.alberto.course.model.entity.CourseEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class CourseRepository implements PanacheRepositoryBase<CourseEntity, Integer> {
    @Inject
    EntityManager em;

}

