package co.edu.icesi.demojpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IcesiUser {
    @Id
    private UUID userId;
    private String firstName;
    private String lastName;
    private boolean active;
    private String email;
    private String password;


    @OneToMany(mappedBy = "icesiUser")
    private List<IcesiBlogPost> icesiBlogPostList;
    @ManyToOne
    @JoinColumn(name = "icesiRole_roleId")
    private IcesiRole icesiRole;
}
