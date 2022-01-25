package pl.kuba.drive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuba.drive.entity.UserPoints;

public interface UserPointsRepository extends JpaRepository<UserPoints, Long> {
}
