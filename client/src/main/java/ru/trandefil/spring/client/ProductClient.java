package ru.trandefil.spring.client;

import ru.trandefil.spring.endpoint.ProjectEndPointImplService;
import ru.trandefil.spring.endpoint.UserEndPointImplService;
import ru.trandefil.spring.generated.*;
import ru.trandefil.spring.service.Product;
import ru.trandefil.spring.service.ProductService;

import java.util.List;

public class ProductClient {

    public static void main(String[] args) {
        try {
            ProductService productService = new ru.trandefil.spring.service.impl.ProductService().getProductServiceImplPort();
            Product product = productService.getProduct(101);
            System.out.println(product.getProductId());
            System.out.println(product.getProductName());
            System.out.println(product.getProductCatg());
            List<Product> list = productService.getAllProducts();
            list.forEach(System.out::println);

            UserEndPoint userEndPoint =  new UserEndPointImplService().getUserEndPointImplPort();
            Session session = userEndPoint.getSession("root", "root");
            if(session != null){
                List<UserDTO> allUsers = userEndPoint.getAllUsers(session);
                allUsers.forEach(System.out::println);
            }

            ProjectEndPoint projectEndPoint = new ProjectEndPointImplService().getProjectEndPointImplPort();
            List<ProjectDTO> projects = projectEndPoint.getAllProjects(session);
            projects.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
