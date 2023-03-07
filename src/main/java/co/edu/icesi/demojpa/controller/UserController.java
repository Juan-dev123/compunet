package co.edu.icesi.demojpa.controller;

import co.edu.icesi.demojpa.dto.UserCreateDTO;
import co.edu.icesi.demojpa.model.IcesiUser;
import co.edu.icesi.demojpa.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public IcesiUser createIcesiUser(@RequestBody UserCreateDTO user){
        return userService.save(user);
    }

    @GetMapping("/users/{id}")
    public IcesiUser getUserById(@PathVariable String id){
        return userService.findById(UUID.fromString(id)).orElseThrow();
    }
}
