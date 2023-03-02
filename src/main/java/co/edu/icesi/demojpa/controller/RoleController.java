package co.edu.icesi.demojpa.controller;

import co.edu.icesi.demojpa.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RoleController {
    private final RoleRepository roleRepository;
}
