package elgatopedia.project.repositories;

import elgatopedia.project.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    Cat findById(long id);

    @Query(value = "SELECT * FROM cat", nativeQuery = true)
    List<Cat> findAll();
}
