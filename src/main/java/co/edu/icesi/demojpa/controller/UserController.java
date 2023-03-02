package co.edu.icesi.demojpa.controller;

import co.edu.icesi.demojpa.model.IcesiUser;
import co.edu.icesi.demojpa.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public IcesiUser createIcesiUser(@RequestBody IcesiUser user){
        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public IcesiUser getUserById(@PathVariable String id){
        return userRepository.findById(UUID.fromString(id)).orElseThrow();
    }
}
