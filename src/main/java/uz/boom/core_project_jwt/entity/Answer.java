package uz.boom.core_project_jwt.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

/**
 * @author Jarvis on Fri 17:10. 14/04/23
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Where(clause = "deleted='FALSE'")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String answer;

    private Boolean isRight;

    @OneToOne
    private Question question;

    private Boolean deleted = false;
}
