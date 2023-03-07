package co.edu.icesi.demojpa.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserCreateDTO {
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String email;
    private String password;
}
