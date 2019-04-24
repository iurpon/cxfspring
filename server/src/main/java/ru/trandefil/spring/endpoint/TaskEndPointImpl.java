package ru.trandefil.spring.endpoint;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.trandefil.spring.model.*;
import ru.trandefil.spring.service.ProjectService;
import ru.trandefil.spring.service.TaskService;
import ru.trandefil.spring.service.UserService;
import ru.trandefil.spring.dto.TaskDTO;
import ru.trandefil.spring.exception.SecurityAuthentificationException;
import ru.trandefil.spring.generated.TaskEndPoint;
import ru.trandefil.spring.util.SignatureUtil;
import sun.rmi.runtime.Log;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Component
@WebService(endpointInterface = "ru.trandefil.spring.generated.TaskEndPoint")
public class TaskEndPointImpl implements TaskEndPoint {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;


    @WebMethod
    @Override
    public List<TaskDTO> getAllTasks() {
        logger.info("taskendpoint getAllTasks");
//        List<Task> tasks = taskService.getAll(session.getUserId());
        List<Task> tasks = taskService.getAll();
        logger.info("returning :" + tasks);
        return getTaskListDTO(tasks);
    }

    @WebMethod
    @Override
    public TaskDTO updateTask(@NonNull final TaskDTO taskDTO) {
        logger.info("taskendpoint updateTask");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!(principal instanceof UserDetails)) return null;
        String principalId = ((LoggedUser) principal).getId();
        final Task task = getTaskEntity(taskDTO, principalId);
//        final Task updated = taskService.save(session.getUserId(), task);
        final Task updated = taskService.save(task);
        final TaskDTO dto = getTaskDTO(updated);
        logger.info("returning dto : " + dto);
        return dto;
    }

    @WebMethod
    @Override
    public TaskDTO saveTask(
            @WebParam(name = "id") String id,
            @WebParam(name = "name") @NonNull String name,
            @WebParam(name = "desc") @NonNull String desc,
            @WebParam(name = "start") Date start,
            @WebParam(name = "end") Date end,
            @WebParam(name = "projectId") @NonNull String projectId,
            @WebParam(name = "executorId") @NonNull String executorId
    ) {
/*        logger.info("taskendpoint saveTask ");
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        final Project project = projectService.getById(projectId, session.getUserId());
        final User assignee = userService.getById(session.getUserId());
        final User executor = userService.getById(executorId);
        final Task newTask = new Task(id, name, desc, start, end, project, assignee, executor);
        final Task saved = taskService.save(session.getUserId(), newTask);
        logger.info("taskendpoint returning " + saved);
        return getTaskDTO(saved);*/
        return null;
    }

    @WebMethod
    @Override
    public boolean deleteTaskByName(@NonNull String name) {
        logger.info("taskendpoint deleteByName");

//        boolean isDeleted = taskService.deleteByName(session.getUserId(), name);
        boolean isDeleted = taskService.deleteByName(name);
        logger.info("deleted ? " + isDeleted);
        return isDeleted;
    }

    @WebMethod
    @Override
    public TaskDTO getTaskByName(@NonNull String name) {
        logger.info("taskendpoint getByName");

        Task task = taskService.getByName( name);
//        Task task = taskService.getByName(session.getUserId(), name);
        logger.info("returning " + task);
        return getTaskDTO(task);
    }

    private TaskDTO getTaskDTO(@NonNull Task task) {
        return new TaskDTO(task);
    }

    private List<TaskDTO> getTaskListDTO(@NonNull List<Task> tasks) {
        final List<TaskDTO> taskDTOS = new ArrayList<>();
        tasks.forEach(task -> taskDTOS.add(getTaskDTO(task)));
        return taskDTOS;
    }

    private Task getTaskEntity(@NonNull TaskDTO taskDTO, String userId) {
//        final Project project = projectService.getByName(userId, taskDTO.getProjectId());
        final Project project = projectService.getByName(taskDTO.getProjectId());
        final User assigner = userService.getByName(taskDTO.getAssigneeId());
        final User executor = userService.getByName(taskDTO.getExecutorId());
/*        return new Task(taskDTO.getId(), taskDTO.getName(),
                taskDTO.getDescription(), taskDTO.getBegin(), taskDTO.getEnd(),
                project, assigner, executor);*/
        return null;
    }

}
