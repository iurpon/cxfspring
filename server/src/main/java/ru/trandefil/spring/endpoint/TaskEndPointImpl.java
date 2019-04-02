package ru.trandefil.spring.endpoint;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import ru.trandefil.spring.service.ProjectService;
import ru.trandefil.spring.service.TaskService;
import ru.trandefil.spring.service.UserService;
import ru.trandefil.spring.dto.TaskDTO;
import ru.trandefil.spring.exception.SecurityAuthentificationException;
import ru.trandefil.spring.generated.TaskEndPoint;
import ru.trandefil.spring.model.Project;
import ru.trandefil.spring.model.Session;
import ru.trandefil.spring.model.Task;
import ru.trandefil.spring.model.User;
import ru.trandefil.spring.util.SignatureUtil;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@WebService(endpointInterface = "ru.trandefil.spring.generated.TaskEndPoint")
public class TaskEndPointImpl implements TaskEndPoint {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private TaskService taskService;

    private ProjectService projectService;

    private UserService userService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @WebMethod
    @Override
    public List<TaskDTO> getAllTasks(@NonNull Session session) {
        logger.info("taskendpoint getAllTasks");
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
//        List<Task> tasks = taskService.getAll(session.getUserId());
        List<Task> tasks = taskService.getAll();
        logger.info("returning :" + tasks);
        return getTaskListDTO(tasks);
    }

    @WebMethod
    @Override
    public TaskDTO updateTask(@NonNull final TaskDTO taskDTO, @NonNull final Session session) {
        logger.info("taskendpoint updateTask");
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("auth exc.");
        }
        final Task task = getTaskEntity(taskDTO, session.getUserId());
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
            @WebParam(name = "executorId") @NonNull String executorId,
            @WebParam(name = "session") @NonNull Session session
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
    public boolean deleteTaskByName(@NonNull String name, @NonNull Session session) {
        logger.info("taskendpoint deleteByName");
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
//        boolean isDeleted = taskService.deleteByName(session.getUserId(), name);
        boolean isDeleted = taskService.deleteByName(name);
        logger.info("deleted ? " + isDeleted);
        return isDeleted;
    }

    @WebMethod
    @Override
    public TaskDTO getTaskByName(@NonNull String name, @NonNull Session session) {
        logger.info("taskendpoint getByName");
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
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
