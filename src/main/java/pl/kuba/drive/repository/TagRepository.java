package pl.kuba.drive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuba.drive.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
