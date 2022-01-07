package pl.kuba.drive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.kuba.drive.entity.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {


}
