package elgatopedia.project.repositories;

import elgatopedia.project.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
    Picture findById(long id);

    @Query(value = "SELECT * FROM picture where cat_id = :id", nativeQuery = true)
    List<Picture> findAllByCatId(long id);
}
