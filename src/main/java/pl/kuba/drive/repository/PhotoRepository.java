package pl.kuba.drive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuba.drive.entity.Photo;


public interface PhotoRepository extends JpaRepository<Photo, Long> {


}
