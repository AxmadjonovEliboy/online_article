package uz.boom.core_project_jwt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author Jarvis on Tue 03:19. 18/04/23
 */

@Getter
@AllArgsConstructor
public enum LiteratureType {

    LITERATURE("literature"),
    ADDITION_LITERATURE("addition_literature");

    private final String name;

    public static LiteratureType getByName(String literatureName) {
        if (Objects.isNull(literatureName)) return LiteratureType.LITERATURE;
        for (LiteratureType value : LiteratureType.values()) {
            if (value.name.equalsIgnoreCase(literatureName)) return value;
        }
        return LiteratureType.LITERATURE;
    }
}
