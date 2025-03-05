package elgatopedia.project.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "picture")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Cat cat;

    @Column(length = 50)
    @JsonProperty(value = "picture_name")
    private String pictureName;

    @Lob
    @Column(name = "picture_data", columnDefinition = "LONGBLOB")
    @JsonProperty(value = "picture_data")
    private byte[] pictureData;
}
