package uz.boom.core_project_jwt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.Where;
import uz.boom.core_project_jwt.entity.base.Auditable;

/**
 * @author Jarvis on Tue 04:14. 18/04/23
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Where(clause = "deleted='FALSE'")
public class Glossary extends Auditable {

    private String title;

    private String definition;

    @ManyToOne
    private GlossaryType glossaryType;

}
