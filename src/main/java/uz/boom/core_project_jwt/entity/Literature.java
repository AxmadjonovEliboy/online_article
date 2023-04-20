package uz.boom.core_project_jwt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.annotations.Where;
import uz.boom.core_project_jwt.entity.base.Auditable;
import uz.boom.core_project_jwt.enums.LiteratureType;

/**
 * @author Jarvis on Tue 03:18. 18/04/23
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Where(clause = "deleted='FALSE'")
public class Literature extends Auditable {

    private String title;

    @Enumerated(EnumType.STRING)
    private LiteratureType literatureType;

}
