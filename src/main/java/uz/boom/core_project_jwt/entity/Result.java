package uz.boom.core_project_jwt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import uz.boom.core_project_jwt.entity.base.Auditable;

/**
 * @author Jarvis on Fri 17:10. 14/04/23
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString
public class Result extends Auditable {

    @OneToOne
    private AuthUser authUser;

    private String result;

    private Long quizId;

    private String optional;


}
