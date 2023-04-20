package uz.boom.core_project_jwt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.Where;
import uz.boom.core_project_jwt.entity.base.Auditable;

import java.time.LocalDateTime;

/**
 * @author Jarvis on Fri 17:10. 14/04/23
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Where(clause = "deleted='FALSE'")
public class Quiz extends Auditable {

    private Integer size;
    private Boolean isClosed;
    private LocalDateTime duration;
    @ManyToOne
    private QuizType quizType;
}
