package co.edu.icesi.demojpa.service;

import co.edu.icesi.demojpa.dto.UserCreateDTO;
import co.edu.icesi.demojpa.mapper.UserMapper;
import co.edu.icesi.demojpa.model.IcesiUser;
import co.edu.icesi.demojpa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public IcesiUser save(UserCreateDTO user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new RuntimeException();
        }
        IcesiUser icesiUser = userMapper.fromIcesiUserDTO(user);
        icesiUser.setUserId(UUID.randomUUID());
        return userRepository.save(icesiUser);
    }

    public Optional<IcesiUser> findById(UUID fromString) {
        return null;
    }



}
