package pl.kuba.drive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.kuba.drive.entity.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "SELECT q FROM Question q JOIN q.advice a JOIN a.tags t WHERE t.name = :name")
    List<Question> findTrainingQuestions(String name);

}
