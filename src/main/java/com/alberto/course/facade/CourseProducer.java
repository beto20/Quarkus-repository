package com.alberto.course.facade;

import com.alberto.course.controller.CourseController;
import com.alberto.course.repository.CourseRepository;
import com.alberto.course.service.CourseService;
import com.alberto.course.service.impl.CourseServiceImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CourseProducer {


//    @Produces
//    @ApplicationScoped
//    public CourseController courseController() {
//        return new CourseController();
//    }
//    @Produces
//    @ApplicationScoped
//    public CourseService courseService() {
//        return new CourseServiceImpl();
//    }
//
//    @Produces
//    @ApplicationScoped
//    public CourseFacade courseFacade() {
//        return new CourseFacade();
//    }
//

}
