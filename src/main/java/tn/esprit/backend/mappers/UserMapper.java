package tn.esprit.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.backend.Dto.SignUpDto;
import tn.esprit.backend.Dto.UserDto;
import tn.esprit.backend.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
@Mapping(target = "password",ignore = true)
    User SignUptoUser(SignUpDto signUpDto);
}
