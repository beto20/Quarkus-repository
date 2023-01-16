package com.alberto.course.controller;

import com.alberto.course.facade.CourseFacade;
import com.alberto.course.model.dto.CourseRequest;
import com.alberto.course.model.dto.CourseResponse;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Tag(name = "Course")
@Path("/api/v1/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class CourseController {

    @Inject
    CourseFacade courseFacade;


    @GET
    @APIResponse(
            responseCode = "200",
            description = "Operacion que retorna una lista de cursos",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.ARRAY, implementation = CourseResponse.class)
            )
    )
    public List<CourseResponse> coursesCatalog() {
        return courseFacade.getCourses();
    }

    @GET
    @Path("/{id}")
    public CourseResponse getCourseDetail(@PathParam("id") Integer id) {
        return courseFacade.getCoursesById(id);
    }

    @GET
    @Path("/title")
    public CourseResponse searchCourseByTitle(@QueryParam("name") String name) {
        return courseFacade.getCoursesByTitle(name);
    }

    @APIResponses(value = {
            @APIResponse(
                    responseCode = "201",
                    description = "Operacion que registra un curso",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(type = SchemaType.OBJECT, implementation = CourseResponse.class)
                    )
            ),
            @APIResponse(
                    responseCode = "500",
                    description = "Error de servidor",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON)
            )
        }
    )
    @POST
    public Response registerNewCourse(CourseRequest courseRequest) {
        courseFacade.saveCourse(courseRequest);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @APIResponse(
            responseCode = "204",
            description = "Operacion que actualizado que curso",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.OBJECT, implementation = CourseResponse.class)
            )
    )
    public CourseResponse updateCourseInformation(CourseRequest courseRequest) {
        return courseFacade.updateCourse(courseRequest);
    }

    @DELETE
    @Path("/{id}")
    @APIResponse(
            responseCode = "200",
            description = "Operacion que elimina un curso",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.ARRAY, implementation = CourseResponse.class)
            )
    )
    public Response deleteCourse(@PathParam("id") Integer id) {
        courseFacade.deleteCourseById(id);
        return Response.ok().build();
    }
}
