package co.edu.icesi.demojpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Category {
    @Id
    private UUID categoryId;
    private String name;
    private String description;

    //El owner por buenas practicas es el que se consulta menos
    @ManyToMany
    @JoinTable(
            name = "category_icesiblogpost",
            joinColumns = @JoinColumn(name = "category_categoryId"),
            inverseJoinColumns = @JoinColumn(name = "icesiBlogPost_postId")
    )
    private List<IcesiBlogPost> icesiBlogPostList;
}
