package co.edu.icesi.demojpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class IcesiUser {
    @Id
    private UUID userId;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String email;
    private String password;

    @OneToMany(mappedBy = "icesiUser")
    private List<IcesiBlogPost> icesiBlogPostList;
    @ManyToOne
    @JoinColumn(name = "icesiRole_roleId")
    private IcesiRole icesiRole;
}
