package com.alberto.course.repository;

import com.alberto.course.model.dto.CourseDto;
import com.alberto.course.model.entity.CourseEntity;
import com.alberto.course.service.CourseService;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CourseRepository implements PanacheRepositoryBase<CourseEntity, Integer> {
    @Inject
    EntityManager em;

}

