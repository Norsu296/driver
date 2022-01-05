package pl.kuba.drive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuba.drive.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
