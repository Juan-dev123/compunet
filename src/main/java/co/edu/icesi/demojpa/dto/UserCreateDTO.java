package co.edu.icesi.demojpa.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserCreateDTO {
    private String firstName;
    private String lastName;
    private boolean active;
    private String email;
    private String password;
}
