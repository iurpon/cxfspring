package ru.trandefil.spring.resource;

import ru.trandefil.spring.dto.UserDTO;

public interface AbstractDTOController {

    UserDTO getDTO(String id);

}
