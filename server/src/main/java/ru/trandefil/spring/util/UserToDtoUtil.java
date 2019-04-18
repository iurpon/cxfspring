package ru.trandefil.spring.util;

import ru.trandefil.spring.dto.UserDTO;
import ru.trandefil.spring.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserToDtoUtil {

    public static UserDTO toDTO(User user){
        return new UserDTO(user);
    }

    public static List<UserDTO> toDTOList(List<User> users){
        return users.stream().map(UserToDtoUtil::toDTO)
                .collect(Collectors.toList());
    }

}
