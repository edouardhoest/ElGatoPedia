package elgatopedia.project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cat")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 500)
    private String description;
    private int age;

    @OneToMany(mappedBy = "cat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Picture> pictures;
}
