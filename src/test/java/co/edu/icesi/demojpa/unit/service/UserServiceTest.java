package co.edu.icesi.demojpa.unit.service;

import co.edu.icesi.demojpa.dto.UserCreateDTO;
import co.edu.icesi.demojpa.mapper.UserMapper;
import co.edu.icesi.demojpa.mapper.UserMapperImpl;
import co.edu.icesi.demojpa.model.IcesiUser;
import co.edu.icesi.demojpa.repository.UserRepository;
import co.edu.icesi.demojpa.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    private UserService userService;
    private UserRepository userRepository;
    private UserMapper userMapper;

    @BeforeEach
    private void init(){
        userRepository = mock(UserRepository.class);
        userMapper = spy(UserMapperImpl.class);
        userService = new UserService(userRepository, userMapper);
    }

    @Test
    public void testCreateUser(){
        IcesiUser icesiUser = userService.save(defaultUserCreateDTO());
        IcesiUser icesiUser1 = IcesiUser.builder()
                .firstName("Juan")
                .lastName("Torres")
                .active(true)
                .email("email@gmail.com")
                .password("password")
                .build();

        verify(userRepository, times(1)).save(argThat(new IcesiUserMatcher(icesiUser1)));
    }

    @Test
    public void testCreateUserWhenEmailAlreadyExists(){
        when(userRepository.findByEmail(any())).thenReturn(Optional.of(defaultIcesiUser()));
//        assertThrows(RuntimeException.class, () -> userService.save(defaultUserCreateDTO()));
        try{
            userService.save(defaultUserCreateDTO());
            fail();
        }catch (RuntimeException exception){
            String message = exception.getMessage();
            assertEquals("User already exists", message);
        }
    }

    private UserCreateDTO defaultUserCreateDTO(){
        return UserCreateDTO.builder()
                .firstName("Juan")
                .lastName("Torres")
                .active(true)
                .email("email@gmail.com")
                .password("password")
                .build();
    }

    private IcesiUser defaultIcesiUser(){
        return IcesiUser.builder()
                .firstName("Juan")
                .lastName("Torres")
                .active(true)
                .email("email@gmail.com")
                .password("password")
                .build();
    }
}
