package pl.kuba.drive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuba.drive.entity.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {
}
