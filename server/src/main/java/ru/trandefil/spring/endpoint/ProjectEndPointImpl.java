package ru.trandefil.spring.endpoint;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import ru.trandefil.spring.dto.ProjectDTO;
import ru.trandefil.spring.exception.SecurityAuthentificationException;
import ru.trandefil.spring.generated.ProjectEndPoint;
import ru.trandefil.spring.model.Project;
import ru.trandefil.spring.model.Session;
import ru.trandefil.spring.model.User;
import ru.trandefil.spring.service.ProjectService;
import ru.trandefil.spring.service.UserService;
import ru.trandefil.spring.util.SignatureUtil;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebService(endpointInterface = "ru.trandefil.spring.generated.ProjectEndPoint")
public class ProjectEndPointImpl implements ProjectEndPoint {

    private final Logger logger = Logger.getLogger(this.getClass().getName());


    private ProjectService projectService;


    private UserService userService;

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ProjectDTO saveProject(String name, String description, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        final Project saved = projectService.saveNew(name, description,session);
//        final Project saved = projectService.save(session.getUserId(), name, description);
        return getDTOproject(saved);
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO project, Session session) {
        logger.info("===============================================updating project");
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        final Project updated = projectService.update(fromDTO(project));
        return getDTOproject(updated);
    }

    @Override
    public List<ProjectDTO> getAllProjects(Session session) {
        logger.info("============================================= ProjectEndPoint getAllProjects");
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
//        final List<Project> projectList = projectService.getAll(session.getUserId());
        final List<Project> projectList = projectService.getAll();
        return getDTOProjectList(projectList);
    }

    @Override
    public ProjectDTO getProjectById(String id, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
//        Project project = projectService.getById(id, session.getUserId());
        Project project = projectService.getById(id);
        return getDTOproject(project);
    }

    @Override
    public void deleteProject(ProjectDTO projectDTO, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        final Project project = fromDTO(projectDTO);
//        projectService.delete(session.getUserId(), project);
        projectService.delete(project);
    }

    @Override
    public void deleteProjectByName(String projectName, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
//        projectService.deleteByName(session.getUserId(), projectName);
        projectService.deleteByName(projectName);
    }

    @Override
    public ProjectDTO getProjectByName(String projectName, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
//        Project project = projectService.getByName(projectName, session.getUserId());
        Project project = projectService.getByName(projectName);
        if (project == null) {
            return null;
        }
        return getDTOproject(project);
    }

    private ProjectDTO getDTOproject(@NonNull Project project) {
        final ProjectDTO dto = new ProjectDTO(project);
        return dto;
    }

    private List<ProjectDTO> getDTOProjectList(@NonNull List<Project> projects) {
        final List<ProjectDTO> projectDTOList = new ArrayList<>();
        projects.forEach(p -> projectDTOList.add(getDTOproject(p)));
        return projectDTOList;
    }

    private Project fromDTO(@NonNull ProjectDTO dto) {
        final User user = userService.getByName(dto.getUserName());
        final Project project = new Project(dto.getId(), dto.getName(), dto.getDescription(), user);
        return project;
    }

}
