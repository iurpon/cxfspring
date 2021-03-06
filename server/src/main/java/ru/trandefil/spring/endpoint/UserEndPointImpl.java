package ru.trandefil.spring.endpoint;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.trandefil.spring.dto.Result;
import ru.trandefil.spring.dto.UserDTO;
import ru.trandefil.spring.generated.UserEndPoint;
import ru.trandefil.spring.model.LoggedUser;
import ru.trandefil.spring.model.Session;
import ru.trandefil.spring.model.User;
import ru.trandefil.spring.service.UserService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
@WebService(endpointInterface = "ru.trandefil.spring.generated.UserEndPoint")
public class UserEndPointImpl implements UserEndPoint {

    @Autowired
    private UserService userService;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    @WebMethod
    public boolean deleteUserByName(@NonNull String name) {
        return userService.deleteByName(name);
    }

    @Override
    @WebMethod
    public UserDTO saveUser(@NonNull String name, @NonNull String pass, @NonNull String role) {
        final User user = userService.constractUser(name, pass, role);
        return getDTO(user);
    }

    @Override
    @WebMethod
    public UserDTO getUserByName(@NonNull String userName) {
        final User user = userService.getByName(userName);
        if (user == null) {
            return null;
        }
        return getDTO(user);
    }

    @Override
    @WebMethod
    public List<UserDTO> getAllUsers() {
        final List<User> users = userService.getAll();
        return getDTOList(users);
    }

    @Override
    @WebMethod
    public void userLogout() {

    }

    @Override
    @WebMethod
    public UserDTO updateUser(@NonNull UserDTO userDTO, @NonNull String pass) {
        if (pass.isEmpty()) {
            final User user = userService.getById(userDTO.getId());
            pass = user.getPassword();
        }
        userDTO.setPassword(pass);
        final User updated = userService.save(fromDTO(userDTO));
        return getDTO(updated);
    }

    @Override
    public Session registry(@NonNull final String userName, @NonNull final String password) {
        logger.info("================================ user endpoint registry");
        final User user = userService.constractUser(userName, password, "user");
        logger.info("=====================================created user " + user);
        logger.info("===================================== created Session ");
        return null;
    }

    private UserDTO getDTO(@NonNull User user) {
        final UserDTO dto = new UserDTO(user);
        return dto;
    }

    private List<UserDTO> getDTOList(@NonNull List<User> users) {
        final List<UserDTO> dtoList = new ArrayList<>();
        users.forEach(u -> dtoList.add(getDTO(u)));
        return dtoList;
    }

    private User fromDTO(@NonNull UserDTO dto) {
        final User user = new User(dto.getId(), dto.getName(), dto.getPassword(), dto.getRole());
        return user;
    }

    @Override
    @WebMethod
    public Result logout() {
        logger.info("======================== authendpoint logged()");
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LoggedUser loggedUser = null;
        if (principal instanceof UserDetails) {
            logger.info("========================== principal instance of UserDetails");
            loggedUser = (LoggedUser) principal;
        }
        logger.info("============================== logged user is null ? " + loggedUser + "  , principal ? " + principal);
        SecurityContextHolder.getContext().setAuthentication(null);
        return new Result(false);
    }

}
