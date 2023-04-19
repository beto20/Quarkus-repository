
package com.alberto.app.course.service;

import com.alberto.app.course.model.dto.CourseDto;
import com.alberto.app.course.service.impl.CourseServiceImpl;
import com.alberto.core.course.model.entity.CourseEntity;
import com.alberto.core.course.repository.CourseRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class CourseServiceImplTest {

    @InjectMock
    CourseRepository courseRepository;
    @Inject
    CourseServiceImpl courseService;

    @BeforeEach
    public void setup() {
    }


    @Test
    public void testGetCoursesById_thenOk() {
        var thenReturn = Mockito.when(courseRepository.findById(Mockito.any()))
                .thenReturn(new CourseEntity());
        courseService.getById(1);
        assertNotNull(thenReturn);
    }

    @Test
    public void testGetCourses_thenOk() {
        PanacheQuery<CourseEntity> query = Mockito.mock(PanacheQuery.class);

        var thenReturn = Mockito.when(courseRepository.findAll())
                .thenReturn(query);

        courseService.getAll();
        assertNotNull(thenReturn);
    }

    public void testGetCoursesWithPagination_thenOk() {
        PanacheQuery<CourseEntity> query = Mockito.mock(PanacheQuery.class);
        var thenReturn = Mockito.when(query
                        .page(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(query);

        courseService.getCoursePagination(1, 5);
        assertNotNull(thenReturn);
    }

    public void testGetCourseCustomPagination_thenOk() {

        PanacheQuery<CourseEntity> query = Mockito.mock(PanacheQuery.class);

        Mockito.when(query.page(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(query);

        Mockito.when(courseRepository.count())
                .thenReturn(1L);

        courseService.getCourseCustomPagination(1, 5);
    }

    @Test
    public void testSaveCourse_thenOk() {
        Mockito.doNothing().when(courseRepository).persist(Mockito.any(CourseEntity.class));
        courseService.save(new CourseDto());
    }

    @Test
    public void testUpdateCourse_thenOk() {
        var thenReturn = Mockito.when(courseRepository.findById(Mockito.any()))
                .thenReturn(new CourseEntity());
        courseService.update(new CourseDto());
        assertNotNull(thenReturn);
    }

    @Test
    public void testDeleteCourseById_thenOk() {
        var thenReturn = Mockito.when(courseRepository.deleteById(Mockito.any()))
                .thenReturn(true);
        courseService.delete(1);
        assertNotNull(thenReturn);
    }

}
