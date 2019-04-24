package ru.trandefil.spring.endpoint;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.trandefil.spring.dto.ProjectDTO;
import ru.trandefil.spring.generated.ProjectEndPoint;
import ru.trandefil.spring.model.LoggedUser;
import ru.trandefil.spring.model.Project;
import ru.trandefil.spring.model.User;
import ru.trandefil.spring.service.ProjectService;
import ru.trandefil.spring.service.UserService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
@WebService(endpointInterface = "ru.trandefil.spring.generated.ProjectEndPoint")
public class ProjectEndPointImpl implements ProjectEndPoint {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Override
    public ProjectDTO saveProject(@NonNull final String name, @NonNull final String description) {
        User user = new User(LoggedUser.getLoggedUser());
        logger.info("========================saving project for user  : " + user);
        final Project saved = projectService.saveNew(name, description, user);
        return getDTOproject(saved);
    }

    @Override
    public ProjectDTO updateProject(@NonNull final ProjectDTO project) {
        logger.info("===============================================updating project");
        final Project updated = projectService.update(fromDTO(project));
        return getDTOproject(updated);
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        logger.info("============================================= ProjectEndPoint getAllProjects");
//        final List<Project> projectList = projectService.getAll(session.getUserId());
        final List<Project> projectList = projectService.getAll();
        return getDTOProjectList(projectList);
    }

    @Override
    public ProjectDTO getProjectById(@NonNull final String id) {
//        Project project = projectService.getById(id, session.getUserId());
        Project project = projectService.getById(id);
        return getDTOproject(project);
    }

    @Override
    public void deleteProject(@NonNull final ProjectDTO projectDTO) {
        final Project project = fromDTO(projectDTO);
//        projectService.delete(session.getUserId(), project);
        projectService.delete(project);
    }

    @Override
    public void deleteProjectByName(@NonNull final String projectName) {
//        projectService.deleteByName(session.getUserId(), projectName);
        projectService.deleteByName(projectName);
    }

    @Override
    public ProjectDTO getProjectByName(@NonNull final String projectName) {
//        Project project = projectService.getByName(projectName, session.getUserId());
        Project project = projectService.getByName(projectName);
        if (project == null) {
            return null;
        }
        return getDTOproject(project);
    }

    private ProjectDTO getDTOproject(@NonNull final Project project) {
        final ProjectDTO dto = new ProjectDTO(project);
        return dto;
    }

    private List<ProjectDTO> getDTOProjectList(@NonNull final List<Project> projects) {
        final List<ProjectDTO> projectDTOList = new ArrayList<>();
        projects.forEach(p -> projectDTOList.add(getDTOproject(p)));
        return projectDTOList;
    }

    private Project fromDTO(@NonNull final ProjectDTO dto) {
        final User user = userService.getByName(dto.getUserName());
        final Project project = new Project(dto.getId(), dto.getName(), dto.getDescription(), user);
        return project;
    }

}
