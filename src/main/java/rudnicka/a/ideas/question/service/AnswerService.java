package rudnicka.a.ideas.question.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rudnicka.a.ideas.question.domain.model.Answer;
import rudnicka.a.ideas.question.domain.model.Question;
import rudnicka.a.ideas.question.domain.model.repository.AnswerRepository;
import rudnicka.a.ideas.question.domain.model.repository.QuestionRepository;

import java.util.List;
import java.util.UUID;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private  final QuestionRepository questionRepository;

    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    @Transactional(readOnly = true)
    public List<Answer> getAnswers(UUID questionId) {
        return answerRepository.findByQuestionId(questionId);
    }

    @Transactional(readOnly = true)
    public Answer getAnswer(UUID id) {
        return answerRepository.getById(id);
    }

    @Transactional
    public Answer createAnswer(UUID questionId, Answer answerRequest) {
        Answer answer = new Answer();

        answer.setName(answerRequest.getName());

        Question question = questionRepository.getById(questionId);
        question.addAnswer(answer);

        answerRepository.save(answer);
        questionRepository.save(question);

        return answer;
    }

    @Transactional
    public Answer updateAnswer(UUID answerId, Answer answerRequest) {
        Answer answer = answerRepository.getById(answerId);
        answer.setName(answerRequest.getName());

        return answerRepository.save(answer);
    }

    @Transactional
    public void deleteAnswer(UUID answerId) {
        answerRepository.deleteById(answerId);
    }
}
