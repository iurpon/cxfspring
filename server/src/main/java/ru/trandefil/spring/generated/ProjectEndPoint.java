package ru.trandefil.spring.generated;

import ru.trandefil.spring.dto.ProjectDTO;
import ru.trandefil.spring.model.Session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProjectEndPoint {

    @WebMethod
    ProjectDTO saveProject(
            @WebParam(name = "name") String name,
            @WebParam(name = "desc") String desc);

    @WebMethod
    ProjectDTO updateProject(
            @WebParam(name = "project") ProjectDTO project);

    @WebMethod
    List<ProjectDTO> getAllProjects();

    @WebMethod
    ProjectDTO getProjectById(
            @WebParam(name = "id") String id);

    @WebMethod
    void deleteProject(
            @WebParam(name = "project") ProjectDTO project);

    @WebMethod
    void deleteProjectByName(@WebParam(name = "projectName") String projectName);

    @WebMethod
    ProjectDTO getProjectByName(@WebParam(name = "projectName") String projectName);

}
