package ru.trandefil.spring.client;

import ru.trandefil.spring.endpoint.AuthEndPointImplService;
import ru.trandefil.spring.endpoint.ProjectEndPointImplService;
import ru.trandefil.spring.endpoint.TaskEndPointImplService;
import ru.trandefil.spring.endpoint.UserEndPointImplService;
import ru.trandefil.spring.generated.*;

import java.util.List;

public class ProductClient {

    public static void main(String[] args) {
        try {
            AuthEndPoint authEndPoint = new AuthEndPointImplService().getAuthEndPointImplPort();
            Result result = authEndPoint.login("root", "root");
            System.out.println(result);
            LoggedUser logged = authEndPoint.logged();
            System.out.println(logged);
/*            UserEndPoint userEndPoint = new UserEndPointImplService().getUserEndPointImplPort();
            Session session = userEndPoint.getSession("root", "root");
            if (session != null) {
                List<UserDTO> allUsers = userEndPoint.getAllUsers(session);
                allUsers.forEach(System.out::println);
            }

            ProjectEndPoint projectEndPoint = new ProjectEndPointImplService().getProjectEndPointImplPort();
            List<ProjectDTO> projects = projectEndPoint.getAllProjects(session);
            projects.forEach(System.out::println);

            TaskEndPoint taskEndPoint = new TaskEndPointImplService().getTaskEndPointImplPort();
            List<TaskDTO> taskDTOS = taskEndPoint.getAllTasks(session);
            taskDTOS.forEach(System.out::println);*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
