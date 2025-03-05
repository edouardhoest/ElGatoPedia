package elgatopedia.project.repositories;

import elgatopedia.project.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findById(long id);

    @Query(value = "SELECT * FROM comment where cat_id = :id", nativeQuery = true)
    List<Comment> findAllByCatId(long id);
}
