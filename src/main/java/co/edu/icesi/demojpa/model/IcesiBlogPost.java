package co.edu.icesi.demojpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class IcesiBlogPost {
    @Id
    private UUID postId;
    private String content;
    private String title;
    @ManyToOne
    @JoinColumn(name = "icesiUser_userId")
    private IcesiUser icesiUser;

    @ManyToMany(mappedBy = "icesiBlogPostList")
    private List<Category> categoryList;
}
