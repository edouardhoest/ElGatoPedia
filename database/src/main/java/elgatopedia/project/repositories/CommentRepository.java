package elgatopedia.project.repositories;

import elgatopedia.project.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findById(long id);

    @Query(value = "SELECT * FROM comment where picture_id = :id", nativeQuery = true)
    Comment findByPictureId(long id);
}
