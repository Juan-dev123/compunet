package co.edu.icesi.demojpa.mapper;

import co.edu.icesi.demojpa.dto.UserCreateDTO;
import co.edu.icesi.demojpa.model.IcesiUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    IcesiUser fromIcesiUserDTO(UserCreateDTO userCreateDTO);
    UserCreateDTO fromIcesiUser(IcesiUser icesiUser);
}
