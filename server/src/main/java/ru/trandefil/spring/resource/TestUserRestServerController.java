package ru.trandefil.spring.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.trandefil.spring.dto.UserDTO;
import ru.trandefil.spring.service.UserService;
import ru.trandefil.spring.util.UserToDtoUtil;

@RestController
@RequestMapping(value = "/rest")
public class TestUserRestServerController implements AbstractDTOController {

    @Autowired
    private UserService userService;

    @Override
    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getDTO(@PathVariable("id") String id) {
        return UserToDtoUtil.toDTO(userService.getById(id));
    }

}
