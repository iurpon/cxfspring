package ru.trandefil.spring.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.trandefil.spring.exception.BadUserIdException;
import ru.trandefil.spring.model.Project;
import ru.trandefil.spring.model.Session;
import ru.trandefil.spring.model.User;
import ru.trandefil.spring.repository.ProjectRepository;
import ru.trandefil.spring.repository.UserRepository;
import ru.trandefil.spring.util.UUIDUtil;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void testContruct(){
        System.out.println("=============================PostConstruct test()");
    }

    @Autowired
    public void test(){
        System.out.println("=============================AUTOWIRED test()");
    }

    @Override
    @Transactional
    public Project save(@NonNull final Project project) {
        logger.info("============================= project save");
        if (project.isNew() || project.getId().isEmpty()) {
            project.setId(UUIDUtil.getUniqueString());
        }
        return projectRepository.save(project);
    }

    @Override
    public Project getById(@NonNull final String id) {
        logger.info("============================= project getById");
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(@NonNull final Project project) {
        logger.info("============================= project delete");
        projectRepository.delete(project);
    }

    @Override
    public List<Project> getAll() {
        logger.info("============================= project getAll");
        return projectRepository.getAll();
    }

    @Override
    @Transactional
    public void deleteById(@NonNull final String id) {
        logger.info("============================= project deleteById");
        projectRepository.deleteById(id);
    }

    @Override
    public Project getByName(@NonNull final String name) {
        return projectRepository.getByName(name);
    }

    @Override
    public Project saveNew(String name, String description, Session session) {
        final User user = userRepository.findById(session.getUserId()).orElse(null);
        final Project project = new Project(UUIDUtil.getUniqueString(),name,description,user);
        return projectRepository.save(project);
    }

    @Override
    public Project update(Project fromDTO) {
        return projectRepository.save(fromDTO);
    }

    @Override
    public void deleteByName(String projectName) {
        Project byName = projectRepository.getByName(projectName);
        projectRepository.delete(byName);
    }

    @Override
    @Transactional
    public Project update(Project project, String id) {
        if(!project.getId().equals(id)){
            throw new BadUserIdException("project bad id");
        }
        return projectRepository.save(project);
    }

}
