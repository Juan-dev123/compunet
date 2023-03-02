package co.edu.icesi.demojpa.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class IcesiUser {
    @Id
    private UUID userId;
    private String firstName;
    private String lastName;
    private String code;
}
