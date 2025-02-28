package elgatopedia.project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Cat cat;
    @Column(length = 1024)
    private String comment;
    @Column(length = 20)
    private String username;
}
