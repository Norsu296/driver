package pl.kuba.drive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.kuba.drive.entity.Photo;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    @Query("select p from Photo p where p.advice.id = :id")
    List<Photo> findByAdviceId(Long id);

}
