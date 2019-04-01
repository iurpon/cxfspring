package ru.trandefil.spring.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.trandefil.spring.model.Project;
import ru.trandefil.spring.repository.ProjectRepository;
import ru.trandefil.spring.util.UUIDUtil;

import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private ProjectRepository projectRepository;

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

}
