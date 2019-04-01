
package ru.trandefil.spring.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.trandefil.spring.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteProject_QNAME = new QName("http://generated.spring.trandefil.ru/", "deleteProject");
    private final static QName _DeleteProjectByName_QNAME = new QName("http://generated.spring.trandefil.ru/", "deleteProjectByName");
    private final static QName _DeleteProjectByNameResponse_QNAME = new QName("http://generated.spring.trandefil.ru/", "deleteProjectByNameResponse");
    private final static QName _DeleteProjectResponse_QNAME = new QName("http://generated.spring.trandefil.ru/", "deleteProjectResponse");
    private final static QName _GetAllProjects_QNAME = new QName("http://generated.spring.trandefil.ru/", "getAllProjects");
    private final static QName _GetAllProjectsResponse_QNAME = new QName("http://generated.spring.trandefil.ru/", "getAllProjectsResponse");
    private final static QName _GetProjectById_QNAME = new QName("http://generated.spring.trandefil.ru/", "getProjectById");
    private final static QName _GetProjectByIdResponse_QNAME = new QName("http://generated.spring.trandefil.ru/", "getProjectByIdResponse");
    private final static QName _GetProjectByName_QNAME = new QName("http://generated.spring.trandefil.ru/", "getProjectByName");
    private final static QName _GetProjectByNameResponse_QNAME = new QName("http://generated.spring.trandefil.ru/", "getProjectByNameResponse");
    private final static QName _SaveProject_QNAME = new QName("http://generated.spring.trandefil.ru/", "saveProject");
    private final static QName _SaveProjectResponse_QNAME = new QName("http://generated.spring.trandefil.ru/", "saveProjectResponse");
    private final static QName _UpdateProject_QNAME = new QName("http://generated.spring.trandefil.ru/", "updateProject");
    private final static QName _UpdateProjectResponse_QNAME = new QName("http://generated.spring.trandefil.ru/", "updateProjectResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.trandefil.spring.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteProject }
     * 
     */
    public DeleteProject createDeleteProject() {
        return new DeleteProject();
    }

    /**
     * Create an instance of {@link DeleteProjectByName }
     * 
     */
    public DeleteProjectByName createDeleteProjectByName() {
        return new DeleteProjectByName();
    }

    /**
     * Create an instance of {@link DeleteProjectByNameResponse }
     * 
     */
    public DeleteProjectByNameResponse createDeleteProjectByNameResponse() {
        return new DeleteProjectByNameResponse();
    }

    /**
     * Create an instance of {@link DeleteProjectResponse }
     * 
     */
    public DeleteProjectResponse createDeleteProjectResponse() {
        return new DeleteProjectResponse();
    }

    /**
     * Create an instance of {@link GetAllProjects }
     * 
     */
    public GetAllProjects createGetAllProjects() {
        return new GetAllProjects();
    }

    /**
     * Create an instance of {@link GetAllProjectsResponse }
     * 
     */
    public GetAllProjectsResponse createGetAllProjectsResponse() {
        return new GetAllProjectsResponse();
    }

    /**
     * Create an instance of {@link GetProjectById }
     * 
     */
    public GetProjectById createGetProjectById() {
        return new GetProjectById();
    }

    /**
     * Create an instance of {@link GetProjectByIdResponse }
     * 
     */
    public GetProjectByIdResponse createGetProjectByIdResponse() {
        return new GetProjectByIdResponse();
    }

    /**
     * Create an instance of {@link GetProjectByName }
     * 
     */
    public GetProjectByName createGetProjectByName() {
        return new GetProjectByName();
    }

    /**
     * Create an instance of {@link GetProjectByNameResponse }
     * 
     */
    public GetProjectByNameResponse createGetProjectByNameResponse() {
        return new GetProjectByNameResponse();
    }

    /**
     * Create an instance of {@link SaveProject }
     * 
     */
    public SaveProject createSaveProject() {
        return new SaveProject();
    }

    /**
     * Create an instance of {@link SaveProjectResponse }
     * 
     */
    public SaveProjectResponse createSaveProjectResponse() {
        return new SaveProjectResponse();
    }

    /**
     * Create an instance of {@link UpdateProject }
     * 
     */
    public UpdateProject createUpdateProject() {
        return new UpdateProject();
    }

    /**
     * Create an instance of {@link UpdateProjectResponse }
     * 
     */
    public UpdateProjectResponse createUpdateProjectResponse() {
        return new UpdateProjectResponse();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link ProjectDTO }
     * 
     */
    public ProjectDTO createProjectDTO() {
        return new ProjectDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "deleteProject")
    public JAXBElement<DeleteProject> createDeleteProject(DeleteProject value) {
        return new JAXBElement<DeleteProject>(_DeleteProject_QNAME, DeleteProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProjectByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "deleteProjectByName")
    public JAXBElement<DeleteProjectByName> createDeleteProjectByName(DeleteProjectByName value) {
        return new JAXBElement<DeleteProjectByName>(_DeleteProjectByName_QNAME, DeleteProjectByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProjectByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "deleteProjectByNameResponse")
    public JAXBElement<DeleteProjectByNameResponse> createDeleteProjectByNameResponse(DeleteProjectByNameResponse value) {
        return new JAXBElement<DeleteProjectByNameResponse>(_DeleteProjectByNameResponse_QNAME, DeleteProjectByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "deleteProjectResponse")
    public JAXBElement<DeleteProjectResponse> createDeleteProjectResponse(DeleteProjectResponse value) {
        return new JAXBElement<DeleteProjectResponse>(_DeleteProjectResponse_QNAME, DeleteProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProjects }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "getAllProjects")
    public JAXBElement<GetAllProjects> createGetAllProjects(GetAllProjects value) {
        return new JAXBElement<GetAllProjects>(_GetAllProjects_QNAME, GetAllProjects.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProjectsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "getAllProjectsResponse")
    public JAXBElement<GetAllProjectsResponse> createGetAllProjectsResponse(GetAllProjectsResponse value) {
        return new JAXBElement<GetAllProjectsResponse>(_GetAllProjectsResponse_QNAME, GetAllProjectsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "getProjectById")
    public JAXBElement<GetProjectById> createGetProjectById(GetProjectById value) {
        return new JAXBElement<GetProjectById>(_GetProjectById_QNAME, GetProjectById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "getProjectByIdResponse")
    public JAXBElement<GetProjectByIdResponse> createGetProjectByIdResponse(GetProjectByIdResponse value) {
        return new JAXBElement<GetProjectByIdResponse>(_GetProjectByIdResponse_QNAME, GetProjectByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "getProjectByName")
    public JAXBElement<GetProjectByName> createGetProjectByName(GetProjectByName value) {
        return new JAXBElement<GetProjectByName>(_GetProjectByName_QNAME, GetProjectByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "getProjectByNameResponse")
    public JAXBElement<GetProjectByNameResponse> createGetProjectByNameResponse(GetProjectByNameResponse value) {
        return new JAXBElement<GetProjectByNameResponse>(_GetProjectByNameResponse_QNAME, GetProjectByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "saveProject")
    public JAXBElement<SaveProject> createSaveProject(SaveProject value) {
        return new JAXBElement<SaveProject>(_SaveProject_QNAME, SaveProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "saveProjectResponse")
    public JAXBElement<SaveProjectResponse> createSaveProjectResponse(SaveProjectResponse value) {
        return new JAXBElement<SaveProjectResponse>(_SaveProjectResponse_QNAME, SaveProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "updateProject")
    public JAXBElement<UpdateProject> createUpdateProject(UpdateProject value) {
        return new JAXBElement<UpdateProject>(_UpdateProject_QNAME, UpdateProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.spring.trandefil.ru/", name = "updateProjectResponse")
    public JAXBElement<UpdateProjectResponse> createUpdateProjectResponse(UpdateProjectResponse value) {
        return new JAXBElement<UpdateProjectResponse>(_UpdateProjectResponse_QNAME, UpdateProjectResponse.class, null, value);
    }

}
