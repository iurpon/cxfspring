package ru.trandefil.spring.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2019-04-19T11:02:12.445+03:00
 * Generated source version: 3.0.4
 * 
 */
@WebService(targetNamespace = "http://generated.spring.trandefil.ru/", name = "ProjectEndPoint")
@XmlSeeAlso({ObjectFactory.class})
public interface ProjectEndPoint {

    @WebMethod
    @RequestWrapper(localName = "getProjectByName", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.GetProjectByName")
    @ResponseWrapper(localName = "getProjectByNameResponse", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.GetProjectByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.trandefil.spring.generated.ProjectDTO getProjectByName(
        @WebParam(name = "projectName", targetNamespace = "")
        java.lang.String projectName,
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.spring.generated.Session session
    );

    @WebMethod
    @RequestWrapper(localName = "deleteProjectByName", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.DeleteProjectByName")
    @ResponseWrapper(localName = "deleteProjectByNameResponse", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.DeleteProjectByNameResponse")
    public void deleteProjectByName(
        @WebParam(name = "projectName", targetNamespace = "")
        java.lang.String projectName,
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.spring.generated.Session session
    );

    @WebMethod
    @RequestWrapper(localName = "deleteProject", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.DeleteProject")
    @ResponseWrapper(localName = "deleteProjectResponse", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.DeleteProjectResponse")
    public void deleteProject(
        @WebParam(name = "project", targetNamespace = "")
        ru.trandefil.spring.generated.ProjectDTO project,
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.spring.generated.Session session
    );

    @WebMethod
    @RequestWrapper(localName = "updateProject", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.UpdateProject")
    @ResponseWrapper(localName = "updateProjectResponse", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.UpdateProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.trandefil.spring.generated.ProjectDTO updateProject(
        @WebParam(name = "project", targetNamespace = "")
        ru.trandefil.spring.generated.ProjectDTO project,
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.spring.generated.Session session
    );

    @WebMethod
    @RequestWrapper(localName = "saveProject", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.SaveProject")
    @ResponseWrapper(localName = "saveProjectResponse", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.SaveProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.trandefil.spring.generated.ProjectDTO saveProject(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "desc", targetNamespace = "")
        java.lang.String desc,
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.spring.generated.Session session
    );

    @WebMethod
    @RequestWrapper(localName = "getAllProjects", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.GetAllProjects")
    @ResponseWrapper(localName = "getAllProjectsResponse", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.GetAllProjectsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.trandefil.spring.generated.ProjectDTO> getAllProjects(
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.spring.generated.Session session
    );

    @WebMethod
    @RequestWrapper(localName = "getProjectById", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.GetProjectById")
    @ResponseWrapper(localName = "getProjectByIdResponse", targetNamespace = "http://generated.spring.trandefil.ru/", className = "ru.trandefil.spring.generated.GetProjectByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.trandefil.spring.generated.ProjectDTO getProjectById(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id,
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.spring.generated.Session session
    );
}
