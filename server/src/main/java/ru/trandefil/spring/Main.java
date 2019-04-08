package ru.trandefil.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.trandefil.spring.service.ProjectService;

public class Main {

    public static void main(String[] args) {
        System.out.println("STARTS : ");
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("spring-beans.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
        ProjectService projectService = context.getBean(ProjectService.class);
        System.out.println("ProjectService : " + projectService);
        projectService.toString();
    }

}
