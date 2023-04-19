package com.alberto.core.course.repository;

import com.alberto.core.course.model.entity.CourseEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class CourseRepository implements PanacheRepositoryBase<CourseEntity, Integer> {


}

