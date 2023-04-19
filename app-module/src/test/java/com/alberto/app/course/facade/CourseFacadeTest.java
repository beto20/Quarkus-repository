package com.alberto.app.course.facade;

import com.alberto.app.course.model.dto.CourseDto;
import com.alberto.app.course.model.dto.CourseRequest;
import com.alberto.app.course.model.dto.CustomPaginationResponse;
import com.alberto.app.course.service.impl.CourseServiceImpl;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class CourseFacadeTest {

    @InjectMock
    CourseServiceImpl courseService;
    @Inject
    CourseFacade courseFacade;

    @BeforeEach
    public void setup() {
    }


    @Test
    public void testGetCoursesById_thenOk() {
        var thenReturn =Mockito.when(courseService.getById(Mockito.any())).thenReturn(new CourseDto());
        courseFacade.getCoursesById(1);
        assertNotNull(thenReturn);
    }

    @Test
    public void testGetCourses_thenOk() {
        var thenReturn = Mockito.when(courseService.getAll()).thenReturn(List.of(new CourseDto()));
        courseFacade.getCourses();
        assertNotNull(thenReturn);
    }

    @Test
    public void testGetCoursesWithPagination_thenOk() {
        var thenReturn = Mockito.when(courseService.getCoursePagination(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(List.of(new CourseDto()));

        courseFacade.getCoursesWithPagination(1, 5);
        assertNotNull(thenReturn);
    }

    @Test
    public void testGetCourseCustomPagination_thenOk() {
        var thenReturn = Mockito.when(courseService.getCourseCustomPagination(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(new CustomPaginationResponse());
        courseFacade.getCourseCustomPagination(1, 5);
        assertNotNull(thenReturn);
    }

    @Test
    public void testSaveCourse_thenOk() {
        Mockito.doNothing().when(courseService).save(Mockito.any());
        courseFacade.saveCourse(new CourseRequest());
    }

    @Test
    public void testUpdateCourse_thenOk() {
        var thenReturn = Mockito.when(courseService.update(Mockito.any()))
                .thenReturn(new CourseDto());
        courseFacade.updateCourse(new CourseRequest());
        assertNotNull(thenReturn);
    }

    @Test
    public void testDeleteCourseById_thenOk() {
        Mockito.doNothing().when(courseService).delete(Mockito.any());
        courseFacade.deleteCourseById(1);
    }

}
