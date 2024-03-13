package rudnicka.a.ideas.question.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rudnicka.a.ideas.question.domain.model.Answer;
import rudnicka.a.ideas.question.domain.model.Question;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, UUID> {
    List<Answer> findByQuestionId (UUID questionId);
}
