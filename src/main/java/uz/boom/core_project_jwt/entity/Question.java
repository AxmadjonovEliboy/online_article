package uz.boom.core_project_jwt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.Where;
import uz.boom.core_project_jwt.entity.base.Auditable;
import uz.boom.core_project_jwt.enums.Language;
import uz.boom.core_project_jwt.enums.Level;

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
public class Question extends Auditable {

    private String title;

    //    @Enumerated(EnumType.STRING)
    private Level level;

    //    @Enumerated(EnumType.STRING)
    private Language language;

    @ManyToOne
    private QuizType quizType;

}
