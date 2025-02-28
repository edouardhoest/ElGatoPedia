package elgatopedia.project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "picture")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Cat cat;
    @Column(length = 1000)
    private String url;
    @Column(length = 50)
    private String picture_name;

    @OneToMany(mappedBy = "picture", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;
}
