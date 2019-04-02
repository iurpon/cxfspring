package ru.trandefil.spring.client;

import ru.trandefil.spring.endpoint.ProjectEndPointImplService;
import ru.trandefil.spring.endpoint.UserEndPointImplService;
import ru.trandefil.spring.generated.*;

import java.util.List;

public class ProductClient {

    public static void main(String[] args) {
        try {
            UserEndPoint userEndPoint = new UserEndPointImplService().getUserEndPointImplPort();
            Session session = userEndPoint.getSession("root", "root");
            if (session != null) {
                List<UserDTO> allUsers = userEndPoint.getAllUsers(session);
                allUsers.forEach(System.out::println);
            }

            ProjectEndPoint projectEndPoint = new ProjectEndPointImplService().getProjectEndPointImplPort();
            List<ProjectDTO> projects = projectEndPoint.getAllProjects(session);
            projects.forEach(System.out::println);

//            TaskEndPoint

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
