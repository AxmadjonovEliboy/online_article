package uz.boom.core_project_jwt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jarvis on Sat 00:42. 15/04/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quizId;

    private Long questionId;

    private Long answerId;

    private Boolean isRight;

    public QuizQuestion(Long quizId, Long questionId, Long answerId, Boolean isRight) {
        this.quizId = quizId;
        this.questionId = questionId;
        this.answerId = answerId;
        this.isRight = isRight;
    }
}
