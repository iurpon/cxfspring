package ru.trandefil.spring.generated;

import ru.trandefil.spring.dto.TaskDTO;
import ru.trandefil.spring.model.Session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService
public interface TaskEndPoint {

    @WebMethod
    List<TaskDTO> getAllTasks();

    @WebMethod
    TaskDTO saveTask(
            @WebParam(name = "id") String id,
            @WebParam(name = "name") String name,
            @WebParam(name = "desc") String desc,
            @WebParam(name = "start") Date start,
            @WebParam(name = "end") Date end,
            @WebParam(name = "projectId") String projectId,
            @WebParam(name = "executorId") String executorId
    );

    @WebMethod
    TaskDTO updateTask(@WebParam(name = "task") TaskDTO task);

    @WebMethod
    boolean deleteTaskByName(@WebParam(name = "name") String name);

    @WebMethod
    TaskDTO getTaskByName(@WebParam(name = "name") String name);

}
