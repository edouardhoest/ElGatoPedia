package elgatopedia.project.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


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
    @JsonProperty(value = "picture_name")
    private String pictureName;
}
