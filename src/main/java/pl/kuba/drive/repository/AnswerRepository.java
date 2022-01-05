package pl.kuba.drive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuba.drive.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
