package ru.trandefil.spring.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.trandefil.spring.enums.Role;
import ru.trandefil.spring.model.Session;
import ru.trandefil.spring.model.User;
import ru.trandefil.spring.repository.UserRepository;
import ru.trandefil.spring.util.HashUtil;
import ru.trandefil.spring.util.SignatureUtil;
import ru.trandefil.spring.util.UUIDUtil;

import java.util.List;
import java.util.logging.Logger;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getLoggedUser(@NonNull final String userName, @NonNull final String password) {
        logger.info("==================================== user service impl getLoggedUser");
        return userRepository.getLoggedUser(userName, password);
    }

    @Override
    @Transactional
    public User save(@NonNull final User user) {
        logger.info("==================================== user service impl save");
        if (user.isNew() || user.getId().isEmpty()) {
            user.setId(UUIDUtil.getUniqueString());
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        logger.info("==================================== user service impl getAll");
        return userRepository.getAll();
    }

    @Override
    @Transactional
    public void deleteById(@NonNull final String id) {
        logger.info("==================================== user service impl deleteById");
        userRepository.deleteById(id);
    }

    @Override
    public User getById(@NonNull final String id) {
        logger.info("==================================== user service impl getById");
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getByName(String name) {
        logger.info("==================================== user service impl getByName");
        return userRepository.getByName(name);
    }

    @Override
    public boolean deleteByName(@NonNull final String name) {
        userRepository.deleteByName(name);
        return false;
    }



    public Session getSession(@NonNull final String userName, @NonNull final String userPassword) {
        logger.info("====================================================get session");
        final User user = userRepository.getLoggedUser(userName, HashUtil.hashPassword(userPassword));
        if (user == null) {
            logger.info("---------------------------------------------------- bad user credential");
            return null;
        }
        logger.info("get form base user : " + user);
        final Session newSess = createNewSession(user.getId(), user.getRole());
        logger.info("created session : " + newSess);
        return newSess;
    }

    private Session createNewSession(@NonNull final String userId, @NonNull final Role role) {
        logger.info("create new sesion");
        final String uuid = UUIDUtil.getUniqueString();
        final long timeStamp = System.nanoTime();
        final String signature = SignatureUtil.createSignature(uuid, userId, timeStamp, role);
        final Session created = new Session(uuid, timeStamp, userId, role, signature);

        logger.info("=============================================created session : " + created);
        return created;
    }


    public void logout(@NonNull final Session session) {

    }


    public User constractUser(@NonNull final String name, @NonNull final String pass, @NonNull String role) {
        role = role.trim().toUpperCase();
        if ("ADMIN".equals(role) || "USER".equals(role)) {
            final Role newRole = Enum.valueOf(Role.class, role);
            final User newUser = new User(null, name, HashUtil.hashPassword(pass), newRole);
            System.out.println("created user : " + newUser);
            final User saved = save(newUser);
            return saved;
        }
        System.out.println("bad user role.");
        return null;
    }

}
