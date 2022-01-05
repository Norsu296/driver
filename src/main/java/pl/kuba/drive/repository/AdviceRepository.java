package pl.kuba.drive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuba.drive.entity.Advice;

public interface AdviceRepository extends JpaRepository<Advice, Long> {
}
